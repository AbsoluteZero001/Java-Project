package com.springboot.springboot2.service;

import com.springboot.springboot2.mapper.FloorMapper;
import com.springboot.springboot2.pojo.Floor;
import org.springframework.stereotype.Service;

import jakarta.annotation.Resource;
import java.util.List;

@Service
public class FloorServiceImpl implements FloorService {

    @Resource
    private FloorMapper floorMapper;

    @Override
    public List<Floor> floorsOfBuilding(Integer buildingId) {
        return floorMapper.floorsOfBuilding(buildingId);
    }
}
