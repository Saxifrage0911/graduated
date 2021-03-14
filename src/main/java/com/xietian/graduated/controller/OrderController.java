package com.xietian.graduated.controller;

import cn.hutool.core.io.IoUtil;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import com.xietian.graduated.common.util.Result;
import com.xietian.graduated.dto.OrderCountDto;
import com.xietian.graduated.dto.OrderListDto;
import com.xietian.graduated.pojo.Order;
import com.xietian.graduated.service.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.jaxb.SpringDataJaxb;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
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
    public Result<String> updateTotalPrice(@RequestParam("oid") Integer oid){
        return orderService.updateOrderTotalPrice(oid);
    }

    @ApiOperation(value = "取消订单")
    @GetMapping("/cancelOrder")
    public Result<String> cancelOrder(@RequestParam("oid") Integer oid){
        return orderService.cancelOrder(oid);
    }

    @ApiOperation(value = "支付订单")
    @GetMapping("/payOrder")
    public Result<String> payOrder(@RequestParam("oid") Integer oid){
        return orderService.payOrder(oid);
    }

    @ApiOperation(value = "获取所有已完成订单")
    @GetMapping("/getFOrder")
    public Result<List<OrderListDto>> getFOrder(@RequestParam(value = "pageNo") Integer pageNo,
                                                @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                @RequestParam("uid") Integer uid){
        if(pageNo<0) pageNo=1;
        if(pageSize<1) pageSize=10;
        pageNo = (pageNo-1)*pageSize;
        return orderService.getByUidF(pageNo,pageSize,uid);
    }

    @ApiOperation(value = "获取所有未完成订单")
    @GetMapping("/getUOrder")
    public Result<List<OrderListDto>> getUOrder(@RequestParam(value = "pageNo") Integer pageNo,
                                                @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                @RequestParam("uid") Integer uid){
        if(pageNo<0) pageNo=1;
        if(pageSize<1) pageSize=10;
        pageNo = (pageNo-1)*pageSize;
        return orderService.getByUidU(pageNo,pageSize,uid);
    }

    @ApiOperation(value = "获取订单数量")
    @GetMapping("/getOrderCount")
    public Result<OrderCountDto> getOrderCount(@RequestParam("uid") Integer uid){
        return orderService.getOrderCount(uid);
    }

    @ApiOperation(value = "获取全部订单数量（管理员）")
    @GetMapping("/admin/getAllOrderCount")
    public Result<Long> getAllOrderCount(){
        return orderService.getAllOrderCount();
    }

    @ApiOperation(value = "获取所有订单（管理员）")
    @GetMapping("/admin/getAllOrder")
    public Result<List<OrderListDto>> getAllOrder(@RequestParam(value = "pageNo") Integer pageNo,
                                                  @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                  @RequestParam(value = "uid", required = false) Integer uid){
        if(pageNo<0) pageNo=1;
        if(pageSize<1) pageSize=10;
        pageNo = (pageNo-1)*pageSize;
        return orderService.selectAll(pageNo,pageSize,uid);
    }

    @ApiOperation(value = "将订单数据打印为excel表")
    @GetMapping("/admin/exportOrder")
    public void export(HttpServletResponse response) {
        List<Order> list =orderService.getAllForExport();
        ExcelWriter writer = ExcelUtil.getWriter();
// 合并单元格后的标题行，使用默认标题样式
        writer.merge(6, "订单数据");
// 一次性写出内容，使用默认样式，强制输出标题
        writer.write(list, true);
        Date d = new Date();
        DateFormat df = new SimpleDateFormat("yyyyMMddHHmm");
        String str = df.format(d);
        response.setContentType("application/vnd.ms-excel;charset=utf-8");
//test.xls是弹出下载对话框的文件名，不能为中文，中文请自行编码
        response.setHeader("Content-Disposition","attachment;filename="+str+"order.xls");
        ServletOutputStream out= null;
        try {
            out = response.getOutputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }

        writer.flush(out, true);
// 关闭writer，释放内存
        writer.close();
//此处记得关闭输出Servlet流
        IoUtil.close(out);

    }

}
