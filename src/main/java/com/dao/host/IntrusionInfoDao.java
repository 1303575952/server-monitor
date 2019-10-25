package com.dao.host;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.entity.host.IntrusionInfo;

/**
 * @Description: 查看系统入侵信息
 */
@Repository
public interface IntrusionInfoDao {

    List<IntrusionInfo> selectAllByParams(Map<String, Object> map) throws Exception;

    List<IntrusionInfo> selectByAccountId(String accountId) throws Exception;

    List<IntrusionInfo> selectByParams(Map<String, Object> params) throws Exception;

    IntrusionInfo selectById(String id) throws Exception;

    void save(IntrusionInfo IntrusionInfo) throws Exception;

    void insertList(List<IntrusionInfo> recordList) throws Exception;

    int deleteById(String[] id) throws Exception;

    int deleteByAccountAndDate(Map<String, Object> map) throws Exception;

    int deleteByAccHname(Map<String, Object> map) throws Exception;

}
