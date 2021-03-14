package com.xietian.graduated.service.impl;

import com.xietian.graduated.common.util.Result;
import com.xietian.graduated.dao.TicketMapper;
import com.xietian.graduated.pojo.Ticket;
import com.xietian.graduated.pojo.TicketExample;
import com.xietian.graduated.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.security.rsa.RSAUtil;

import java.util.ArrayList;
import java.util.List;
@Service
public class TicketServiceImpl implements TicketService{

    @Autowired
    TicketMapper ticketMapper;

    @Override
    public Result<String> addTicket(List<Ticket> tickets) {
        for(Ticket t: tickets){
            if(ticketMapper.insertSelective(t)<0){
                return Result.isError(101,"机票插入失败，机票为："+t);
            }
        }
        return Result.isSuccess();
    }

    @Override
    public Result<String> updateTicket(List<Ticket> tickets) {
        for(Ticket t: tickets){
            ticketMapper.updateByPrimaryKeySelective(t);
        }
        return Result.isSuccess();
    }

    @Override
    public Result<List<Ticket>> getByFid(int fid) {
        TicketExample ticketExample = new TicketExample();
        TicketExample.Criteria criteria = ticketExample.createCriteria();
        criteria.andFIdEqualTo(fid);
        return Result.isSuccess(ticketMapper.selectByExample(ticketExample));
    }

    @Override
    public Result<Ticket> getById(int tid) {
        Ticket ticket = ticketMapper.selectByPrimaryKey(tid);
        if(ticket==null){
            return Result.isError(104,"操作数据不存在");
        }
        else return Result.isSuccess(ticket);
    }

    @Override
    public Result<List<Ticket>> getByFidList(List<Integer> list) {
        List<Ticket> reList = new ArrayList<>();
        for(int i=0; i<list.size(); i++){
            reList.addAll(getByFid(list.get(i)).getData());
        }
        return Result.isSuccess(reList);
    }

    @Override
    public Result<Double> getPriceById(int tid) {
        return Result.isSuccess(ticketMapper.getPriceByPrimaryKey(tid));
    }
}
