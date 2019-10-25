package com.dao.host;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.entity.host.SysLoadState;

/**
 * @Description: 查看uptime查看系统负载状态
 */
@Repository
public interface SysLoadStateDao {

    List<SysLoadState> selectAllByParams(Map<String, Object> map) throws Exception;

    List<SysLoadState> selectByParams(Map<String, Object> params) throws Exception;

    SysLoadState selectById(String id) throws Exception;

    void save(SysLoadState SysLoadState) throws Exception;

    void insertList(List<SysLoadState> recordList) throws Exception;

    int deleteByAccountAndDate(Map<String, Object> map) throws Exception;

    int deleteById(String[] id) throws Exception;

}
