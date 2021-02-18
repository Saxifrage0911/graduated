package com.xietian.graduated.controller;

import com.xietian.graduated.common.util.Result;
import com.xietian.graduated.dto.ItemDto;
import com.xietian.graduated.pojo.OrderItem;
import com.xietian.graduated.service.OrderItemService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "订单项数据操作")
@RestController
public class OrderItemController {

    @Autowired
    OrderItemService orderItemService;

    @ApiOperation(value = "增加订单项")
    @PostMapping("/addItem")
    public Result<String> addItem(@RequestBody @Validated ItemDto itemDto){
        return orderItemService.buyTicket(itemDto.getOid(),itemDto.getTid(),itemDto.getUid(),itemDto.getIdnum(),itemDto.getRealName());
    }

    @ApiOperation(value = "删除订单项")
    @DeleteMapping("/delItem")
    public Result<String> delItem(@RequestParam("itemId") Integer itemId){
        return orderItemService.delItem(itemId);
    }

    @ApiOperation(value = "根据订单号获取所有订单项")
    @GetMapping("/getByOId")
    public Result<List<OrderItem>> getByOId(@RequestParam("oid") Integer oid){
        return orderItemService.getByOid(oid);
    }
}
