package com.springboot.springboot2.controller;

import com.springboot.springboot2.pojo.PageResult;
import com.springboot.springboot2.pojo.ResponsePojo;
import com.springboot.springboot2.pojo.User;
import com.springboot.springboot2.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@Tag(name = "业主相关 API")
@RequestMapping("/user")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    // 之前的 insertUser 方法...

    /**
     * 分页查询业主信息
     */
    @GetMapping("/pageOfOwners")
    @Operation(summary = "分页查询业主信息",
            description = "分页查询业主信息，默认为第一页，每页默认 10 条数据。若当前页小于1，强制为1；若每页行数小于1，强制为1")
    public ResponsePojo<PageResult<User>> pageOfOwners(
            @Parameter(description = "当前页", example = "1")
            @RequestParam(defaultValue = "1") Integer current,
            @Parameter(description = "每页行数", example = "10")
            @RequestParam(defaultValue = "10") Integer size) {

        // 参数校验
        if (current < 1) current = 1;
        if (size < 1) size = 10;

        PageResult<User> page = userService.pageOfOwner(current, size);
        return ResponsePojo.success(page);
    }
}
