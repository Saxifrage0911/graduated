package com.xietian.graduated.controller;

import com.xietian.graduated.common.util.Result;
import com.xietian.graduated.dto.FlightDto;
import com.xietian.graduated.pojo.Flight;
import com.xietian.graduated.service.FlightService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "航班数据操作")
@RestController
public class FlightController {

    @Autowired
    FlightService flightService;

    @ApiOperation(value = "添加航班(管理员)")
    @PostMapping("/admin/addFlight")
    public Result<Integer> addFlight(@RequestBody @Validated Flight flight){
        return flightService.addFlight(flight);
    }

    @ApiOperation(value = "更改航班数据(管理员)")
    @PutMapping("/admin/updateFlight")
    public Result<String> updateFlight(@RequestBody @Validated Flight flight){
        return flightService.updateFlight(flight);
    }

    @ApiOperation(value = "删除航班(管理员)")
    @DeleteMapping("/admin/delFlight")
    public Result<String> delFlight(@RequestParam("fId") Integer id){
        return flightService.delFlight(id);
    }

    @ApiOperation(value = "获取所有航班(管理员)")
    @GetMapping("/admin/getAllFlight")
    public Result<List<Flight>> getAllFlight(){
        return flightService.getAllFlight();
    }

    @ApiOperation(value = "分页获取航班数据")
    @GetMapping("/admin/getForPage")
    public Result<List<Flight>> getForPage(@RequestParam(value = "pageNo", defaultValue = "1") int pageNo,
                                           @RequestParam(value = "pageSize", defaultValue = "10") int pageSize,
                                           @RequestParam(value = "fName", required = false) String fName){
        if(pageNo<1) pageNo = 1;
        if(pageSize<0) pageSize = 10;
        pageNo = (pageNo-1)*pageSize;
        return flightService.selectForPage(pageNo,pageSize,fName);
    }
    @ApiOperation(value = "提供用户查询航班数据")
    @PostMapping("/getFlightByDetail")
    public Result<List<Flight>> getByDetail(@RequestBody @Validated FlightDto flightDto){
        return flightService.getFlightByDetail(flightDto.getFrom(),flightDto.getTo(),flightDto.getStartDay());
    }

    @ApiOperation(value = "根据id获取航班")
    @GetMapping("/getFlightById")
    public Result<Flight> getById(@RequestParam("fId") Integer fId){
        return flightService.getById(fId);
    }
}
