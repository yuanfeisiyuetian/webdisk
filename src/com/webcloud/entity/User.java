package com.webcloud.entity;

import java.util.Date;

public class User {
    private Integer uid;

    private String uname;

    private Date uregistertime;

    private String uemail;

    private String passwordhash;

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname == null ? null : uname.trim();
    }

    public Date getUregistertime() {
        return uregistertime;
    }

    public void setUregistertime(Date uregistertime) {
        this.uregistertime = uregistertime;
    }

    public String getUemail() {
        return uemail;
    }

    public void setUemail(String uemail) {
        this.uemail = uemail == null ? null : uemail.trim();
    }

    public String getPasswordhash() {
        return passwordhash;
    }

    public void setPasswordhash(String passwordhash) {
        this.passwordhash = passwordhash == null ? null : passwordhash.trim();
    }
}