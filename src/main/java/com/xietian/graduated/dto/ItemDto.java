package com.xietian.graduated.dto;

import javax.validation.constraints.NotNull;

public class ItemDto {

    @NotNull(message = "订单号不能为空")
    private int oid;

    @NotNull(message = "机票不能为空")
    private int tid;

    @NotNull(message = "购买的用户不能为空")
    private int uid;

    @NotNull(message = "身份证号不能为空")
    private String idnum;

    public ItemDto(@NotNull(message = "订单号不能为空") int oid, @NotNull(message = "机票不能为空") int tid, @NotNull(message = "购买的用户不能为空") int uid, @NotNull(message = "身份证号不能为空") String idnum) {
        this.oid = oid;
        this.tid = tid;
        this.uid = uid;
        this.idnum = idnum;
    }

    public ItemDto() {
    }

    public int getOid() {
        return oid;
    }

    public void setOid(int oid) {
        this.oid = oid;
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getIdnum() {
        return idnum;
    }

    public void setIdnum(String idnum) {
        this.idnum = idnum;
    }

    @Override
    public String toString() {
        return "ItemDto{" +
                "oid=" + oid +
                ", tid=" + tid +
                ", uid=" + uid +
                ", idnum='" + idnum + '\'' +
                '}';
    }
}
