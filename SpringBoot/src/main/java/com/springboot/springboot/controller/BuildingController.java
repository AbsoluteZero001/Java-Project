package com.springboot.springboot.controller;

import com.springboot.springboot.pojo.Building;
import com.springboot.springboot.pojo.PageResult;
import com.springboot.springboot.pojo.ResponsePojo;
import com.springboot.springboot.service.BuildingService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 楼栋控制器类
 * 提供楼栋相关的HTTP接口服务
 */
@RestController
@Tag(name = "楼栋相关接口", description = "楼栋相关的增删改查接口")
public class BuildingController {

    /**
     * 楼栋服务接口
     * 通过Spring自动注入
     */
    @Autowired
    private BuildingService buildingService;

    /**
     * 查询楼栋分页信息接口
     * @param current 当前页码，默认为1
     * @param size 每页显示条数，默认为10
     * @param number 楼栋编号，可选参数
     * @return 返回ResponsePojo包装的PageResult<Building>对象
     */
    @GetMapping("/page/building")
    @Operation(
            summary = "查询楼栋分页信息",
            description = "根据页码、每页条数及可选楼栋编号分页查询楼栋列表",
            responses = {
                    @ApiResponse(
                            description = "返回楼栋分页信息",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = ResponsePojo.class)
                            )
                    )
            }
    )
    public ResponsePojo<PageResult<Building>> pageOfBuilding(
            @Parameter(description = "当前页，默认1", example = "1")
            @RequestParam(defaultValue = "1") Integer current,

            @Parameter(description = "每页条数，默认10", example = "10")
            @RequestParam(defaultValue = "10") Integer size,

            @Parameter(description = "楼栋编号，可选", example = "B101")
            @RequestParam(required = false) String number
    ) {
        // 调用 Service 并传入三个参数（支持 number 可选）
        PageResult<Building> pageResult = buildingService.pageOfBuilding(current, size, number);
        return ResponsePojo.success(pageResult);
    }
}
