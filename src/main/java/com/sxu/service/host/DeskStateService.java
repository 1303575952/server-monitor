package com.sxu.service.host;

import com.sxu.common.Page;
import com.sxu.dao.host.DeskStateDao;
import com.sxu.entity.host.DeskState;
import com.github.pagehelper.PageHelper;
import com.sxu.util.DateUtil;
import com.sxu.util.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class DeskStateService {

    @Autowired
    private DeskStateDao deskStateDao;

    public Page selectByParams(Map<String, Object> params, int currPage, int pageSize) throws Exception {
        PageHelper.startPage(currPage, pageSize);
        List<DeskState> list = deskStateDao.selectByParams(params);
        return new Page(list, pageSize, Integer.valueOf(((com.github.pagehelper.Page) list).getTotal() + ""), currPage);
    }

    public void save(DeskState DeskState) throws Exception {
        DeskState.setId(UUIDUtil.getUUID());
        DeskState.setCreateTime(DateUtil.getNowTime());
        DeskState.setDateStr(DateUtil.getDateTimeString(DeskState.getCreateTime()));
        deskStateDao.save(DeskState);
    }

    public int deleteById(String[] id) throws Exception {
        return deskStateDao.deleteById(id);
    }

    public DeskState selectById(String id) throws Exception {
        return deskStateDao.selectById(id);
    }

    public List<DeskState> selectAllByParams(Map<String, Object> params) throws Exception {
        return deskStateDao.selectAllByParams(params);
    }

    public int deleteByAccHname(Map<String, Object> params) throws Exception {
        return deskStateDao.deleteByAccHname(params);
    }

}
