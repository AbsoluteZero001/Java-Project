package com.springboot.springboot2.mapper;

import com.springboot.springboot2.pojo.Floor;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FloorMapper {
    @Select("select floor_id,floor_number from floor where belong_building = #{id}")
    List<Floor> floorsOfBuilding(Integer id);
}
