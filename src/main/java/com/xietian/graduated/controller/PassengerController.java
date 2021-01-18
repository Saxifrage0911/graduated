package com.xietian.graduated.controller;

import com.xietian.graduated.common.util.Result;
import com.xietian.graduated.pojo.Passenger;
import com.xietian.graduated.service.PassengerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "乘客数据操作")
@RestController
public class PassengerController {

    @Autowired
    PassengerService passengerService;

    @ApiOperation(value = "添加乘客")
    @PostMapping("/addPassenger")
    public Result<String> addPassenger(@RequestBody @Validated Passenger passenger){
        return passengerService.addPassenger(passenger);
    }

    @ApiOperation(value = "删除乘客")
    @DeleteMapping("/delPassenger")
    public Result<String> delPassenger(@RequestParam("id") Integer id){
        return passengerService.delPassenger(id);
    }

    @ApiOperation(value = "更新乘客")
    @PutMapping("/updatePassenger")
    public Result<String> upPassenger(@RequestBody @Validated Passenger passenger){
        return passengerService.updatePassenger(passenger);
    }

    @ApiOperation(value = "获取当前用户的所有乘客")
    @GetMapping("/getAllPassByAccount")
    public Result<List<Passenger>> getPassByUAccount(@RequestParam("account") String account){
        return passengerService.getByUAccount(account);
    }

    @ApiOperation(value = "通过身份证号获取姓名")
    @GetMapping("/getNameByIDNUM")
    public Result<String> getNameByIDNUM(String idnum){
        return passengerService.getNameByIDNUM(idnum);
    }
}
