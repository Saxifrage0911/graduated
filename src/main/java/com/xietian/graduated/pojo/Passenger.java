package com.xietian.graduated.pojo;

public class Passenger {
    private Integer passId;

    private String pIdnum;

    private String pRealname;

    private Integer uId;

    public Integer getPassId() {
        return passId;
    }

    public void setPassId(Integer passId) {
        this.passId = passId;
    }

    public String getpIdnum() {
        return pIdnum;
    }

    public void setpIdnum(String pIdnum) {
        this.pIdnum = pIdnum == null ? null : pIdnum.trim();
    }

    public String getpRealname() {
        return pRealname;
    }

    public void setpRealname(String pRealname) {
        this.pRealname = pRealname == null ? null : pRealname.trim();
    }

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }
}