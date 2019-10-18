package com.sxu.dao.host;

import com.sxu.entity.host.MemState;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface MemStateDao {

    List<MemState> selectAllByParams(Map<String, Object> map) throws Exception;

    List<MemState> selectByParams(Map<String, Object> params) throws Exception;

    MemState selectById(String id) throws Exception;

    void save(MemState MemState) throws Exception;

    void insertList(List<MemState> recordList) throws Exception;

    int deleteByAccountAndDate(Map<String, Object> map) throws Exception;

    int deleteById(String[] id) throws Exception;

}
