package com.xietian.graduated.dao;

import com.xietian.graduated.pojo.Order;
import com.xietian.graduated.pojo.OrderExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
@Mapper
public interface OrderMapper {
    long countByExample(OrderExample example);

    int deleteByExample(OrderExample example);

    int deleteByPrimaryKey(Integer oId);

    int insert(Order record);

    int insertSelective(Order record);

    List<Order> selectByExample(OrderExample example);

    Order selectByPrimaryKey(Integer oId);

    int updateByExampleSelective(@Param("record") Order record, @Param("example") OrderExample example);

    int updateByExample(@Param("record") Order record, @Param("example") OrderExample example);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);

    int checkOrder(@Param("now") Date now);

    List<Order> getOverdueOrder(@Param("now") Date now);

    Order getLatestOrder();

    List<Order> uList(@Param("pageNo") int pageNo, @Param("pageSize") int pageSize, @Param("uId") int uid);

    List<Order> fList(@Param("pageNo") int pageNo, @Param("pageSize") int pageSize, @Param("uId") int uid);

    List<Order> selectAll(@Param("pageNo") int pageNo, @Param("pageSize") int pageSize, @Param("uId") Integer uid);
}