package com.springboot.springboot2.service;

import com.springboot.springboot2.pojo.Building;
import org.springframework.dao.DuplicateKeyException;
import java.util.List;

public interface BuildingService {

    // 查询正在使用的楼栋
    List<Building> buildingsOfUsed();

    // 添加楼栋
    int insertBuilding(Building building) throws DuplicateKeyException;
}
