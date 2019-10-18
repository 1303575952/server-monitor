package com.sxu.service.host;

import com.sxu.common.Page;
import com.sxu.dao.host.NetIoStateDao;
import com.sxu.entity.host.NetIoState;
import com.github.pagehelper.PageHelper;
import com.sxu.util.DateUtil;
import com.sxu.util.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class NetIoStateService {

    @Autowired
    private NetIoStateDao netIoStateDao;

    public Page selectByParams(Map<String, Object> params, int currPage, int pageSize) throws Exception {
        PageHelper.startPage(currPage, pageSize);
        List<NetIoState> list = netIoStateDao.selectByParams(params);
        return new Page(list, pageSize, Integer.valueOf(((com.github.pagehelper.Page) list).getTotal() + ""), currPage);
    }

    public void save(NetIoState NetIoState) throws Exception {
        NetIoState.setId(UUIDUtil.getUUID());
        NetIoState.setCreateTime(DateUtil.getNowTime());
        NetIoState.setDateStr(DateUtil.getDateTimeString(NetIoState.getCreateTime()));
        netIoStateDao.save(NetIoState);
    }

    public void saveRecord(List<NetIoState> recordList) throws Exception {
        for (NetIoState as : recordList) {
            as.setId(UUIDUtil.getUUID());
            as.setDateStr(DateUtil.getDateTimeString(as.getCreateTime()));
        }
        netIoStateDao.insertList(recordList);
    }

    public int deleteById(String[] id) throws Exception {
        return netIoStateDao.deleteById(id);
    }

    public NetIoState selectById(String id) throws Exception {
        return netIoStateDao.selectById(id);
    }

    public List<NetIoState> selectAllByParams(Map<String, Object> params) throws Exception {
        return netIoStateDao.selectAllByParams(params);
    }
}
