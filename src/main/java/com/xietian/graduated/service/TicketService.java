package com.xietian.graduated.service;

import com.xietian.graduated.common.util.Result;
import com.xietian.graduated.pojo.Ticket;

import java.util.List;

public interface TicketService {
    Result<String> addTicket(List<Ticket> tickets);

    Result<String> updateTicket(List<Ticket> tickets);

    Result<List<Ticket>> getByFid(int fid);

    Result<Ticket> getById(int tid);

    Result<List<Ticket>> getByFidList(List<Integer> list);

    Result<Double> getPriceById(int tid);
}
