package com.springboot.springboot2.service;

import com.springboot.springboot2.pojo.Room;

import java.util.List;

public interface RoomService {
    List<Room> roomsOfFloor(Integer floorId);
    int insertRooms(List<Room> rooms);
}

