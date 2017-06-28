package com.jmr.model;

public class Hikvisiondev {
    private String devHao;

    private String iinstutHao;

    private String classHao;

    private String ipAdr;

    private Integer sPort;

    private String subSmask;

    private String gateIp;

    private Integer httpPort;

    private String userName;

    private String userPwd;

    private String devScipt;

    private Integer statV;

    private String saveAdr;

    public String getDevHao() {
        return devHao;
    }

    public void setDevHao(String devHao) {
        this.devHao = devHao == null ? null : devHao.trim();
    }

    public String getIinstutHao() {
        return iinstutHao;
    }

    public void setIinstutHao(String iinstutHao) {
        this.iinstutHao = iinstutHao == null ? null : iinstutHao.trim();
    }

    public String getClassHao() {
        return classHao;
    }

    public void setClassHao(String classHao) {
        this.classHao = classHao == null ? null : classHao.trim();
    }

    public String getIpAdr() {
        return ipAdr;
    }

    public void setIpAdr(String ipAdr) {
        this.ipAdr = ipAdr == null ? null : ipAdr.trim();
    }

    public Integer getsPort() {
        return sPort;
    }

    public void setsPort(Integer sPort) {
        this.sPort = sPort;
    }

    public String getSubSmask() {
        return subSmask;
    }

    public void setSubSmask(String subSmask) {
        this.subSmask = subSmask == null ? null : subSmask.trim();
    }

    public String getGateIp() {
        return gateIp;
    }

    public void setGateIp(String gateIp) {
        this.gateIp = gateIp == null ? null : gateIp.trim();
    }

    public Integer getHttpPort() {
        return httpPort;
    }

    public void setHttpPort(Integer httpPort) {
        this.httpPort = httpPort;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd == null ? null : userPwd.trim();
    }

    public String getDevScipt() {
        return devScipt;
    }

    public void setDevScipt(String devScipt) {
        this.devScipt = devScipt == null ? null : devScipt.trim();
    }

    public Integer getStatV() {
        return statV;
    }

    public void setStatV(Integer statV) {
        this.statV = statV;
    }

    public String getSaveAdr() {
        return saveAdr;
    }

    public void setSaveAdr(String saveAdr) {
        this.saveAdr = saveAdr == null ? null : saveAdr.trim();
    }
}