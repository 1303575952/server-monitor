package com.sxu.entity.log;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
public class LogInfo implements Serializable {

    private static final long serialVersionUID = 1565538727002722890L;

    /**
     * 主键
     */
    private String id;

    /**
     * 用户帐号
     */
    private String account;

    /**
     * host名称
     */
    private String hostname;

    /**
     * 描述
     */
    private String infoContent;

    /**
     * 0成功，1失败
     */
    private String state;

    /**
     * 创建时间
     */
    private Date createTime;
}