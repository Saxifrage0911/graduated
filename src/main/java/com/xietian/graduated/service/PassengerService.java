package com.xietian.graduated.service;

import com.xietian.graduated.common.util.Result;
import com.xietian.graduated.pojo.Passenger;

import java.util.List;

public interface PassengerService {
    Result<String> addPassenger(Passenger passenger);

    Result<String> delPassenger(Integer passId);

    Result<String> updatePassenger(Passenger passenger);

    Result<List<Passenger>> getByUAccount(String account);

    Result<String> getNameByIDNUM(String idnum);
}
