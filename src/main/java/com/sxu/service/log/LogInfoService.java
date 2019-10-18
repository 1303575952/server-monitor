package com.sxu.service.log;

import com.sxu.common.Page;
import com.sxu.dao.log.LogInfoDao;
import com.sxu.entity.log.LogInfo;
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
public class LogInfoService {

    private static final Logger logger = LoggerFactory.getLogger(LogInfoService.class);

    @Autowired
    private LogInfoDao logInfoDao;

    public Page selectByParams(Map<String, Object> params, int currPage, int pageSize) throws Exception {
        PageHelper.startPage(currPage, pageSize);
        List<LogInfo> list = logInfoDao.selectByParams(params);
        return new Page(list, pageSize, Integer.valueOf(((com.github.pagehelper.Page) list).getTotal() + ""), currPage);
    }

    public void save(String account, String hostname, String infoContent, String state) {
        LogInfo logInfo = new LogInfo();
        logInfo.setAccount(account);
        logInfo.setHostname(hostname);
        logInfo.setInfoContent(infoContent);
        logInfo.setState(state);
        logInfo.setId(UUIDUtil.getUUID());
        logInfo.setCreateTime(DateUtil.getNowTime());
        try {
            logInfoDao.save(logInfo);
        } catch (Exception e) {
            logger.error("保存日志信息异常：", e);
        }
    }

    public int deleteById(String[] id) throws Exception {
        return logInfoDao.deleteById(id);
    }

    public LogInfo selectById(String id) throws Exception {
        return logInfoDao.selectById(id);
    }

    public List<LogInfo> selectAllByParams(Map<String, Object> params) throws Exception {
        return logInfoDao.selectAllByParams(params);
    }
}
