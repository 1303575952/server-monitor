package com.sxu.entity.host;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description: 查看TCP连接状态
 */
@Getter
@Setter
public class TcpState implements Serializable {

    private static final long serialVersionUID = -299667815095138020L;

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
     * 每秒本地发起的TCP连接数，既通过connect调用创建的TCP连接；,active/s
     */
    private String active;

    /**
     * 每秒远程发起的TCP连接数，即通过accept调用创建的TCP连接,passive/s
     */
    private String passive;

    /**
     * 每秒TCP重传数量,retrans/s
     */
    private String retrans;

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

    public void setDateStr(String dateStr) {
        this.dateStr = dateStr;
    }
}