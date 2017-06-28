package com.jmr.model;

import java.util.Date;

public class ClassInstitutions {
    private Integer institutionsId;

    private Integer classId;

    private Integer isDelete;

    private String createBy;

    private Date createAt;

    public Integer getInstitutionsId() {
        return institutionsId;
    }

    public void setInstitutionsId(Integer institutionsId) {
        this.institutionsId = institutionsId;
    }

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }
}