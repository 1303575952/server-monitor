package com.sxu.entity.host;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.util.Date;

/**
 * @Discription:查看CPU使用情况
 */
@Getter
@Setter
public class CpuState implements Serializable {

    private static final long serialVersionUID = -2913111613773445949L;

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
     * 用户态的CPU时间（%）
     */
    private String user;

    /**
     * 系统（内核）时间（%）
     */
    private String sys;

    /**
     * 空闲时间（idle）（%）
     */
    private String idle;

    /**
     * IO等待时间（wait）（%）
     */
    private String iowait;

    /**
     * 硬中断时间（%）
     */
    private String irq;

    /**
     * 软中断时间（%）
     */
    private String soft;

    /**
     * 添加时间
     * MM-dd hh:mm:ss
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