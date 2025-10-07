package com.springboot.springboot2.service;


import com.springboot.springboot2.mapper.RoomMapper;
import com.springboot.springboot2.pojo.Room;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomServiceImpl implements RoomService {
    @Resource
    RoomMapper roomMapper;

    @Override
    public List<Room> roomsOfFloor(Integer floorId) {
        return roomMapper.roomsOfFloor(floorId);
    }

    //实现Cloneable接口，实现深拷贝
    @Override
    public Room clone() throws CloneNotSupportedException {
        return (Room) super.clone();
    }


    @Override
    public int insertRooms(List<Room> rooms) {
        return roomMapper.insertRooms(rooms); // RoomMapper 需要实现批量插入
    }
}