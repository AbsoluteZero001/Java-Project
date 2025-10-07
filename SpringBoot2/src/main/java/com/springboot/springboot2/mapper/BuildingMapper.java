package com.springboot.springboot2.mapper;

import com.springboot.springboot2.pojo.Building;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface BuildingMapper {

    // 根据状态查询楼栋
    List<Building> buildingsOfStatus(int status);

    // 插入楼栋
    int insertBuilding(Building building);

    //添加insertBuildings方法
    int insertBuildings(List<Building> buildings);
}
