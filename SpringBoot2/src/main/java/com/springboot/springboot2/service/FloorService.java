package com.springboot.springboot2.service;

import com.springboot.springboot2.pojo.Floor;

import java.util.List;

public interface FloorService {
    List<Floor> floorsOfBuilding(Integer buildingId);
}
