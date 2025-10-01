package com.springboot.springboot2.controller;

import com.springboot.springboot2.pojo.ResponsePojo;
import com.springboot.springboot2.pojo.Room;
import com.springboot.springboot2.service.RoomService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@Tag(name = "房间相关API")
@RequestMapping("/room")
@RestController
public class RoomController {

    @Autowired
    private RoomService roomService;

    @GetMapping("/roomsOfFloor/{floorId}")
    @Operation(summary = "根据楼层ID查询房间列表")
    public ResponsePojo<List<Room>> roomsOfFloor(
            @Parameter(description = "楼层ID", required = true)
            @PathVariable("floorId") Integer floorId) {

        List<Room> list = roomService.roomsOfFloor(floorId);

        if (list != null && !list.isEmpty()) {
            return ResponsePojo.success(list);
        } else {
            return ResponsePojo.fail(list, "floorId 查询不到对应房间");
        }
    }
}
