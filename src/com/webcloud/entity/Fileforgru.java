package com.webcloud.entity;

import java.math.BigDecimal;
import java.util.Date;

public class Fileforgru extends FileforgruKey {
    private String gfilename;

    private String gfilenameSave;

    private Date guploadtime;

    private Integer guploadusrid;

    private BigDecimal gfilsize;

    private String ufilformat;

    private String gfilepath;

    private String gpathSave;

    private Integer glaccessusrid;

    private Date glaccesstime;

    private Integer glmodusrid;

    private Date glmodtime;

    private Short gdownloadtimes;

    private Boolean isrecycle;

    public String getGfilename() {
        return gfilename;
    }

    public void setGfilename(String gfilename) {
        this.gfilename = gfilename == null ? null : gfilename.trim();
    }

    public String getGfilenameSave() {
        return gfilenameSave;
    }

    public void setGfilenameSave(String gfilenameSave) {
        this.gfilenameSave = gfilenameSave == null ? null : gfilenameSave.trim();
    }

    public Date getGuploadtime() {
        return guploadtime;
    }

    public void setGuploadtime(Date guploadtime) {
        this.guploadtime = guploadtime;
    }

    public Integer getGuploadusrid() {
        return guploadusrid;
    }

    public void setGuploadusrid(Integer guploadusrid) {
        this.guploadusrid = guploadusrid;
    }

    public BigDecimal getGfilsize() {
        return gfilsize;
    }

    public void setGfilsize(BigDecimal gfilsize) {
        this.gfilsize = gfilsize;
    }

    public String getUfilformat() {
        return ufilformat;
    }

    public void setUfilformat(String ufilformat) {
        this.ufilformat = ufilformat == null ? null : ufilformat.trim();
    }

    public String getGfilepath() {
        return gfilepath;
    }

    public void setGfilepath(String gfilepath) {
        this.gfilepath = gfilepath == null ? null : gfilepath.trim();
    }

    public String getGpathSave() {
        return gpathSave;
    }

    public void setGpathSave(String gpathSave) {
        this.gpathSave = gpathSave == null ? null : gpathSave.trim();
    }

    public Integer getGlaccessusrid() {
        return glaccessusrid;
    }

    public void setGlaccessusrid(Integer glaccessusrid) {
        this.glaccessusrid = glaccessusrid;
    }

    public Date getGlaccesstime() {
        return glaccesstime;
    }

    public void setGlaccesstime(Date glaccesstime) {
        this.glaccesstime = glaccesstime;
    }

    public Integer getGlmodusrid() {
        return glmodusrid;
    }

    public void setGlmodusrid(Integer glmodusrid) {
        this.glmodusrid = glmodusrid;
    }

    public Date getGlmodtime() {
        return glmodtime;
    }

    public void setGlmodtime(Date glmodtime) {
        this.glmodtime = glmodtime;
    }

    public Short getGdownloadtimes() {
        return gdownloadtimes;
    }

    public void setGdownloadtimes(Short gdownloadtimes) {
        this.gdownloadtimes = gdownloadtimes;
    }

    public Boolean getIsrecycle() {
        return isrecycle;
    }

    public void setIsrecycle(Boolean isrecycle) {
        this.isrecycle = isrecycle;
    }
}