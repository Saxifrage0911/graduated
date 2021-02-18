package com.xietian.graduated.dto;

import java.util.Date;
import java.util.List;

public class FlightMngDto {

    private Integer fId;

    private String fName;

    private Integer pId;

    private Integer fEco;

    private Integer fBus;

    private Integer fFc;

    private Date startTime;

    private Date endTime;

    private String from;

    private String destination;

    private List<Double> prices;
}
