package com.sxu.service.host;

import com.sxu.common.Page;
import com.sxu.dao.host.TcpStateDao;
import com.sxu.entity.host.TcpState;
import com.github.pagehelper.PageHelper;
import com.sxu.util.DateUtil;
import com.sxu.util.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class TcpStateService {

    @Autowired
    private TcpStateDao tcpStateDao;

    public Page selectByParams(Map<String, Object> params, int currPage, int pageSize) throws Exception {
        PageHelper.startPage(currPage, pageSize);
        List<TcpState> list = tcpStateDao.selectByParams(params);
        return new Page(list, pageSize, Integer.valueOf(((com.github.pagehelper.Page) list).getTotal() + ""), currPage);
    }

    public void save(TcpState TcpState) throws Exception {
        TcpState.setId(UUIDUtil.getUUID());
        TcpState.setCreateTime(DateUtil.getNowTime());
        TcpState.setDateStr(DateUtil.getDateTimeString(TcpState.getCreateTime()));
        tcpStateDao.save(TcpState);
    }

    public void saveRecord(List<TcpState> recordList) throws Exception {
        for (TcpState as : recordList) {
            as.setId(UUIDUtil.getUUID());
            as.setDateStr(DateUtil.getDateTimeString(as.getCreateTime()));
        }
        tcpStateDao.insertList(recordList);
    }

    public int deleteById(String[] id) throws Exception {
        return tcpStateDao.deleteById(id);
    }

    public TcpState selectById(String id) throws Exception {
        return tcpStateDao.selectById(id);
    }

    public List<TcpState> selectAllByParams(Map<String, Object> params) throws Exception {
        return tcpStateDao.selectAllByParams(params);
    }
}
