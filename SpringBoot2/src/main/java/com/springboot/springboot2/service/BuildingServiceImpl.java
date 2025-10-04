package com.springboot.springboot2.service.impl;

import com.springboot.springboot2.mapper.BuildingMapper;
import com.springboot.springboot2.pojo.Building;
import com.springboot.springboot2.service.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
public class BuildingServiceImpl implements BuildingService {

    @Autowired
    private BuildingMapper buildingMapper;

    @Override
    public List<Building> buildingsOfUsed() {
        return buildingMapper.buildingsOfStatus(1);
    }

    @Override
    public int insertBuilding(Building building) throws DuplicateKeyException {
        if (building.getBuildingName() == null || building.getBuildingName().isEmpty()) {
            throw new IllegalArgumentException("楼栋名称不能为空");
        }
        if (building.getBuildingCode() == null || building.getBuildingCode().isEmpty()) {
            throw new IllegalArgumentException("楼栋编码不能为空");
        }
        if (building.getCompletionDate() == null) {
            building.setCompletionDate(LocalDate.now());
        }
        if (building.getBuildingStatus() == null) {
            building.setBuildingStatus((short)1);
        }
        if (building.getBuildingFloors() == null) {
            building.setBuildingFloors((short)1);
        }
        if (building.getDesignLife() == null) {
            building.setDesignLife((short)50);
        }
        if (building.getOwnership() == null) {
            building.setOwnership((short)1);
        }
        return buildingMapper.insertBuilding(building);
    }
}
