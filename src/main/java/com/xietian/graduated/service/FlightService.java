package com.xietian.graduated.service;

import com.xietian.graduated.common.util.Result;
import com.xietian.graduated.pojo.Flight;

import java.util.Date;
import java.util.List;

public interface FlightService {

    Result<Integer> addFlight(Flight flight);

    Result<String> updateFlight(Flight flight);

    Result<String> delFlight(int fid);

    Result<List<Flight>> getAllFlight();

    List<Flight> getEnableDistributeFlight();

    Result<Flight> getById(int fid);

    Result<List<Flight>> getFlightByDetail(String from, String to, Date startDay);

    Result<String> soldTicket(Integer fid, String ticketType,Integer increment);
}
