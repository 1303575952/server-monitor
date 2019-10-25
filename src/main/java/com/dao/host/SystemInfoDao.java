package com.dao.host;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.entity.host.SystemInfo;

/**
 * @Description: 查看系统信息
 */
@Repository
public interface SystemInfoDao {


    List<SystemInfo> selectAllByParams(Map<String, Object> map) throws Exception;

    List<SystemInfo> selectByAccountId(String accountId) throws Exception;

    List<SystemInfo> selectByParams(Map<String, Object> params);

    SystemInfo selectById(String id) throws Exception;

    void save(SystemInfo SystemInfo) throws Exception;

    int deleteById(String[] id) throws Exception;

    int deleteByAccountAndDate(Map<String, Object> map) throws Exception;

    int deleteByAccHname(Map<String, Object> map) throws Exception;

}
