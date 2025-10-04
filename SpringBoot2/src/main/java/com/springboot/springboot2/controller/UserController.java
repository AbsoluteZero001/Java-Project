package com.springboot.springboot2.controller;

import com.springboot.springboot2.pojo.PageResult;
import com.springboot.springboot2.pojo.ResponsePojo;
import com.springboot.springboot2.pojo.User;
import com.springboot.springboot2.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * 用户控制器
 */
@Tag(name = "业主相关 API")
@RequestMapping("/user")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 修改用户状态（例如更换业主）
     */
    @GetMapping(value = "/id/{userid}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(
            summary = "根据用户ID查询用户详细信息",
            description = "<span style='color:red'>若查询失败，返回 null</span>"
    )
    public ResponsePojo<User> queryById(
            @Parameter(description = "用户ID", required = true)
            @PathVariable("userid") Integer id) {

        User u = userService.queryById(id);

        if (u != null) {
            return ResponsePojo.success(u);
        } else {
            return ResponsePojo.fail(u, "该 ID 不存在对应用户");
        }
    }

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

        if (current < 1) current = 1;
        if (size < 1) size = 10;

        PageResult<User> page = userService.pageOfOwner(current, size);
        return ResponsePojo.success(page);
    }
}
