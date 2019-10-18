package com.sxu.service.msg;

import com.sxu.common.Page;
import com.sxu.dao.msg.MsgInfoDao;
import com.sxu.entity.msg.MsgInfo;
import com.github.pagehelper.PageHelper;
import com.sxu.util.DateUtil;
import com.sxu.util.UUIDUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class MsgInfoService {

    private static final Logger logger = LoggerFactory.getLogger(MsgInfoService.class);

    @Autowired
    private MsgInfoDao msgInfoDao;

    public Page selectByParams(Map<String, Object> params, int currPage, int pageSize) throws Exception {
        PageHelper.startPage(currPage, pageSize);
        List<MsgInfo> list = msgInfoDao.selectByParams(params);
        return new Page(list, pageSize, Integer.valueOf(((com.github.pagehelper.Page) list).getTotal() + ""), currPage);
    }

    public void save(String account, String accountId, String msgTitle, String infoContent, String acceptInfo) {
        MsgInfo MsgInfo = new MsgInfo();
        MsgInfo.setAccount(account);
        MsgInfo.setAccountId(accountId);
        MsgInfo.setMsgTitle(msgTitle);
        MsgInfo.setInfoContent(infoContent);
        MsgInfo.setAcceptInfo(acceptInfo);
        MsgInfo.setId(UUIDUtil.getUUID());
        MsgInfo.setCreateTime(DateUtil.getNowTime());
        try {
            msgInfoDao.save(MsgInfo);
        } catch (Exception e) {
            logger.error("保存信息发送记录异常：", e);
        }
    }

    public int deleteById(String[] id) throws Exception {
        return msgInfoDao.deleteById(id);
    }

    public MsgInfo selectById(String id) throws Exception {
        return msgInfoDao.selectById(id);
    }

    public List<MsgInfo> selectAllByParams(Map<String, Object> params) throws Exception {
        return msgInfoDao.selectAllByParams(params);
    }
}
