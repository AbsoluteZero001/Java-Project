package com.springboot.springboot2.mapper;

import com.springboot.springboot2.pojo.Room;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface RoomMapper {

    /**
     * 根据房间ID查询单个房间
     */
    @Select("SELECT room_id, room_code, room_floor_id, built_up_area, room_status FROM room WHERE room_id = #{id}")
    Room roomById(@Param("id") Integer id);

    /**
     * 根据楼层ID查询房间列表
     */
    List<Room> roomsOfFloor(@Param("floorId") Integer floorId);

    /**
     * 根据用户的房间ID查询房间列表
     */
    List<Room> getRoomsByUserRoomId(@Param("userRoomId") Short userRoomId);
}
