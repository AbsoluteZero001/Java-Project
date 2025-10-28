package com.springboot.springboot.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.springboot.springboot.mapper.BuildingMapper;
import com.springboot.springboot.pojo.Building;
import com.springboot.springboot.pojo.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 建筑服务实现类
 * 实现了BuildingService接口，提供建筑相关的业务逻辑处理
 */
@Service
public class BuildingServiceImpl implements BuildingService {

    /**
     * 建筑数据访问层注入
     * 用于与数据库进行交互，执行建筑相关的数据操作
     */
    @Autowired
    private BuildingMapper buildingMapper;

    /**
     * 分页查询建筑信息
     *
     * @param current 当前页码
     * @param size 每页显示数量
     * @param number 建筑编号（查询条件）
     * @return PageResult<Building> 分页结果对象，包含建筑列表和分页信息
     */
    @Override
    public PageResult<Building> pageOfBuilding(Integer current, Integer size, String number) {
        // 开启分页功能，使用PageHelper插件
        PageHelper.startPage(current, size);

        // 调用 Mapper 查询数据
        Page<Building> buildings = buildingMapper.findAllBuilding(number);

        // 封装成 PageResult 返回
        return PageResult.restPage(buildings);
    }
}
