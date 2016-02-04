package com.tanbobo.cms.core.entity;

import com.tanbobo.cms.base.entity.BaseEntity;

/**
 * 日志
 */
public class SysLog extends BaseEntity<SysLog> {
    private static final long serialVersionUID = 2934878140959618189L;

    /**
     * uuid
     */
    private String uuid;
    /**
     * 类型
     */
    private String type;
    /**
     * 内容
     */
    private String content;
    /**
     * 访问IP
     */
    private String accessIp;
    /**
     * 访问地址
     */
    private String accessUrl;
    /**
     * 访问时间
     */
    private String accessTime;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAccessIp() {
        return accessIp;
    }

    public void setAccessIp(String accessIp) {
        this.accessIp = accessIp;
    }

    public String getAccessUrl() {
        return accessUrl;
    }

    public void setAccessUrl(String accessUrl) {
        this.accessUrl = accessUrl;
    }

    public String getAccessTime() {
        return accessTime;
    }

    public void setAccessTime(String accessTime) {
        this.accessTime = accessTime;
    }
}
