package com.xietian.graduated.dto;

public class OrderCountDto {

    private Long numOfFinished;
    private Long numOfUnfinished;

    public OrderCountDto(Long numOfFinished, Long numOfUnfinished) {
        this.numOfFinished = numOfFinished;
        this.numOfUnfinished = numOfUnfinished;
    }

    public OrderCountDto() {
    }

    public Long getNumOfFinished() {
        return numOfFinished;
    }

    public void setNumOfFinished(Long numOfFinished) {
        this.numOfFinished = numOfFinished;
    }

    public Long getNumOfUnfinished() {
        return numOfUnfinished;
    }

    public void setNumOfUnfinished(Long numOfUnfinished) {
        this.numOfUnfinished = numOfUnfinished;
    }
}
