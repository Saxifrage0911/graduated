package com.xietian.graduated.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.xietian.graduated.pojo.OrderItem;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class OrderListDto {

    private Integer oId;

    private BigDecimal totalPrice;

    private Integer uId;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date payTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date startTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date endTime;

    private Byte status;

    private String from;

    private String destination;

    private List<OrderItem> itemList;

    public OrderListDto() {
    }

    public OrderListDto(Integer oId, BigDecimal totalPrice, Integer uId, Date createTime, Date payTime, Date startTime, Date endTime, Byte status, String from, String destination, List<OrderItem> itemList) {
        this.oId = oId;
        this.totalPrice = totalPrice;
        this.uId = uId;
        this.createTime = createTime;
        this.payTime = payTime;
        this.startTime = startTime;
        this.endTime = endTime;
        this.status = status;
        this.from = from;
        this.destination = destination;
        this.itemList = itemList;
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
        this.from = from;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Integer getoId() {
        return oId;
    }

    public void setoId(Integer oId) {
        this.oId = oId;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public List<OrderItem> getItemList() {
        return itemList;
    }

    public void setItemList(List<OrderItem> itemList) {
        this.itemList = itemList;
    }

    @Override
    public String toString() {
        return "OrderListDto{" +
                "oId=" + oId +
                ", totalPrice=" + totalPrice +
                ", uId=" + uId +
                ", createTime=" + createTime +
                ", payTime=" + payTime +
                ", status=" + status +
                ", itemList=" + itemList +
                '}';
    }
}
