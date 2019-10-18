package com.sxu.service.host;

import com.sxu.common.Page;
import com.sxu.dao.host.MemStateDao;
import com.sxu.entity.host.MemState;
import com.github.pagehelper.PageHelper;
import com.sxu.util.DateUtil;
import com.sxu.util.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class MemStateService {

    @Autowired
    private MemStateDao memStateDao;

    public Page selectByParams(Map<String, Object> params, int currPage, int pageSize) throws Exception {
        PageHelper.startPage(currPage, pageSize);
        List<MemState> list = memStateDao.selectByParams(params);
        return new Page(list, pageSize, Integer.valueOf(((com.github.pagehelper.Page) list).getTotal() + ""), currPage);
    }

    public void save(MemState MemState) throws Exception {
        MemState.setId(UUIDUtil.getUUID());
        MemState.setCreateTime(DateUtil.getNowTime());
        MemState.setDateStr(DateUtil.getDateTimeString(MemState.getCreateTime()));
        memStateDao.save(MemState);
    }

    public void saveRecord(List<MemState> recordList) throws Exception {
        for (MemState as : recordList) {
            as.setId(UUIDUtil.getUUID());
            as.setDateStr(DateUtil.getDateTimeString(as.getCreateTime()));
        }
        memStateDao.insertList(recordList);
    }

    public int deleteById(String[] id) throws Exception {
        return memStateDao.deleteById(id);
    }

    public MemState selectById(String id) throws Exception {
        return memStateDao.selectById(id);
    }

    public List<MemState> selectAllByParams(Map<String, Object> params) throws Exception {
        return memStateDao.selectAllByParams(params);
    }

}
