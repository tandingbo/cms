package com.tanbobo.cms.core.entity;

import com.tanbobo.cms.base.entity.BaseEntity;

/**
 * 账户
 */
public class SysAccount extends BaseEntity<SysAccount> {
    private static final long serialVersionUID = -1225660232781278769L;

    public String uuid;
    public String userName;
    public String passWord;
    public String nickName;
    public String sex;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
