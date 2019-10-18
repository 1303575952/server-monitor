package com.sxu.dao.app;

import com.sxu.entity.app.AppState;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface AppStateDao {

    List<AppState> selectAllByParams(Map<String, Object> map) throws Exception;

    List<AppState> selectByParams(Map<String, Object> params) throws Exception;

    AppState selectById(String id) throws Exception;

    int selectByParamsCount(Map<String, Object> map);

    void save(AppState AppState) throws Exception;

    void insertList(List<AppState> recordList) throws Exception;

    int deleteByAppInfoId(String appInfoId) throws Exception;

    int deleteByAppInfoIdsAndDate(Map<String, Object> map) throws Exception;

    int deleteById(String[] id) throws Exception;

}
