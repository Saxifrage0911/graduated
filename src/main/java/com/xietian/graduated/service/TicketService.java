package com.xietian.graduated.service;

import com.xietian.graduated.common.util.Result;
import com.xietian.graduated.pojo.Ticket;

import java.util.List;

public interface TicketService {
    Result<String> addTicket(Ticket ticket);

    Result<List<Ticket>> getByFid(int fid);

    Result<Ticket> getById(int tid);

    Result<List<Ticket>> getByFidList(List<Integer> list);

    Result<Double> getPriceById(int tid);
}
