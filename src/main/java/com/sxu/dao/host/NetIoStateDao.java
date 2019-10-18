package com.sxu.dao.host;

import com.sxu.entity.host.NetIoState;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface NetIoStateDao {

    List<NetIoState> selectAllByParams(Map<String, Object> map) throws Exception;

    List<NetIoState> selectByParams(Map<String, Object> params);

    NetIoState selectById(String id) throws Exception;

    void save(NetIoState NetIoState) throws Exception;

    void insertList(List<NetIoState> recordList) throws Exception;

    int deleteByAccountAndDate(Map<String, Object> map) throws Exception;

    int deleteById(String[] id) throws Exception;

}