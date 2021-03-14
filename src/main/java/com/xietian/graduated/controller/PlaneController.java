package com.xietian.graduated.controller;

import com.xietian.graduated.common.util.Result;
import com.xietian.graduated.pojo.Plane;
import com.xietian.graduated.service.PlaneService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Api(tags = "航班飞机数据操作")
@RestController
@RequestMapping("/admin")
public class PlaneController {

    @Autowired
    PlaneService planeService;

    @PostMapping("/addPlane")
    @ApiOperation(value = "添加飞机(管理员）")
    public Result<String> addPlane(@RequestBody @Validated Plane plane){
        return planeService.addPlane(plane);
    }

    @DeleteMapping("/delPlane")
    @ApiOperation(value = "删除飞机(管理员）")
    public Result<String> delPlane(@RequestParam("id") Integer id){
        return planeService.delPlane(id);
    }

    @PutMapping("/updatePlane")
    @ApiOperation(value = "更新飞机(管理员）")
    public Result<String> updatePlane(@RequestBody @Validated Plane plane){
        return planeService.updatePlane(plane);
    }

    @GetMapping("/getAllPlane")
    @ApiOperation(value = "获取所有飞机(管理员）")
    public Result<List<Plane>> getAllPlane(){
        return planeService.getAllPlane();
    }

    @GetMapping("/getPlaneById")
    @ApiOperation(value = "根据id获取飞机")
    public Result<Plane> getById(@RequestParam("pId") Integer pId){
        return planeService.getById(pId);
    }

    @GetMapping("/getPlaneForPage")
    @ApiOperation(value = "获取飞机页面数据")
    public Result<List<Plane>> getPlaneForPage(@RequestParam(value = "pageNo", defaultValue = "1") int pageNo,
                                               @RequestParam(value = "pageSize", defaultValue = "10") int pageSize,
                                               @RequestParam(value = "pName", required = false) String pName){
        if(pageNo<1) pageNo = 1;
        if(pageSize<0) pageSize = 10;
        pageNo = (pageNo-1)*pageSize;
        return planeService.list(pageNo,pageSize,pName);
    }
}
