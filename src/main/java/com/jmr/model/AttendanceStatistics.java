package com.jmr.model;

import java.util.Date;

public class AttendanceStatistics {
    private Integer statisticsId;

    private String statisticsName;

    private String statisicsValue;

    private Integer isDelete;

    private String createBy;

    private Date createAt;

    public Integer getStatisticsId() {
        return statisticsId;
    }

    public void setStatisticsId(Integer statisticsId) {
        this.statisticsId = statisticsId;
    }

    public String getStatisticsName() {
        return statisticsName;
    }

    public void setStatisticsName(String statisticsName) {
        this.statisticsName = statisticsName == null ? null : statisticsName.trim();
    }

    public String getStatisicsValue() {
        return statisicsValue;
    }

    public void setStatisicsValue(String statisicsValue) {
        this.statisicsValue = statisicsValue == null ? null : statisicsValue.trim();
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