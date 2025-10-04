package com.springboot.springboot.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.springboot.springboot.mapper.FloorMapper;
import com.springboot.springboot.pojo.Floor;
import com.springboot.springboot.pojo.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FloorServiceImpl implements FloorService {

    @Autowired
    private FloorMapper floorMapper;

    @Override
    public PageResult<Floor> pageOfFloor(Integer current, Integer size, String number) {
        // 开启分页
        PageHelper.startPage(current, size);

        // 查询楼层列表，Mapper SQL 已经用 <association> 返回嵌套 Building 对象
        List<Floor> floors = floorMapper.findAllFloor(number);

        // PageHelper 会自动拦截 List 并生成 Page 对象
        Page<Floor> page = (Page<Floor>) floors;

        // 返回分页结果
        return PageResult.restPage(page);
    }
}
