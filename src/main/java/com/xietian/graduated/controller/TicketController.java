package com.xietian.graduated.controller;

import com.xietian.graduated.common.util.Result;
import com.xietian.graduated.pojo.Ticket;
import com.xietian.graduated.service.TicketService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "机票数据操作")
@RestController
public class TicketController {

    @Autowired
    TicketService ticketService;

    @ApiOperation(value = "添加机票")
    @PostMapping("/admin/addTicket")
    public Result<String> addTicket(@RequestBody List<Ticket> tickets){
        return ticketService.addTicket(tickets);
    }

    @ApiOperation(value = "修改机票")
    @PutMapping("/admin/updateTicket")
    public Result<String> updateTicket(@RequestBody List<Ticket> tickets){
        return ticketService.updateTicket(tickets);
    }

    @ApiOperation(value = "根据航班id获取机票")
    @GetMapping("/getTicketsByFid")
    public Result<List<Ticket>> getByFid(@RequestParam("fid") Integer fid){
        return ticketService.getByFid(fid);
    }

    @ApiOperation(value = "查询页面根据航班id列表返回机票数据")
    @PostMapping("/getByFidList")
    public Result<List<Ticket>> getByFidList(@RequestBody List<Integer> list){
        return ticketService.getByFidList(list);
    }

}
