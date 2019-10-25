package com.dao.host;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.entity.host.CpuState;

@Repository
public interface CpuStateDao {

    List<CpuState> selectAllByParams(Map<String, Object> map) throws Exception;

    List<CpuState> selectByParams(Map<String, Object> params) throws Exception;

    CpuState selectById(String id) throws Exception;

    int selectByParamsCount(Map<String, Object> map);

    void save(CpuState CpuState) throws Exception;

    void insertList(List<CpuState> recordList) throws Exception;

    int deleteByAccountAndDate(Map<String, Object> map) throws Exception;

    int deleteById(String[] id) throws Exception;

}
