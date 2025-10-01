package com.springboot.springboot2.mapper;

import com.springboot.springboot2.pojo.Building;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface BuildingMapper {

    @Select("<script>" +
            "SELECT building_id, building_name " +
            "FROM building " +
            "<where> " +
            "<if test='status != 0'>building_status = #{status}</if> " +
            "</where>" +
            "</script>")
    List<Building> buildingsOfStatus(int status);
}
