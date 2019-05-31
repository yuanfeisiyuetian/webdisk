package com.webcloud.entity;

import java.util.Date;

public class Joinin extends JoininKey {
    private Date date;

    private Short odiauth;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Short getOdiauth() {
        return odiauth;
    }

    public void setOdiauth(Short odiauth) {
        this.odiauth = odiauth;
    }
}