package com.dao.app;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.entity.app.AppInfo;

@Repository
public interface AppInfoDao {

    List<AppInfo> selectAllByParams(Map<String, Object> map) throws Exception;

    List<AppInfo> selectByParams(Map<String, Object> params) throws Exception;

    AppInfo selectById(String id) throws Exception;

    List<AppInfo> selectByAccountId(String accountId) throws Exception;

    void save(AppInfo AppInfo) throws Exception;

    int deleteById(String[] id) throws Exception;

    AppInfo updateById(AppInfo AppInfo) throws Exception;
}
