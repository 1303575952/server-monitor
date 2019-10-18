package com.sxu.service.host;

import com.sxu.common.Page;
import com.sxu.dao.host.DiskIoStateDao;
import com.sxu.entity.host.DiskIoState;
import com.github.pagehelper.PageHelper;
import com.sxu.util.DateUtil;
import com.sxu.util.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class DiskIoStateService {

    @Autowired
    private DiskIoStateDao diskIoStateDao;

    public Page selectByParams(Map<String, Object> params, int currPage, int pageSize) throws Exception {
        PageHelper.startPage(currPage, pageSize);
        List<DiskIoState> list = diskIoStateDao.selectByParams(params);
        return new Page(list, pageSize, Integer.valueOf(((com.github.pagehelper.Page) list).getTotal() + ""), currPage);
    }

    public void save(DiskIoState DiskIoState) throws Exception {
        DiskIoState.setId(UUIDUtil.getUUID());
        DiskIoState.setCreateTime(DateUtil.getNowTime());
        DiskIoState.setDateStr(DateUtil.getDateTimeString(DiskIoState.getCreateTime()));
        diskIoStateDao.save(DiskIoState);
    }

    public void saveRecord(List<DiskIoState> recordList) throws Exception {
        for (DiskIoState as : recordList) {
            as.setId(UUIDUtil.getUUID());
            as.setDateStr(DateUtil.getDateTimeString(as.getCreateTime()));
        }
        diskIoStateDao.insertList(recordList);
    }

    public int deleteById(String[] id) throws Exception {
        return diskIoStateDao.deleteById(id);
    }

    public DiskIoState selectById(String id) throws Exception {
        return diskIoStateDao.selectById(id);
    }

    public List<DiskIoState> selectAllByParams(Map<String, Object> params) throws Exception {
        return diskIoStateDao.selectAllByParams(params);
    }

}
