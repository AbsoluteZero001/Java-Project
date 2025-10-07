package com.springboot.springboot2.mapper;

import com.springboot.springboot2.pojo.Room;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
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

    /**
     * 批量插入房间
     * 使用 MyBatis 的 foreach 遍历 list
     * 注意：room_id 使用自增主键，因此可以传 null
     */
    @Insert("<script>" +
            "INSERT INTO room (room_id, room_floor_id, built_up_area, room_code) VALUES " +
            "<foreach collection='list' item='item' index='i' separator=','>" +
            "(NULL, #{item.roomFloorId}, #{item.builtUpArea}, CONCAT(#{item.roomCode}, #{i+1}))" +
            "</foreach>" +
            "</script>")
    @Options(useGeneratedKeys = true, keyProperty = "roomId", keyColumn = "room_id")
    int insertRooms(@Param("list") List<Room> roomList);
}
