package com.sxu.entity.msg;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
public class MsgInfo implements Serializable {

    private static final long serialVersionUID = -1095416867542650521L;

    /**
     * 主键
     */
    private String id;

    /**
     * 用户Id
     */
    private String accountId;

    /**
     * 用户帐号
     */
    private String account;

    /**
     * 接受消息的邮箱或者手机号码
     */
    private String acceptInfo;

    /**
     * 消息正文
     */
    private String infoContent;

    /**
     * 消息标题
     */
    private String msgTitle;

    /**
     * 创建时间
     */
    private Date createTime;
}