package com.sxu.entity.app;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
public class AppInfo implements Serializable {

    private static final long serialVersionUID = 5274341324086778531L;

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
     * 应用进程ID
     */
    private String appPid;

    /**
     * 应用进程名称
     */
    private String appName;

    /**
     * 创建时间
     */
    private Date createTime;
}
