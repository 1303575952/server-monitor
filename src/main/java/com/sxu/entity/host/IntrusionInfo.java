package com.sxu.entity.host;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @Description: 检查系统入侵信息
 */
@Getter
@Setter
public class IntrusionInfo implements Serializable {

    private static final long serialVersionUID = 879979812204191283L;

    /**
     * 主键
     */
    private String id;

    /**
     * 用户id
     */
    private String accountId;

    /**
     * 用户帐号
     */
    private String account;

    /**
     * host名称
     */
    private String hostname;

    /**
     * 系统内核模块
     */
    private String lsmod;

    /**
     * 查看passwd文件修改时间
     */
    private String passwdInfo;

    /**
     * 查看系统计划任务
     */
    private String crontab;

    /**
     * 检查网络，正常网卡不该在promisc模式，可能存在sniffer
     */
    private String promisc;

    /**
     * 系统rpc服务
     */
    private String rpcinfo;

    /**
     * 创建时间
     */
    private Timestamp createTime;
}