package com.xietian.graduated.dao;


import com.xietian.graduated.pojo.Flight;
import com.xietian.graduated.pojo.FlightExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
@Mapper
public interface FlightMapper {
    long countByExample(FlightExample example);

    int deleteByExample(FlightExample example);

    int deleteByPrimaryKey(Integer fId);

    int insert(Flight record);

    int insertSelective(Flight record);

    List<Flight> selectByExample(FlightExample example);

    List<Flight> selectByDetail(@Param("from") String from, @Param("to") String to, @Param("startDay") Date startDay);

    Flight selectByPrimaryKey(Integer fId);

    Flight getLatestFlight();

    List<Flight> getEnableDistributeFlight(@Param("now") Date now);

    int updateByExampleSelective(@Param("record") Flight record, @Param("example") FlightExample example);

    int updateByExample(@Param("record") Flight record, @Param("example") FlightExample example);

    int updateByPrimaryKeySelective(Flight record);

    int updateByPrimaryKey(Flight record);

    int ticketSoldEco(@Param("fId") Integer fId, @Param("inc") Integer increment);

    int ticketSoldBus(@Param("fId") Integer fId, @Param("inc") Integer increment);

    int ticketSoldFc(@Param("fId") Integer fId, @Param("inc") Integer increment);
}