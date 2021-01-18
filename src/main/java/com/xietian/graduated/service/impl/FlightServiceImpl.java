package com.xietian.graduated.service.impl;

import com.xietian.graduated.common.util.Result;
import com.xietian.graduated.dao.FlightMapper;
import com.xietian.graduated.pojo.Flight;
import com.xietian.graduated.pojo.FlightExample;
import com.xietian.graduated.pojo.Plane;
import com.xietian.graduated.service.FlightService;
import com.xietian.graduated.service.PlaneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class FlightServiceImpl implements FlightService{

    @Autowired
    FlightMapper flightMapper;

    @Autowired
    PlaneService planeService;

    @Override
    public Result<Integer> addFlight(Flight flight) {
        int pid = flight.getpId();
        Plane p = planeService.getById(pid).getData();

        if(p==null) return Result.isError(104,"操作数据不存在");

        if(flight.getfEco()==null){
            flight.setfEco(p.getpEco());
        }
        if(flight.getfBus()==null){
            flight.setfBus(p.getpBus());
        }
        if(flight.getfFc()==null){
            flight.setfFc(p.getpFc());
        }

        if(flightMapper.insertSelective(flight)>0){
            Flight f = flightMapper.getLatestFlight();
            return Result.isSuccess(f.getfId());
        }
        else return Result.isError(101,"插入失败");
    }

    @Override
    public Result<String> updateFlight(Flight flight) {
        Flight f = flightMapper.selectByPrimaryKey(flight.getfId());
        if(f==null) return Result.isError(104,"操作的数据不存在");

        FlightExample flightExample = new FlightExample();
        FlightExample.Criteria criteria = flightExample.createCriteria();
        criteria.andFIdEqualTo(flight.getfId());
        if(flightMapper.updateByExampleSelective(flight,flightExample)>0){
            return Result.isSuccess();
        }
        else return Result.isError(103,"更新失败");
    }

    @Override
    public Result<String> delFlight(int fid) {
        if(flightMapper.deleteByPrimaryKey(fid)>0){
            return Result.isSuccess();
        }
        else return Result.isError(102,"删除失败");
    }

    @Override
    public Result<List<Flight>> getAllFlight() {
        FlightExample flightExample = new FlightExample();
        FlightExample.Criteria criteria = flightExample.createCriteria();
        criteria.andFIdGreaterThan(0);
        return Result.isSuccess(flightMapper.selectByExample(flightExample));
    }

    @Override
    public List<Flight> getEnableDistributeFlight() {
        return flightMapper.getEnableDistributeFlight(new Date());
    }

    @Override
    public Result<Flight> getById(int fid) {
        return Result.isSuccess(flightMapper.selectByPrimaryKey(fid));
    }

    @Override
    public Result<List<Flight>> getFlightByDetail(String from, String to, Date startDay) {
        return Result.isSuccess(flightMapper.selectByDetail(from,to,startDay));
    }

    @Override
    public Result<String> soldTicket(Integer fid, String ticketType,Integer increment) {
        int re = 0;
        if("fc".equals(ticketType)){
            re = flightMapper.ticketSoldFc(fid,increment);
        }
        else if("bus".equals(ticketType)){
            re = flightMapper.ticketSoldBus(fid,increment);
        }
        else if("eco".equals(ticketType)){
            re = flightMapper.ticketSoldEco(fid,increment);
        }

        if(re>0){
            return Result.isSuccess();
        }
        else return Result.isError(104,"被操作的数据不存在");
    }

}
