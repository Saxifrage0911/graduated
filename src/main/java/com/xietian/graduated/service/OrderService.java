package com.xietian.graduated.service;

import com.xietian.graduated.common.util.Result;
import com.xietian.graduated.dto.OrderCountDto;
import com.xietian.graduated.dto.OrderListDto;
import com.xietian.graduated.pojo.Order;

import java.util.List;

public interface OrderService {

    Result<Integer> addOrder(Order order);

    Result<String> cancelOrder(Integer oId);

    Result<String> updateOrderTotalPrice(Integer oId);

    Result<String> payOrder(Integer oId);

    Result<List<OrderListDto>> getByUidF(Integer pageNo, Integer pageSize, Integer uId);

    Result<List<OrderListDto>> getByUidU(Integer pageNo, Integer pageSize, Integer uId);

    Result<OrderCountDto> getOrderCount(Integer uId);

    Result<Long> getAllOrderCount();

    Result<List<OrderListDto>> selectAll(Integer pageNo, Integer pageSize,Integer uid);

    List<Order> getAllForExport();

    void getOverdueOrderAndCancel();
}
