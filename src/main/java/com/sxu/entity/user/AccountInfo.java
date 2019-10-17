package com.sxu.entity.user;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
public class AccountInfo implements Serializable {

    private static final long serialVersionUID = 6588957485475759299L;

    /**
     * 主键
     */
    private String id;

    /**
     * 登录帐号
     */
    private String account;

    /**
     * key标识
     */
    private String accountMd5;

    /**
     * 用户角色，admin管理员，user普通用户,test测试用户
     */
    private String role;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 密码
     */
    private String passwd;

    /**
     * 手机号码
     */
    private String phone;

    /**
     * 过期时间
     */
    private Date expDate;

    /**
     * 真实姓名
     */
    private String realName;
}