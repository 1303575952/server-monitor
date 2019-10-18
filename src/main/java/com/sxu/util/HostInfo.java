package com.sxu.util;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @Description: hostIP密码等信息
 */
@Getter
@Setter
public class HostInfo implements Serializable {

    private static final long serialVersionUID = 3875927332935900938L;

    /**
     * 主键
     */
    private String id;

    /**
     * ssh端口
     */
    private int sshPort = 22;

    /**
     * host名称
     */
    private String hostname;

    /**
     * 用户
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 创建时间
     */
    private Timestamp createTime;

}