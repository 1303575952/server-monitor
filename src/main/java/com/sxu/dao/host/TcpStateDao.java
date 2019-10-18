package com.sxu.dao.host;

import com.sxu.entity.host.TcpState;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface TcpStateDao {

    List<TcpState> selectAllByParams(Map<String, Object> map) throws Exception;

    List<TcpState> selectByParams(Map<String, Object> params) throws Exception;

    TcpState selectById(String id) throws Exception;

    void save(TcpState TcpState) throws Exception;

    void insertList(List<TcpState> recordList) throws Exception;

    int deleteByAccountAndDate(Map<String, Object> map) throws Exception;

    int deleteById(String[] id) throws Exception;

}