package com.jmr.model;

public class Ip_device {
    private Integer devHao;

    private String ip;

    private Integer httpPort;

    private Integer devPort;

    private String username;

    private String password;

    private String devStype;

    private String devAdr;

    private String devDescription;

    private String institution;

    private String instRoute;

    private Boolean devEffect;

    private Integer instRoutePort;

    public Integer getDevHao() {
        return devHao;
    }

    public void setDevHao(Integer devHao) {
        this.devHao = devHao;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    public Integer getHttpPort() {
        return httpPort;
    }

    public void setHttpPort(Integer httpPort) {
        this.httpPort = httpPort;
    }

    public Integer getDevPort() {
        return devPort;
    }

    public void setDevPort(Integer devPort) {
        this.devPort = devPort;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getDevStype() {
        return devStype;
    }

    public void setDevStype(String devStype) {
        this.devStype = devStype == null ? null : devStype.trim();
    }

    public String getDevAdr() {
        return devAdr;
    }

    public void setDevAdr(String devAdr) {
        this.devAdr = devAdr == null ? null : devAdr.trim();
    }

    public String getDevDescription() {
        return devDescription;
    }

    public void setDevDescription(String devDescription) {
        this.devDescription = devDescription == null ? null : devDescription.trim();
    }

    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution == null ? null : institution.trim();
    }

    public String getInstRoute() {
        return instRoute;
    }

    public void setInstRoute(String instRoute) {
        this.instRoute = instRoute == null ? null : instRoute.trim();
    }

    public Boolean getDevEffect() {
        return devEffect;
    }

    public void setDevEffect(Boolean devEffect) {
        this.devEffect = devEffect;
    }

    public Integer getInstRoutePort() {
        return instRoutePort;
    }

    public void setInstRoutePort(Integer instRoutePort) {
        this.instRoutePort = instRoutePort;
    }
}