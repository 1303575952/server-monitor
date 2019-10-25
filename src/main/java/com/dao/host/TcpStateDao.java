package com.dao.host;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.entity.host.TcpState;

/**
 * @Description: 查看TCP连接状态
 */
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
