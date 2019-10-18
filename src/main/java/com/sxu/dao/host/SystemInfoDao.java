package com.sxu.dao.host;

import com.sxu.entity.host.SystemInfo;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

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
