package com.springboot.springboot2.service;

import com.springboot.springboot2.pojo.PageResult;
import com.springboot.springboot2.pojo.Room;

import java.util.List;
import java.util.Map;

public interface RoomService {
    List<Room> roomsOfFloor(Integer floorId);
    int insertRooms(List<Room> rooms);
    PageResult<Room> pageOfRoom(Map<String, String> map);
    int changeRoomStatus(List<Integer> idList, int status);
}

