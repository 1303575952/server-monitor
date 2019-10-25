package com.dao.host;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.entity.host.DeskState;

/**
 * @Description: 查看磁盘大小使用信息
 */
@Repository
public interface DeskStateDao {

    List<DeskState> selectAllByParams(Map<String, Object> map) throws Exception;

    List<DeskState> selectByParams(Map<String, Object> params) throws Exception;

    DeskState selectById(String id) throws Exception;

    void save(DeskState DeskState) throws Exception;

    int deleteByAccountAndDate(Map<String, Object> map) throws Exception;

    int deleteById(String[] id) throws Exception;

    int deleteByAccHname(Map<String, Object> map) throws Exception;

}
