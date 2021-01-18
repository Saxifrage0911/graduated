package com.xietian.graduated.service.impl;

import com.xietian.graduated.common.util.Result;
import com.xietian.graduated.dao.PassengerMapper;
import com.xietian.graduated.pojo.Passenger;
import com.xietian.graduated.pojo.PassengerExample;
import com.xietian.graduated.pojo.User;
import com.xietian.graduated.service.PassengerService;
import com.xietian.graduated.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PassengerServiceImpl implements PassengerService{

    @Autowired
    PassengerMapper passengerMapper;
    @Autowired
    UserService userService;

    @Override
    public Result<String> addPassenger(Passenger passenger) {
        if(passengerMapper.insertSelective(passenger)>0){
            return Result.isSuccess();
        }
        else return Result.isError(101,"插入失败");
    }

    @Override
    public Result<String> delPassenger(Integer passId) {
        if(passengerMapper.deleteByPrimaryKey(passId)>0){
            return Result.isSuccess();
        }
        else return Result.isError(102,"删除失败");
    }

    @Override
    public Result<String> updatePassenger(Passenger passenger) {
        if(passenger.getPassId()==null){
            return Result.isError(110,"参数异常");
        }
        PassengerExample passengerExample = new PassengerExample();
        PassengerExample.Criteria criteria = passengerExample.createCriteria();
        criteria.andPassIdEqualTo(passenger.getPassId());
        if(passengerMapper.updateByExampleSelective(passenger,passengerExample)>0){
            return Result.isSuccess();
        }
        return Result.isError(103,"更新失败");
    }

    @Override
    public Result<List<Passenger>> getByUAccount(String account) {
        User user = userService.getUserByAccount(account).getData();
        if(user==null){
            return Result.isError(104,"操作数据不存在");
        }
        int uid = user.getuId();
        PassengerExample passengerExample = new PassengerExample();
        PassengerExample.Criteria criteria = passengerExample.createCriteria();
        criteria.andUIdEqualTo(uid);
        return Result.isSuccess(passengerMapper.selectByExample(passengerExample));
    }

    @Override
    public Result<String> getNameByIDNUM(String idnum) {
        PassengerExample passengerExample = new PassengerExample();
        PassengerExample.Criteria criteria = passengerExample.createCriteria();
        criteria.andPIdnumEqualTo(idnum);
        Passenger p = passengerMapper.selectByExample(passengerExample).get(0);
        if(p==null){
            return Result.isError(104,"操作数据不存在");
        }
        else return Result.isSuccess(p.getpRealname());
    }
}
