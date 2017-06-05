package com.jmr.model;

import java.util.Date;

/**
 * 权限管理-账号信息
 *
 * Created by youtao.wan on 2017/6/5.
 */
public class Account {
    /**
     * 主键Id
     */
    private Long id;
    /**
     * 用户Id(唯一键)
     */
    private String userId;
    /**
     * 用户名
     */
    private String userName;
    /**
     * 密码(加密)
     */
    private String password;
    /**
     * 账号有效截止日期
     */
    private Date deadLine;
    /**
     * 最后一次登录时间
     */
    private Date loginTime;
    /**
     * 最后一次登录Ip
     */
    private String loginIp;
    /**
     * 账号是否可使用
     */
    private boolean isUsed;
    /**
     * 账号是否已锁定
     */
    private boolean idLocked;
    /**
     * 账号是否已过期
     */
    private boolean isExpired;
    /**
     * 账号创建时间
     */
    private Date createTime;
    /**
     * 账号信息更新时间
     */
    private Date updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getDeadLine() {
        return deadLine;
    }

    public void setDeadLine(Date deadLine) {
        this.deadLine = deadLine;
    }

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    public String getLoginIp() {
        return loginIp;
    }

    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp;
    }

    public boolean isUsed() {
        return isUsed;
    }

    public void setUsed(boolean used) {
        isUsed = used;
    }

    public boolean isIdLocked() {
        return idLocked;
    }

    public void setIdLocked(boolean idLocked) {
        this.idLocked = idLocked;
    }

    public boolean isExpired() {
        return isExpired;
    }

    public void setExpired(boolean expired) {
        isExpired = expired;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
