package com.sxu.service.app;

import com.sxu.common.Page;
import com.sxu.dao.app.AppInfoDao;
import com.sxu.dao.app.AppStateDao;
import com.sxu.entity.app.AppInfo;
import com.github.pagehelper.PageHelper;
import com.sxu.util.DateUtil;
import com.sxu.util.UUIDUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
public class AppInfoService {

    @Autowired
    private AppInfoDao appInfoDao;
    @Autowired
    private AppStateDao appStateDao;

    public Page selectByParams(Map<String, Object> params, int currPage, int pageSize) throws Exception {
        PageHelper.startPage(currPage, pageSize);
        List<AppInfo> list = appInfoDao.selectByParams(params);
        return new Page(list, pageSize, Integer.valueOf(((com.github.pagehelper.Page) list).getTotal() + ""), currPage);
    }

    public void save(AppInfo AppInfo) throws Exception {
        AppInfo.setId(UUIDUtil.getUUID());
        AppInfo.setCreateTime(DateUtil.getNowTime());
        if (!StringUtils.isEmpty(AppInfo.getAppPid())) {
            AppInfo.setAppPid(AppInfo.getAppPid().trim());
        }
        appInfoDao.save(AppInfo);
    }

    @Transactional
    public int deleteById(String[] id) throws Exception {
        for (String AppInfoId : id) {
            appStateDao.deleteByAppInfoId(AppInfoId);
        }
        return appInfoDao.deleteById(id);
    }

    public AppInfo updateById(AppInfo AppInfo)
            throws Exception {
        return appInfoDao.updateById(AppInfo);
    }

    public AppInfo selectById(String id) throws Exception {
        return appInfoDao.selectById(id);
    }

    public List<AppInfo> selectAllByParams(Map<String, Object> params) throws Exception {
        return appInfoDao.selectAllByParams(params);
    }

}
