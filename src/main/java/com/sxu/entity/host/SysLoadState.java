package com.sxu.entity.host;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description: uptime查看系统负载状态
 */
@Getter
@Setter
public class SysLoadState implements Serializable {

    private static final long serialVersionUID = -4863071148000213553L;

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
     * 1分钟之前到现在的负载
     */
    private String oneLoad;

    /**
     * 5分钟之前到现在的负载
     */
    private String fiveLoad;

    /**
     * 15分钟之前到现在的负载
     */
    private String fifteenLoad;

    /**
     * 登录用户数量
     */
    private String users;

    /**
     * 添加时间
     * yyyy-MM-dd hh:mm:ss
     */
    private String dateStr;

    /**
     * 创建时间
     */
    private Date createTime;

    public String getDateStr() {
        if (!StringUtils.isEmpty(dateStr) && dateStr.length() > 16) {
            return dateStr.substring(5);
        }
        return dateStr;
    }
}