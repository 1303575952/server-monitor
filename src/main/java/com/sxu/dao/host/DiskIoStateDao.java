package com.sxu.dao.host;

import com.sxu.entity.host.DiskIoState;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface DiskIoStateDao {

    List<DiskIoState> selectAllByParams(Map<String, Object> map) throws Exception;

    List<DiskIoState> selectByParams(Map<String, Object> params) throws Exception;

    DiskIoState selectById(String id) throws Exception;

    void save(DiskIoState DiskIoState) throws Exception;

    void insertList(List<DiskIoState> recordList) throws Exception;

    int deleteByAccountAndDate(Map<String, Object> map) throws Exception;

    int deleteById(String[] id) throws Exception;

}
