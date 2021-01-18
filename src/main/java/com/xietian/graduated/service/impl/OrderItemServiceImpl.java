package com.xietian.graduated.service.impl;

import com.xietian.graduated.common.util.Result;
import com.xietian.graduated.dao.OrderItemMapper;
import com.xietian.graduated.pojo.Flight;
import com.xietian.graduated.pojo.OrderItem;
import com.xietian.graduated.pojo.OrderItemExample;
import com.xietian.graduated.pojo.Ticket;
import com.xietian.graduated.service.FlightService;
import com.xietian.graduated.service.OrderItemService;
import com.xietian.graduated.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class OrderItemServiceImpl implements OrderItemService{

    @Autowired
    private OrderItemMapper orderItemMapper;
    @Autowired
    private TicketService ticketService;
    @Autowired
    private FlightService flightService;

    @Override
    public Result<String> delItem(int itemId) {
        if(orderItemMapper.deleteByPrimaryKey(itemId)>0){
            return Result.isSuccess();
        }
        else return Result.isError(102,"删除失败");
    }

    @Override
    public Result<String> buyTicket(int oid, int tid, int uid, String idnum) {
        Ticket ticket = ticketService.getById(tid).getData();
        boolean canBUY = false;
        if(ticket!=null){
            Flight flight = flightService.getById(ticket.getfId()).getData();
            //需要加同步锁,前端需关闭不符合出发时间要求的订购按钮
            if(flight!=null&&(flight.getStartTime().getTime()-(new Date().getTime()))/(1000 * 60 * 60 * 3)>3){
                switch (ticket.getRank()){
                    case (byte)1: canBUY = flight.getfEco()>0;break;
                    case (byte)2: canBUY = flight.getfBus()>0;break;
                    case (byte)3: canBUY = flight.getfFc()>0;break;
                    default: return Result.isError(110,"参数错误");
                }

                if(canBUY){
                    int reCode = 0;
                    switch (ticket.getRank()){
                        case (byte)1: reCode = flightService.soldTicket(flight.getfId(),"eco",1).getCode();break;
                        case (byte)2: reCode = flightService.soldTicket(flight.getfId(),"bus",1).getCode();break;
                        case (byte)3: reCode = flightService.soldTicket(flight.getfId(),"fc",1).getCode();break;
                    }

                    if(reCode!=200) return Result.sysError();

                    OrderItem orderItem = new OrderItem();
                    orderItem.setoId(oid);
                    orderItem.setuId(uid);
                    orderItem.settId(tid);
                    orderItem.setItemPrice(ticket.gettPrice());
                    orderItem.setSeat("none");
                    orderItem.setpIdnum(idnum);

                    if(orderItemMapper.insert(orderItem)<1) return Result.isError(101,"插入失败");
                }

                else return Result.isError(105,"机票数不足");
            }
        }
        else return Result.isError(104,"操作数据不存在");

        return Result.isSuccess();
    }

    @Override
    public Result<List<OrderItem>> getByOid(int oid) {
        OrderItemExample orderItemExample = new OrderItemExample();
        OrderItemExample.Criteria criteria = orderItemExample.createCriteria();
        criteria.andOIdEqualTo(oid);
        return Result.isSuccess(orderItemMapper.selectByExample(orderItemExample));
    }

    @Override
    public Result<String> refundTicket(List<OrderItem> list) {
        for(OrderItem oi: list){
            Ticket t = ticketService.getById(oi.gettId()).getData();
            String rank = null;
            switch(t.getRank()){
                case (byte)1: rank="eco";break;
                case (byte)2: rank="bus";break;
                case (byte)3: rank="fc"; break;
            }
            flightService.soldTicket(t.getfId(),rank,-1);
        }

        return Result.isSuccess();
    }

    @Override
    public List<OrderItem> getByTId(int tid) {
        OrderItemExample orderItemExample = new OrderItemExample();
        OrderItemExample.Criteria criteria = orderItemExample.createCriteria();
        criteria.andTIdEqualTo(tid);
        return orderItemMapper.selectByExample(orderItemExample);
    }

    @Override
    public void updateSeat(int itemId, String seat) {
        OrderItem orderItem = new OrderItem();
        orderItem.setItemId(itemId);
        orderItem.setSeat(seat);
        orderItemMapper.updateByPrimaryKeySelective(orderItem);
    }


}
