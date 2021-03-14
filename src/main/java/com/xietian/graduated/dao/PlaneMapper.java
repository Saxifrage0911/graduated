package com.xietian.graduated.dao;

import com.xietian.graduated.pojo.Plane;
import com.xietian.graduated.pojo.PlaneExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface PlaneMapper {
    long countByExample(PlaneExample example);

    int deleteByExample(PlaneExample example);

    int deleteByPrimaryKey(Integer pId);

    int insert(Plane record);

    int insertSelective(Plane record);

    List<Plane> selectByExample(PlaneExample example);

    Plane selectByPrimaryKey(Integer pId);

    int updateByExampleSelective(@Param("record") Plane record, @Param("example") PlaneExample example);

    int updateByExample(@Param("record") Plane record, @Param("example") PlaneExample example);

    int updateByPrimaryKeySelective(Plane record);

    int updateByPrimaryKey(Plane record);

    List<Plane> list(@Param("pageNo") int pageNo, @Param("pageSize") int pageSize, @Param("pName") String pName);
}