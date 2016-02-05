package com.tanbobo.cms.core.entity;

import com.tanbobo.cms.base.entity.BaseEntity;

import java.util.Date;

/**
 *
 */
public class AuthenToken extends BaseEntity<AuthenToken> {
    private static final long serialVersionUID = 5213770274931369554L;

    public String userId;
    public String nickName;
    public String gender;
    public String loginName;
    public Date loginTime;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }
}

