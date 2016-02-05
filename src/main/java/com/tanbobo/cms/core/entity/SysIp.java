package com.tanbobo.cms.core.entity;

import com.tanbobo.cms.base.entity.BaseEntity;

/**
 * IP范围
 */
public class SysIp extends BaseEntity<SysIp> {
    private static final long serialVersionUID = 8194695231135466251L;
    /**
     * 起始IP
     */
    public String beginIp;
    /**
     * 结束IP
     */
    public String endIp;
    /**
     * 国家
     */
    public String country;
    /**
     * 地区
     */
    public String area;

    public SysIp() {
        beginIp = endIp = country = area = "";
    }

    public String toString() {
        return this.area + "  " + this.country + "IP范围:" + this.beginIp + "-" + this.endIp;
    }
}
