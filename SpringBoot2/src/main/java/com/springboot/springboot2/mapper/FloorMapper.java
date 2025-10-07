package com.springboot.springboot2.mapper;

import com.springboot.springboot2.pojo.Floor;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FloorMapper {

    /**
     * 批量插入楼层
     */
    @Insert("<script>" +
            "INSERT INTO floor (floor_id, belong_building, floor_number, room_number) VALUES " +
            "<foreach collection='list' item='item' index='i' separator=','>" +
            "(#{item.floorId}, #{item.belongBuilding}, #{item.floorNumber}, #{item.roomNumber})" +
            "</foreach>" +
            "</script>")
    @Options(useGeneratedKeys = true, keyProperty = "floorId", keyColumn = "floor_id")
    int insertFloors(List<Floor> floors);

    /**
     * 根据楼栋ID查询楼层列表
     */
    @Select("SELECT floor_id, belong_building, floor_number, room_number FROM floor WHERE belong_building = #{id}")
    List<Floor> floorsOfBuilding(Integer id);
}
