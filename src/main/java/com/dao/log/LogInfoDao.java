package com.dao.log;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.entity.log.LogInfo;

/**
 * @Description: 查看日志信息
 */
@Repository
public interface LogInfoDao {

    List<LogInfo> selectAllByParams(Map<String, Object> map);

    List<LogInfo> selectByParams(Map<String, Object> params) throws Exception;

    LogInfo selectById(String id) throws Exception;

    void save(LogInfo LogInfo) throws Exception;

    int deleteById(String[] id) throws Exception;

    int deleteByDate(Map<String, Object> map) throws Exception;

}
