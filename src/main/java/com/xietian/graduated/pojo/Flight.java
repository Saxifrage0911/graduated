package com.xietian.graduated.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Flight {
    private Integer fId;

    private String fName;

    private Integer pId;

    private Integer fEco;

    private Integer fBus;

    private Integer fFc;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
    private Date startTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
    private Date endTime;

    private String from;

    private String destination;

    public Integer getfId() {
        return fId;
    }

    public void setfId(Integer fId) {
        this.fId = fId;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName == null ? null : fName.trim();
    }

    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }

    public Integer getfEco() {
        return fEco;
    }

    public void setfEco(Integer fEco) {
        this.fEco = fEco;
    }

    public Integer getfBus() {
        return fBus;
    }

    public void setfBus(Integer fBus) {
        this.fBus = fBus;
    }

    public Integer getfFc() {
        return fFc;
    }

    public void setfFc(Integer fFc) {
        this.fFc = fFc;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from == null ? null : from.trim();
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination == null ? null : destination.trim();
    }
}