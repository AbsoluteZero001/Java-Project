package com.springboot.springboot2.property.controller;

import com.springboot.springboot2.constant.FreightBasisData.FreightBasisData;
import com.springboot.springboot2.pojo.ResponsePojo;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/freightBasis")
@Tag(name = "费率相关API", description = "费率相关操作接口")
public class FreightBasisController {

    private final FreightBasisData freightBasisData;

    // 构造器注入，Spring 自动装配 FreightBasisData
    public FreightBasisController(FreightBasisData freightBasisData) {
        this.freightBasisData = freightBasisData;
    }

    // 示例接口
    @GetMapping("/list")
    @Operation(summary = "获取费率列表", description = "返回所有费率基础信息")
    public String getFreightList() {
        return "费率列表";
    }

    // 查询费用说明
    @PostMapping("/queryAll")
    @Operation(summary = "查询费用说明", description = "返回水费、电费、物业费基础数据")
    public ResponsePojo<FreightBasisData> queryAll() {
        return ResponsePojo.success(freightBasisData);
    }
}
