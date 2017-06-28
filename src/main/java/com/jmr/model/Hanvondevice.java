package com.jmr.model;

public class Hanvondevice {
    private String sn;

    private String institutHao;

    private String ip;

    private String subnetmask;

    private String gateip;

    private String classId;

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn == null ? null : sn.trim();
    }

    public String getInstitutHao() {
        return institutHao;
    }

    public void setInstitutHao(String institutHao) {
        this.institutHao = institutHao == null ? null : institutHao.trim();
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    public String getSubnetmask() {
        return subnetmask;
    }

    public void setSubnetmask(String subnetmask) {
        this.subnetmask = subnetmask == null ? null : subnetmask.trim();
    }

    public String getGateip() {
        return gateip;
    }

    public void setGateip(String gateip) {
        this.gateip = gateip == null ? null : gateip.trim();
    }

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId == null ? null : classId.trim();
    }
}