package com.xietian.graduated.pojo;

import java.math.BigDecimal;

public class OrderItem {
    private Integer itemId;

    private Integer oId;

    private Integer tId;

    private Integer uId;

    private String pIdnum;

    private BigDecimal itemPrice;

    private String seat;

    private String pRealname;

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public Integer getoId() {
        return oId;
    }

    public void setoId(Integer oId) {
        this.oId = oId;
    }

    public Integer gettId() {
        return tId;
    }

    public void settId(Integer tId) {
        this.tId = tId;
    }

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public String getpIdnum() {
        return pIdnum;
    }

    public void setpIdnum(String pIdnum) {
        this.pIdnum = pIdnum == null ? null : pIdnum.trim();
    }

    public BigDecimal getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(BigDecimal itemPrice) {
        this.itemPrice = itemPrice;
    }

    public String getSeat() {
        return seat;
    }

    public void setSeat(String seat) {
        this.seat = seat == null ? null : seat.trim();
    }

    public String getpRealname() {
        return pRealname;
    }

    public void setpRealname(String pRealname) {
        this.pRealname = pRealname == null ? null : pRealname.trim();
    }
}