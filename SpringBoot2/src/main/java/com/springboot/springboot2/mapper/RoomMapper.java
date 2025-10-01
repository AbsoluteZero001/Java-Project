package com.springboot.springboot2.mapper;

import com.springboot.springboot2.pojo.Room;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface RoomMapper {
    List<Room> getRoomsByUserRoomId(@Param("userRoomId") Short userRoomId);
}
