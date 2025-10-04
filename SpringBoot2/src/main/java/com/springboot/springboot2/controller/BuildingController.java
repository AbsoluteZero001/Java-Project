package com.springboot.springboot2.controller;

import com.springboot.springboot2.pojo.Building;
import com.springboot.springboot2.pojo.ResponsePojo;
import com.springboot.springboot2.service.BuildingService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "楼栋相关API")
@RequestMapping("/building")
@RestController
public class BuildingController {

    @Autowired
    private BuildingService buildingService;

    /**
     * 查询在用楼栋列表
     */
    @GetMapping("/buildingOfUsed")
    @Operation(summary = "查询在用楼栋列表")
    public ResponsePojo<List<Building>> buildingOfUsed() {
        return ResponsePojo.success(buildingService.buildingsOfUsed());
    }

    /**
     * 新增单个楼栋
     */
    @PostMapping("/addBuilding")
    @Operation(summary = "新增单个楼栋")
    public ResponsePojo<Integer> addBuilding(@RequestBody Building building) { // ✅ 使用 Spring 的 @RequestBody
        int result = -1;
        try {
            // ✅ 修正方法名：原来拼写为 intsertBuilding，改为 insertBuilding
            result = buildingService.insertBuilding(building);
            return ResponsePojo.success(result);
        } catch (DuplicateKeyException e) { // ✅ 使用 Spring 的 DuplicateKeyException
            return ResponsePojo.fail(result, "楼栋编码已存在");
        }
    }
}
