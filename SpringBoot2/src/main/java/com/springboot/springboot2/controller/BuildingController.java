package com.springboot.springboot2.controller;

import com.springboot.springboot2.pojo.Building;
import com.springboot.springboot2.pojo.ResponsePojo;
import com.springboot.springboot2.service.BuildingService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@Tag(name = "楼栋相关API")
@RequestMapping("/building")
@RestController
public class BuildingController {

    @Autowired
    private BuildingService buildingService;

    @GetMapping("/buildingOfUsed")
    @Operation(summary = "查询再用楼栋列表")
    public ResponsePojo<List<Building>> buildingOfUsed() {
        return ResponsePojo.success(buildingService.buildingsOfUsed());
    }
}

