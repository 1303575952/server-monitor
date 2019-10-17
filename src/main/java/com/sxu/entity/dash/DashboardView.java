package com.sxu.entity.dash;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class DashboardView implements Serializable {

    private static final long serialVersionUID = -3161397793843110068L;

    /**
     * 主键
     */
    private String id;

    /**
     * host名称
     */
    private String hostname;

    /**
     * 系统版本信息
     */
    private String version;

    /**
     * 系统已经运行了多少天
     */
    private String yxDays;

    /**
     * 内存已使用百分比
     */
    private double memPer;
}
