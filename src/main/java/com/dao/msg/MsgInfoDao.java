package com.dao.msg;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.entity.msg.MsgInfo;

/**
 * @Description: 信息发送记录
 */
@Repository
public interface MsgInfoDao {

    List<MsgInfo> selectAllByParams(Map<String, Object> map) throws Exception;

    List<MsgInfo> selectByParams(Map<String, Object> params) throws Exception;

    MsgInfo selectById(String id) throws Exception;

    void save(MsgInfo MsgInfo) throws Exception;

    int deleteById(String[] id) throws Exception;

    int deleteByDate(Map<String, Object> map) throws Exception;

}
