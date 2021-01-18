package com.xietian.graduated.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.NotNull;
import java.util.Date;

public class FlightDto {

    @NotNull(message = "出发地不能为空")
    private String from;

    @NotNull(message = "目的地不能为空")
    private String to;

    @NotNull(message = "出发日期")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date startDay;

    public FlightDto() {
    }

    public FlightDto(@NotNull(message = "出发地不能为空") String from, @NotNull(message = "目的地不能为空") String to, @NotNull(message = "出发日期") Date startDay) {
        this.from = from;
        this.to = to;
        this.startDay = startDay;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public Date getStartDay() {
        return startDay;
    }

    public void setStartDay(Date startDay) {
        this.startDay = startDay;
    }

    @Override
    public String toString() {
        return "FlightDto{" +
                "from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", startDay=" + startDay +
                '}';
    }
}
