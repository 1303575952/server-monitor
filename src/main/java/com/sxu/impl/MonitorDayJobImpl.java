package com.sxu.impl;

import com.sxu.common.ApplicationContextHelper;
import com.sxu.dao.app.AppInfoDao;
import com.sxu.dao.app.AppStateDao;
import com.sxu.dao.host.*;
import com.sxu.dao.log.LogInfoDao;
import com.sxu.dao.msg.MsgInfoDao;
import com.sxu.entity.app.AppInfo;
import com.sxu.util.DateUtil;
import com.sxu.util.msg.WarnPools;
import com.sxu.util.staticvar.StaticKeys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

/**
 * @Description: 每天1点删除历史信息
 */
public class MonitorDayJobImpl extends TimerTask {

    private static final Logger logger = LoggerFactory.getLogger(MonitorDayJobImpl.class);

    @Override
    public void run() {
        timingTask();
    }

    public void timingTask() {
        logger.info("定时清空历史数据任务开始----------" + DateUtil.getCurrentDateTime());
        WarnPools.clearOldData();//清空发告警邮件的记录
        String nowTime = DateUtil.getCurrentDateTime();
        //3天前时间
        String oneDayBefore = DateUtil.getDateBefore(nowTime, 3);
        //30天前时间
        String sevenDayBefore = DateUtil.getDateBefore(nowTime, 30);
        Map<String, Object> paramsDel = new HashMap<String, Object>();
        SystemInfoDao systemInfoDao = ApplicationContextHelper.getBean(SystemInfoDao.class);
        CpuStateDao cpuStateDao = ApplicationContextHelper.getBean(CpuStateDao.class);
        DeskStateDao deskStateDao = ApplicationContextHelper.getBean(DeskStateDao.class);
        MemStateDao memStateDao = ApplicationContextHelper.getBean(MemStateDao.class);
        NetIoStateDao netIoStateDao = ApplicationContextHelper.getBean(NetIoStateDao.class);
        SysLoadStateDao sysLoadStateDao = ApplicationContextHelper.getBean(SysLoadStateDao.class);
        TcpStateDao tcpStateDao = ApplicationContextHelper.getBean(TcpStateDao.class);
        AppInfoDao appInfoDao = ApplicationContextHelper.getBean(AppInfoDao.class);
        AppStateDao appStateDao = ApplicationContextHelper.getBean(AppStateDao.class);
        DiskIoStateDao diskIoStateDao = ApplicationContextHelper.getBean(DiskIoStateDao.class);
        IntrusionInfoDao intrusionInfoDao = ApplicationContextHelper.getBean(IntrusionInfoDao.class);
        List<AppInfo> appInfoList = null;
        try {
            appInfoList = appInfoDao.selectAllByParams(null);
            paramsDel.put(StaticKeys.SEARCH_END_TIME, sevenDayBefore);
            paramsDel.put("accountId", StaticKeys.ADMIN_ACCOUNT);

            //执行删除操作begin
            if (paramsDel.get(StaticKeys.SEARCH_END_TIME) != null && !"".equals(paramsDel.get(StaticKeys.SEARCH_END_TIME))) {
                cpuStateDao.deleteByAccountAndDate(paramsDel);//删除cpu监控信息
                deskStateDao.deleteByAccountAndDate(paramsDel);//删除磁盘监控信息
                memStateDao.deleteByAccountAndDate(paramsDel);//删除内存监控信息
                netIoStateDao.deleteByAccountAndDate(paramsDel);//删除吞吐率监控信息
                sysLoadStateDao.deleteByAccountAndDate(paramsDel);//删除负载状态监控信息
                tcpStateDao.deleteByAccountAndDate(paramsDel);//删除tcp监控信息
                diskIoStateDao.deleteByAccountAndDate(paramsDel);//删除磁盘IO监控信息
                //删除进程监控信息
                if (appInfoList.size() > 0) {
                    paramsDel.put("appInfoIds", getAppInfoIdList(appInfoList));
                    appStateDao.deleteByAppInfoIdsAndDate(paramsDel);
                }
                //删除3天前服务器系统信息和入侵检测信息
                paramsDel.put(StaticKeys.SEARCH_END_TIME, oneDayBefore);
                systemInfoDao.deleteByAccountAndDate(paramsDel);
                intrusionInfoDao.deleteByAccountAndDate(paramsDel);
            }
            //执行删除操作end

            //删除30天前的日志信息
            LogInfoDao logInfoDao = ApplicationContextHelper.getBean(LogInfoDao.class);
            String thrityDayBefore = DateUtil.getDateBefore(nowTime, 30);
            paramsDel.put(StaticKeys.SEARCH_END_TIME, thrityDayBefore);
            logInfoDao.deleteByDate(paramsDel);

            //删除30天前的信息发送记录
            MsgInfoDao msgInfoDao = ApplicationContextHelper.getBean(MsgInfoDao.class);
            msgInfoDao.deleteByDate(paramsDel);

        } catch (Exception e) {
            logger.info("定时清空历史数据任务出错：", e);
        }
        logger.info("定时清空历史数据任务结束----------" + DateUtil.getCurrentDateTime());
    }

    /**
     * 取出AppInfo集合中的id
     *
     * @param list
     * @return
     */
    private List<String> getAppInfoIdList(List<AppInfo> list) {
        List<String> idList = new ArrayList<String>();
        for (AppInfo info : list) {
            idList.add(info.getId());
        }
        return idList;
    }
}
