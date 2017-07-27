package com.jmr.model;

import java.util.Date;

public class Class {
    private Integer classId;

    private String className;

    private Integer studentCount;

    private Integer state;

    private String responsible;

    private String telephone;

    private Integer isDelete;

    private String createBy;

    private Date createAt;

    private Integer institutionsId;

    private Date startTime;

    private Date endTime;

    private String hangyeType;

    private String workType;

    private String trainingMode;

    private Integer fee;

    private String isSubsidy;

    private Integer subsidyNumber;

    private String trainingType;

    private String certificate;

    private String trainingLevel;

    private String perfectionStandard;

    private String employmentIntention;

    private String trainingPos;

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className == null ? null : className.trim();
    }

    public Integer getStudentCount() {
        return studentCount;
    }

    public void setStudentCount(Integer studentCount) {
        this.studentCount = studentCount;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getResponsible() {
        return responsible;
    }

    public void setResponsible(String responsible) {
        this.responsible = responsible == null ? null : responsible.trim();
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone == null ? null : telephone.trim();
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

    public Integer getInstitutionsId() {
        return institutionsId;
    }

    public void setInstitutionsId(Integer institutionsId) {
        this.institutionsId = institutionsId;
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

    public String getHangyeType() {
        return hangyeType;
    }

    public void setHangyeType(String hangyeType) {
        this.hangyeType = hangyeType == null ? null : hangyeType.trim();
    }

    public String getWorkType() {
        return workType;
    }

    public void setWorkType(String workType) {
        this.workType = workType == null ? null : workType.trim();
    }

    public String getTrainingMode() {
        return trainingMode;
    }

    public void setTrainingMode(String trainingMode) {
        this.trainingMode = trainingMode == null ? null : trainingMode.trim();
    }

    public Integer getFee() {
        return fee;
    }

    public void setFee(Integer fee) {
        this.fee = fee;
    }

    public String getIsSubsidy() {
        return isSubsidy;
    }

    public void setIsSubsidy(String isSubsidy) {
        this.isSubsidy = isSubsidy == null ? null : isSubsidy.trim();
    }

    public Integer getSubsidyNumber() {
        return subsidyNumber;
    }

    public void setSubsidyNumber(Integer subsidyNumber) {
        this.subsidyNumber = subsidyNumber;
    }

    public String getTrainingType() {
        return trainingType;
    }

    public void setTrainingType(String trainingType) {
        this.trainingType = trainingType == null ? null : trainingType.trim();
    }

    public String getCertificate() {
        return certificate;
    }

    public void setCertificate(String certificate) {
        this.certificate = certificate == null ? null : certificate.trim();
    }

    public String getTrainingLevel() {
        return trainingLevel;
    }

    public void setTrainingLevel(String trainingLevel) {
        this.trainingLevel = trainingLevel == null ? null : trainingLevel.trim();
    }

    public String getPerfectionStandard() {
        return perfectionStandard;
    }

    public void setPerfectionStandard(String perfectionStandard) {
        this.perfectionStandard = perfectionStandard == null ? null : perfectionStandard.trim();
    }

    public String getEmploymentIntention() {
        return employmentIntention;
    }

    public void setEmploymentIntention(String employmentIntention) {
        this.employmentIntention = employmentIntention == null ? null : employmentIntention.trim();
    }

    public String getTrainingPos() {
        return trainingPos;
    }

    public void setTrainingPos(String trainingPos) {
        this.trainingPos = trainingPos == null ? null : trainingPos.trim();
    }
}