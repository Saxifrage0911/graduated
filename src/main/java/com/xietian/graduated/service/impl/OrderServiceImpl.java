package com.xietian.graduated.service.impl;

import com.xietian.graduated.common.util.Result;
import com.xietian.graduated.dao.OrderMapper;
import com.xietian.graduated.dto.OrderCountDto;
import com.xietian.graduated.dto.OrderListDto;
import com.xietian.graduated.pojo.Flight;
import com.xietian.graduated.pojo.Order;
import com.xietian.graduated.pojo.OrderExample;
import com.xietian.graduated.pojo.OrderItem;
import com.xietian.graduated.service.FlightService;
import com.xietian.graduated.service.OrderItemService;
import com.xietian.graduated.service.OrderService;
import com.xietian.graduated.service.TicketService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderMapper orderMapper;
    @Autowired
    OrderItemService orderItemService;
    @Autowired
    TicketService ticketService;
    @Autowired
    FlightService flightService;

    @Override
    public Result<Integer> addOrder(Order order) {
        //此处应加上同步锁
        order.setCreateTime(new Date());
        order.setStatus((byte) 0);
        if(orderMapper.insert(order)>0){
            return Result.isSuccess(orderMapper.getLatestOrder().getoId());
        }
        else return Result.isError(101,"插入失败");
    }

    @Override
    public Result<String> cancelOrder(Integer oId) {
        Order o = orderMapper.selectByPrimaryKey(oId);
        if(o==null){
            return Result.isError(104,"操作数据不存在");
        }
        else if(o.getStatus()==(byte)2){
            return Result.isError(111,"订单已过期");
        }
        OrderExample orderExample = new OrderExample();
        OrderExample.Criteria criteria = orderExample.createCriteria();
        criteria.andOIdEqualTo(oId);
        o.setStatus((byte)3);
        orderMapper.updateByExampleSelective(o,orderExample);
        List<OrderItem> oiList = orderItemService.getByOid(oId).getData();
        return orderItemService.refundTicket(oiList);
    }

    @Override
    public Result<String> updateOrderTotalPrice(Integer oId) {
        List<OrderItem> list = orderItemService.getByOid(oId).getData();
        BigDecimal totalPrice = new BigDecimal(0);
        for(OrderItem o:list){
            totalPrice = totalPrice.add(o.getItemPrice());
        }
        Order order = new Order();
        order.setTotalPrice(totalPrice);
        OrderExample orderExample = new OrderExample();
        OrderExample.Criteria criteria = orderExample.createCriteria();
        criteria.andOIdEqualTo(oId);
        if(orderMapper.updateByExampleSelective(order,orderExample)>0){
            return Result.isSuccess();
        }
        else return Result.isError(103,"更新失败");
    }

    @Override
    public Result<String> payOrder(Integer oId) {
        Order o = orderMapper.selectByPrimaryKey(oId);

        if(o==null)
            return Result.isError(104,"操作数据不存在");
        else if(o.getStatus()==2)
            return Result.isError(111,"订单已过期");

        o.setStatus((byte)1);
        o.setPayTime(new Date());
        if(orderMapper.updateByPrimaryKeySelective(o)>0){
            return Result.isSuccess();
        }
        else return Result.isError(103,"更新失败");
    }

    @Override
    public Result<List<OrderListDto>> getByUidF(Integer uId) {
        OrderExample orderExample = new OrderExample();
        OrderExample.Criteria criteria = orderExample.createCriteria();
        criteria.andUIdEqualTo(uId);
        criteria.andStatusEqualTo((byte)1);
        List<Order> list = orderMapper.selectByExample(orderExample);
        return Result.isSuccess(convertOrderListDto(list));
    }

    @Override
    public Result<List<OrderListDto>> getByUidU(Integer uId) {
        OrderExample orderExample = new OrderExample();
        OrderExample.Criteria criteria = orderExample.createCriteria();
        criteria.andUIdEqualTo(uId);
        criteria.andStatusNotEqualTo((byte)1);
        List<Order> list = orderMapper.selectByExample(orderExample);
        return Result.isSuccess(convertOrderListDto(list));
    }

    @Override
    public Result<OrderCountDto> getOrderCount(Integer uId) {
        OrderCountDto countDto = new OrderCountDto();

        OrderExample orderExample = new OrderExample();
        OrderExample.Criteria criteria = orderExample.createCriteria();
        criteria.andUIdEqualTo(uId);
        criteria.andStatusEqualTo((byte)1);
        countDto.setNumOfFinished(orderMapper.countByExample(orderExample));

        OrderExample orderExample2 = new OrderExample();
        OrderExample.Criteria criteria2 = orderExample2.createCriteria();
        criteria2.andUIdEqualTo(uId);
        criteria2.andStatusNotEqualTo((byte)1);
        countDto.setNumOfUnfinished(orderMapper.countByExample(orderExample2));

        return Result.isSuccess(countDto);
    }

    public List<OrderListDto> convertOrderListDto(List<Order> list){
        List<OrderListDto> result = new ArrayList<>();
        for(Order o: list){
            OrderListDto orderListDto = new OrderListDto();
            BeanUtils.copyProperties(o,orderListDto);
            List<OrderItem> items = orderItemService.getByOid(o.getoId()).getData();
            if(items.size()!=0){
                Flight f = flightService.getById(ticketService.getById(items.get(0).gettId()).getData().getfId()).getData();
                BeanUtils.copyProperties(f,orderListDto);
                orderListDto.setItemList(items);
                result.add(orderListDto);
            }

        }
        return result;
    }

    @Override
    public void getOverdueOrderAndCancel() {
        //搜索满足要求的订单
        List<Order> list = orderMapper.getOverdueOrder(new Date());
        for(Order o: list){
            //对每个订单项进行退单补票操作
            List<OrderItem> oiList = orderItemService.getByOid(o.getoId()).getData();
            orderItemService.refundTicket(oiList);
        }
        //更新订单状态
        orderMapper.checkOrder(new Date());
    }
}
