package com.sxu.impl;

import com.sxu.common.ApplicationContextHelper;
import com.sxu.service.app.AppStateService;
import com.sxu.service.host.*;
import com.sxu.util.DateUtil;
import com.sxu.util.staticvar.BatchData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.TimerTask;

/**
 * @Description: 每5分钟39秒时候批量提交监控数据
 */
public class BatchCommitJobImpl extends TimerTask {

    private static final Logger logger = LoggerFactory.getLogger(BatchCommitJobImpl.class);

    @Override
    public void run() {
        timingTask();
    }

    public void timingTask() {
        logger.info("批量提交监控数据任务开始----------" + DateUtil.getCurrentDateTime());
        CpuStateService cpuStateService = ApplicationContextHelper.getBean(CpuStateService.class);
        MemStateService memStateService = ApplicationContextHelper.getBean(MemStateService.class);
        NetIoStateService netIoStateService = ApplicationContextHelper.getBean(NetIoStateService.class);
        SysLoadStateService sysLoadStateService = ApplicationContextHelper.getBean(SysLoadStateService.class);
        TcpStateService tcpStateService = ApplicationContextHelper.getBean(TcpStateService.class);
        AppStateService appStateService = ApplicationContextHelper.getBean(AppStateService.class);
        DiskIoStateService diskIoStateService = ApplicationContextHelper.getBean(DiskIoStateService.class);
        IntrusionInfoService intrusionInfoService = ApplicationContextHelper.getBean(IntrusionInfoService.class);
        try {
            synchronized (BatchData.DISKIO_STATE_LIST) {
                if (BatchData.DISKIO_STATE_LIST.size() > 0) {
                    diskIoStateService.saveRecord(BatchData.DISKIO_STATE_LIST);
                    BatchData.DISKIO_STATE_LIST.clear();
                }
            }
            synchronized (BatchData.APP_STATE_LIST) {
                if (BatchData.APP_STATE_LIST.size() > 0) {
                    appStateService.saveRecord(BatchData.APP_STATE_LIST);
                    BatchData.APP_STATE_LIST.clear();
                }
            }
            synchronized (BatchData.CPU_STATE_LIST) {
                if (BatchData.CPU_STATE_LIST.size() > 0) {
                    cpuStateService.saveRecord(BatchData.CPU_STATE_LIST);
                    BatchData.CPU_STATE_LIST.clear();
                }
            }
            synchronized (BatchData.MEM_STATE_LIST) {
                if (BatchData.MEM_STATE_LIST.size() > 0) {
                    memStateService.saveRecord(BatchData.MEM_STATE_LIST);
                    BatchData.MEM_STATE_LIST.clear();
                }
            }
            synchronized (BatchData.NETIO_STATE_LIST) {
                if (BatchData.NETIO_STATE_LIST.size() > 0) {
                    netIoStateService.saveRecord(BatchData.NETIO_STATE_LIST);
                    BatchData.NETIO_STATE_LIST.clear();
                }
            }
            synchronized (BatchData.SYSLOAD_STATE_LIST) {
                if (BatchData.SYSLOAD_STATE_LIST.size() > 0) {
                    sysLoadStateService.saveRecord(BatchData.SYSLOAD_STATE_LIST);
                    BatchData.SYSLOAD_STATE_LIST.clear();
                }
            }
            synchronized (BatchData.TCP_STATE_LIST) {
                if (BatchData.TCP_STATE_LIST.size() > 0) {
                    tcpStateService.saveRecord(BatchData.TCP_STATE_LIST);
                    BatchData.TCP_STATE_LIST.clear();
                }
            }
            synchronized (BatchData.INTRUSION_INFO_LIST) {
                if (BatchData.INTRUSION_INFO_LIST.size() > 0) {
                    intrusionInfoService.saveRecord(BatchData.INTRUSION_INFO_LIST);
                    BatchData.INTRUSION_INFO_LIST.clear();
                }
            }
        } catch (Exception e) {
            logger.error("批量提交监控数据异常----------", e);
        }
        logger.info("批量提交监控数据任务结束----------" + DateUtil.getCurrentDateTime());
    }

}
