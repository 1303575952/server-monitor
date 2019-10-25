package com.dao.host;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.common.Page;
import com.entity.host.DeskState;
import com.entity.host.MemState;

/**
 * @Description: 查看内存使用情况
 */
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
