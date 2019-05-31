package com.webcloud.entity;

import java.util.Date;

public class Shareforusr extends ShareforusrKey {
    private Date usharedate;

    private String ufilepassword;

    private String ufilepath;

    private String ufilename;

    private Date usharedateend;

    public Date getUsharedate() {
        return usharedate;
    }

    public void setUsharedate(Date usharedate) {
        this.usharedate = usharedate;
    }

    public String getUfilepassword() {
        return ufilepassword;
    }

    public void setUfilepassword(String ufilepassword) {
        this.ufilepassword = ufilepassword == null ? null : ufilepassword.trim();
    }

    public String getUfilepath() {
        return ufilepath;
    }

    public void setUfilepath(String ufilepath) {
        this.ufilepath = ufilepath == null ? null : ufilepath.trim();
    }

    public String getUfilename() {
        return ufilename;
    }

    public void setUfilename(String ufilename) {
        this.ufilename = ufilename == null ? null : ufilename.trim();
    }

    public Date getUsharedateend() {
        return usharedateend;
    }

    public void setUsharedateend(Date usharedateend) {
        this.usharedateend = usharedateend;
    }
}