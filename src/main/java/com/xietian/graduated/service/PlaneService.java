package com.xietian.graduated.service;

import com.xietian.graduated.common.util.Result;
import com.xietian.graduated.pojo.Plane;

import java.util.List;

public interface PlaneService {
    Result<String> addPlane(Plane plane);

    Result<String> delPlane(int pid);

    Result<String> updatePlane(Plane plane);

    Result<Plane> getById(int pid);

    Result<List<Plane>> getAllPlane();

}
