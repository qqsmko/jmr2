package com.jmr.model;

import java.util.Date;

public class Fingerprint {
    private Integer fingerprintId;

    private String fingerprintImg;

    private Integer isDelete;

    private String createBy;

    private Date createAt;

    private String fingerprintCode;

    private Integer institutionsId;

    public Integer getFingerprintId() {
        return fingerprintId;
    }

    public void setFingerprintId(Integer fingerprintId) {
        this.fingerprintId = fingerprintId;
    }

    public String getFingerprintImg() {
        return fingerprintImg;
    }

    public void setFingerprintImg(String fingerprintImg) {
        this.fingerprintImg = fingerprintImg == null ? null : fingerprintImg.trim();
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

    public String getFingerprintCode() {
        return fingerprintCode;
    }

    public void setFingerprintCode(String fingerprintCode) {
        this.fingerprintCode = fingerprintCode == null ? null : fingerprintCode.trim();
    }

    public Integer getInstitutionsId() {
        return institutionsId;
    }

    public void setInstitutionsId(Integer institutionsId) {
        this.institutionsId = institutionsId;
    }
}