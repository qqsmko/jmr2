package com.jmr.model;

import java.util.Date;

/**
 * 权限管理-角色实体
 *
 * Created by youtao.wan on 2017/6/5.
 */
public class Role {
    /**
     * 主键Id
     */
    private Long id;
    /**
     * 角色Id
     */
    private String roleId;
    /**
     * 角色名称(ROLE_*)
     * 约定以ROLE_起始
     */
    private String roleName;
    /**
     * 角色描述信息
     */
    private String roleDesc;
    /**
     * 角色是否可用
     */
    private boolean isUsed;
    /**
     * 角色创建时间
     */
    private Date createTime;
    /**
     * 角色信息更新时间
     */
    private Date updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleDesc() {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }

    public boolean isUsed() {
        return isUsed;
    }

    public void setUsed(boolean used) {
        isUsed = used;
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
