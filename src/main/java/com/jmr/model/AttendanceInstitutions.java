package com.jmr.model;

import java.util.Date;

public class AttendanceInstitutions {
    private Integer institutionsId;

    private Integer attendanceId;

    private Integer isDelete;

    private String createBy;

    private Date createAt;

    public Integer getInstitutionsId() {
        return institutionsId;
    }

    public void setInstitutionsId(Integer institutionsId) {
        this.institutionsId = institutionsId;
    }

    public Integer getAttendanceId() {
        return attendanceId;
    }

    public void setAttendanceId(Integer attendanceId) {
        this.attendanceId = attendanceId;
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