package com.jmr.model;

import java.util.Date;

public class Attendance extends AttendanceKey {
    private Integer attendanceType;

    private Date datatime;

    private Integer attendanceState;

    private Integer isDelete;

    private String createBy;

    private Date createAt;

    public Integer getAttendanceType() {
        return attendanceType;
    }

    public void setAttendanceType(Integer attendanceType) {
        this.attendanceType = attendanceType;
    }

    public Date getDatatime() {
        return datatime;
    }

    public void setDatatime(Date datatime) {
        this.datatime = datatime;
    }

    public Integer getAttendanceState() {
        return attendanceState;
    }

    public void setAttendanceState(Integer attendanceState) {
        this.attendanceState = attendanceState;
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