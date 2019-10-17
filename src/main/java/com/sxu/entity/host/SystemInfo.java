package com.sxu.entity.host;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @Description: 查看系统信息
 */
@Getter
@Setter
public class SystemInfo implements Serializable {

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
     * 系统版本信息
     */
    private String version;

    /**
     * 系统版本详细信息
     */
    private String versionDetail;

    /**
     * 物理CPU个数
     */
    private String cpuNum;

    /**
     * 每个物理CPU中core的个数(即核数)
     */
    private String cpuCoreNum;

    /**
     * 系统已经运行了多少天
     */
    private String yxDays;

    /**
     * CPU型号信息
     */
    private String cpuXh;

    /**
     * 创建时间
     */
    private Timestamp createTime;
}