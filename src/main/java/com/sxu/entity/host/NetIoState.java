package com.sxu.entity.host;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description: 网络设备的吞吐率
 */
@Getter
@Setter
public class NetIoState implements Serializable {

    private static final long serialVersionUID = -8314012397341825158L;

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
     * 每秒钟接收的数据包,rxpck/s
     */
    private String rxpck;

    /**
     * 每秒钟发送的数据包,txpck/s
     */
    private String txpck;

    /**
     * 每秒钟接收的KB数,rxkB/s
     */
    private String rxbyt;


    /**
     * 每秒钟发送的KB数,txkB/s
     */
    private String txbyt;

    /**
     * 每秒钟接收的压缩数据包,rxcmp/s
     */
    private String rxcmp;

    /**
     * 每秒钟发送的压缩数据包,txcmp/s
     */
    private String txcmp;

    /**
     * 每秒钟接收的多播数据包,rxmcst/s
     */
    private String rxmcst;

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