package com.jmr.model;

import java.util.Date;

public class IdcardLatest {
    private Integer cardId;

    private Date latestClass;

    private Integer isOk;

    private Integer isDelete;

    private String createBy;

    private Date createAt;

    public Integer getCardId() {
        return cardId;
    }

    public void setCardId(Integer cardId) {
        this.cardId = cardId;
    }

    public Date getLatestClass() {
        return latestClass;
    }

    public void setLatestClass(Date latestClass) {
        this.latestClass = latestClass;
    }

    public Integer getIsOk() {
        return isOk;
    }

    public void setIsOk(Integer isOk) {
        this.isOk = isOk;
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