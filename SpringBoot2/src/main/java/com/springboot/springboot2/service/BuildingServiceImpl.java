package com.springboot.springboot2.service;

import com.springboot.springboot2.mapper.BuildingMapper;
import com.springboot.springboot2.pojo.Building;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BuildingServiceImpl implements BuildingService {

    @Autowired
    private BuildingMapper buildingMapper;

    @Override
    public List<Building> buildingsOfUsed() {
        // 调用 Mapper 方法获取状态为1的建筑
        return buildingMapper.buildingsOfStatus(1);
    }
}
