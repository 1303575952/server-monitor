package com.sxu.entity.host;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description: 查看磁盘大小使用信息
 */
@Getter
@Setter
public class DeskState implements Serializable {

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
     * 磁盘分区
     */
    private String fileSystem;

    /**
     * 分区大小
     */
    private String size;

    /**
     * 已使用
     */
    private String used;

    /**
     * 未使用
     */
    private String avail;

    /**
     * 已使用百分比
     */
    private String usePer;

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