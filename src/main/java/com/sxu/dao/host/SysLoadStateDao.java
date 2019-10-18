package com.sxu.dao.host;

import com.sxu.entity.host.SysLoadState;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

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
