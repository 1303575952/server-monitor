package com.sxu.service.app;

import com.sxu.common.Page;
import com.sxu.dao.app.AppStateDao;
import com.sxu.entity.app.AppState;
import com.github.pagehelper.PageHelper;
import com.sxu.util.DateUtil;
import com.sxu.util.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class AppStateService {

    @Autowired
    private AppStateDao appStateDao;

    public Page selectByParams(Map<String, Object> params, int currPage, int pageSize) throws Exception {
        PageHelper.startPage(currPage, pageSize);
        List<AppState> list = appStateDao.selectByParams(params);
        return new Page(list, pageSize, Integer.valueOf(((com.github.pagehelper.Page) list).getTotal() + ""), currPage);
    }

    public void save(AppState AppState) throws Exception {
        AppState.setId(UUIDUtil.getUUID());
        AppState.setCreateTime(DateUtil.getNowTime());
        appStateDao.save(AppState);
    }

    public void saveRecord(List<AppState> recordList) throws Exception {
        for (AppState as : recordList) {
            as.setId(UUIDUtil.getUUID());
        }
        appStateDao.insertList(recordList);
    }

    public int deleteByAppInfoId(String appInfoId) throws Exception {
        return appStateDao.deleteByAppInfoId(appInfoId);
    }


    public int deleteById(String[] id) throws Exception {
        return appStateDao.deleteById(id);
    }

    public AppState selectById(String id) throws Exception {
        return appStateDao.selectById(id);
    }

    public List<AppState> selectAllByParams(Map<String, Object> params) throws Exception {
        return appStateDao.selectAllByParams(params);
    }

}
