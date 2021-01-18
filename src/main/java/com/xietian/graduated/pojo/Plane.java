package com.xietian.graduated.pojo;

public class Plane {
    private Integer pId;

    private String pName;

    private Integer pEco;

    private Integer pBus;

    private Integer pFc;

    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName == null ? null : pName.trim();
    }

    public Integer getpEco() {
        return pEco;
    }

    public void setpEco(Integer pEco) {
        this.pEco = pEco;
    }

    public Integer getpBus() {
        return pBus;
    }

    public void setpBus(Integer pBus) {
        this.pBus = pBus;
    }

    public Integer getpFc() {
        return pFc;
    }

    public void setpFc(Integer pFc) {
        this.pFc = pFc;
    }
}