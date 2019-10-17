package com.sxu.entity.app;

import com.sxu.util.DateUtil;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
public class AppState implements Serializable {

    private static final long serialVersionUID = -5070594722828330244L;

    /**
     * 主键
     */
    private String id;

    /**
     * 应用信息ID
     */
    private String appInfoId;

    /**
     * %CPU
     */
    private String cpuPer;

    /**
     * %MEM
     */
    private String memPer;

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
        String str = DateUtil.getDateTimeString(createTime);
        if (!StringUtils.isEmpty(str) && str.length() > 16) {
            return str.substring(5);
        }
        return dateStr;
    }

    public void setDateStr(String dateStr) {
        this.dateStr = dateStr;
    }
}
