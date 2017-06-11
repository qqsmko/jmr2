package com.jmr.model;

import java.util.Date;

public class ClassSeriesVerifyed {
    private Integer classSeriesId;

    private String classSeriesName;

    private Integer classesCount;

    private Date startTime;

    private Date endTime;

    private Integer state;

    private Integer isDelete;

    private String createBy;

    private Date createAt;

    public Integer getClassSeriesId() {
        return classSeriesId;
    }

    public void setClassSeriesId(Integer classSeriesId) {
        this.classSeriesId = classSeriesId;
    }

    public String getClassSeriesName() {
        return classSeriesName;
    }

    public void setClassSeriesName(String classSeriesName) {
        this.classSeriesName = classSeriesName == null ? null : classSeriesName.trim();
    }

    public Integer getClassesCount() {
        return classesCount;
    }

    public void setClassesCount(Integer classesCount) {
        this.classesCount = classesCount;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
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