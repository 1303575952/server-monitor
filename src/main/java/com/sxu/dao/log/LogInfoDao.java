package com.sxu.dao.log;

import com.sxu.entity.log.LogInfo;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface LogInfoDao {

    List<LogInfo> selectAllByParams(Map<String, Object> map);

    List<LogInfo> selectByParams(Map<String, Object> params) throws Exception;

    LogInfo selectById(String id) throws Exception;

    void save(LogInfo LogInfo) throws Exception;

    int deleteById(String[] id) throws Exception;

    int deleteByDate(Map<String, Object> map) throws Exception;

}
