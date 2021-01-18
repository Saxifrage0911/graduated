package com.xietian.graduated.controller;

import com.xietian.graduated.common.util.Result;
import com.xietian.graduated.pojo.Order;
import com.xietian.graduated.service.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "订单数据操作")
@RestController
public class OrderController {

    @Autowired
    OrderService orderService;

    @ApiOperation(value = "添加订单")
    @PostMapping("/addOrder")
    public Result<Integer> addOrder(@RequestBody @Validated Order order){
        return orderService.addOrder(order);
    }

    @ApiOperation(value = "更新订单总额")
    @GetMapping("/updateTotalPrice")
    public Result<String> updateTotalPrice(@Param("oid") Integer oid){
        return orderService.updateOrderTotalPrice(oid);
    }

    @ApiOperation(value = "取消订单")
    @DeleteMapping("/cancelOrder")
    public Result<String> cancelOrder(@Param("oid") Integer oid){
        return orderService.cancelOrder(oid);
    }

    @ApiOperation(value = "支付订单")
    @GetMapping("/payOrder")
    public Result<String> payOrder(@Param("oid") Integer oid){
        return orderService.payOrder(oid);
    }

    @ApiOperation(value = "获取所有已完成订单")
    @GetMapping("/getFOrder")
    public Result<List<Order>> getFOrder(@Param("uid") Integer uid){
        return orderService.getByUidF(uid);
    }

    @ApiOperation(value = "获取所有未完成订单")
    @GetMapping("/getUOrder")
    public Result<List<Order>> getUOrder(@Param("uid") Integer uid){
        return orderService.getByUidU(uid);
    }
}
