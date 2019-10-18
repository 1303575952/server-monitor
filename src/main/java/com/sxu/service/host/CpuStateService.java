package com.sxu.service.host;

import com.sxu.common.Page;
import com.sxu.dao.host.CpuStateDao;
import com.sxu.entity.host.CpuState;
import com.github.pagehelper.PageHelper;
import com.sxu.util.DateUtil;
import com.sxu.util.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CpuStateService {

    @Autowired
    private CpuStateDao cpuStateDao;

    public Page selectByParams(Map<String, Object> params, int currPage, int pageSize) throws Exception {
        PageHelper.startPage(currPage, pageSize);
        List<CpuState> list = cpuStateDao.selectByParams(params);
        return new Page(list, pageSize, Integer.valueOf(((com.github.pagehelper.Page) list).getTotal() + ""), currPage);
    }

    public void save(CpuState CpuState) throws Exception {
        CpuState.setId(UUIDUtil.getUUID());
        CpuState.setCreateTime(DateUtil.getNowTime());
        CpuState.setDateStr(DateUtil.getDateTimeString(CpuState.getCreateTime()));
        cpuStateDao.save(CpuState);
    }

    public void saveRecord(List<CpuState> recordList) throws Exception {
        for (CpuState as : recordList) {
            as.setId(UUIDUtil.getUUID());
            as.setDateStr(DateUtil.getDateTimeString(as.getCreateTime()));
        }
        cpuStateDao.insertList(recordList);
    }

    public int deleteById(String[] id) throws Exception {
        return cpuStateDao.deleteById(id);
    }

    public CpuState selectById(String id) throws Exception {
        return cpuStateDao.selectById(id);
    }

    public List<CpuState> selectAllByParams(Map<String, Object> params) throws Exception {
        return cpuStateDao.selectAllByParams(params);
    }
}
