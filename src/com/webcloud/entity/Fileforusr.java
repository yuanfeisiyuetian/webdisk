package com.webcloud.entity;

import java.math.BigDecimal;
import java.util.Date;

public class Fileforusr extends FileforusrKey {
    private String ufilename;

    private String ufilenameSave;

    private String upath;

    private String upathSave;

    private BigDecimal usize;

    private String ufileformat;

    private Date uploadtime;

    private Date ulastmodtime;

    private Date uaccesstime;

    private Short udownloadtimes;

    private Boolean isrecycle;

    private Boolean isshare;

    public String getUfilename() {
        return ufilename;
    }

    public void setUfilename(String ufilename) {
        this.ufilename = ufilename == null ? null : ufilename.trim();
    }

    public String getUfilenameSave() {
        return ufilenameSave;
    }

    public void setUfilenameSave(String ufilenameSave) {
        this.ufilenameSave = ufilenameSave == null ? null : ufilenameSave.trim();
    }

    public String getUpath() {
        return upath;
    }

    public void setUpath(String upath) {
        this.upath = upath == null ? null : upath.trim();
    }

    public String getUpathSave() {
        return upathSave;
    }

    public void setUpathSave(String upathSave) {
        this.upathSave = upathSave == null ? null : upathSave.trim();
    }

    public BigDecimal getUsize() {
        return usize;
    }

    public void setUsize(BigDecimal usize) {
        this.usize = usize;
    }

    public String getUfileformat() {
        return ufileformat;
    }

    public void setUfileformat(String ufileformat) {
        this.ufileformat = ufileformat == null ? null : ufileformat.trim();
    }

    public Date getUploadtime() {
        return uploadtime;
    }

    public void setUploadtime(Date uploadtime) {
        this.uploadtime = uploadtime;
    }

    public Date getUlastmodtime() {
        return ulastmodtime;
    }

    public void setUlastmodtime(Date ulastmodtime) {
        this.ulastmodtime = ulastmodtime;
    }

    public Date getUaccesstime() {
        return uaccesstime;
    }

    public void setUaccesstime(Date uaccesstime) {
        this.uaccesstime = uaccesstime;
    }

    public Short getUdownloadtimes() {
        return udownloadtimes;
    }

    public void setUdownloadtimes(Short udownloadtimes) {
        this.udownloadtimes = udownloadtimes;
    }

    public Boolean getIsrecycle() {
        return isrecycle;
    }

    public void setIsrecycle(Boolean isrecycle) {
        this.isrecycle = isrecycle;
    }

    public Boolean getIsshare() {
        return isshare;
    }

    public void setIsshare(Boolean isshare) {
        this.isshare = isshare;
    }
}