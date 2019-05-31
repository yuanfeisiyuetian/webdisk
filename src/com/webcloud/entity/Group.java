package com.webcloud.entity;

import java.util.Date;

public class Group {
    private Integer gid;

    private String gname;

    private Date setuptime;

    private Integer oid;

    private Short managerauth;

    private Short uauth;

    private String token;

    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }

    public String getGname() {
        return gname;
    }

    public void setGname(String gname) {
        this.gname = gname == null ? null : gname.trim();
    }

    public Date getSetuptime() {
        return setuptime;
    }

    public void setSetuptime(Date setuptime) {
        this.setuptime = setuptime;
    }

    public Integer getOid() {
        return oid;
    }

    public void setOid(Integer oid) {
        this.oid = oid;
    }

    public Short getManagerauth() {
        return managerauth;
    }

    public void setManagerauth(Short managerauth) {
        this.managerauth = managerauth;
    }

    public Short getUauth() {
        return uauth;
    }

    public void setUauth(Short uauth) {
        this.uauth = uauth;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token == null ? null : token.trim();
    }
}