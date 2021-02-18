package com.xietian.graduated.service;

import com.xietian.graduated.common.util.Result;
import com.xietian.graduated.pojo.OrderItem;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
public interface OrderItemService {

    Result<String> delItem(int itemId);

    Result<String> buyTicket(int oid,int tid,int uid,String idnum, String realName);

    Result<List<OrderItem>> getByOid(int oid);

    Result<String> refundTicket(List<OrderItem> list);

    List<OrderItem> getByTId(int tid);

    void updateSeat(int itemId, String seat);
}
