package com.xietian.graduated.service.impl;

import com.xietian.graduated.common.util.Result;
import com.xietian.graduated.dao.PlaneMapper;
import com.xietian.graduated.pojo.Plane;
import com.xietian.graduated.pojo.PlaneExample;
import com.xietian.graduated.service.PlaneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaneServiceImpl implements PlaneService {

    @Autowired
    PlaneMapper planeMapper;

    @Override
    public Result<String> addPlane(Plane plane) {
        if(planeMapper.insertSelective(plane)>0){
            return Result.isSuccess();
        }
        else return Result.isError(101,"插入失败");
    }

    @Override
    public Result<String> delPlane(int pid) {
        if(planeMapper.deleteByPrimaryKey(pid)>0){
            return Result.isSuccess();
        }
        else return Result.isError(102,"删除失败");
    }

    @Override
    public Result<String> updatePlane(Plane plane) {

        Plane p = planeMapper.selectByPrimaryKey(plane.getpId());
        if(p==null) return Result.isError(104,"操作数据不存在");

        PlaneExample planeExample = new PlaneExample();
        PlaneExample.Criteria criteria = planeExample.createCriteria();
        criteria.andPIdEqualTo(plane.getpId());

        if(planeMapper.updateByExampleSelective(plane,planeExample)>0){
            return Result.isSuccess();
        }
        else return Result.isError(103,"更新失败");
    }

    @Override
    public Result<Plane> getById(int pid) {
        return Result.isSuccess(planeMapper.selectByPrimaryKey(pid));
    }

    @Override
    public Result<List<Plane>> getAllPlane() {
        PlaneExample planeExample = new PlaneExample();
        PlaneExample.Criteria criteria = planeExample.createCriteria();
        criteria.andPIdGreaterThan(0);
        planeExample.setOrderByClause("p_id desc");
        return Result.isSuccess(planeMapper.selectByExample(planeExample));
    }

    @Override
    public Result<List<Plane>> list(int pageNo, int pageSize, String pName) {
        return Result.isSuccess(planeMapper.list(pageNo,pageSize,pName));
    }
}
