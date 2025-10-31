package com.springboot.springboot2.controller;

import com.springboot.springboot2.pojo.PageResult;
import com.springboot.springboot2.pojo.ResponsePojo;
import com.springboot.springboot2.pojo.UnpaidOwner;
import com.springboot.springboot2.pojo.User;
import com.springboot.springboot2.service.RoomService;
import com.springboot.springboot2.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.StandardCharsets;

/**
 * 用户控制器
 */
@Tag(name = "业主相关 API")
@RequestMapping("/user")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    // ✅ 注入 RoomService
    @Autowired
    private RoomService roomService;

    // ------------------------------------------------------------
    // ✅ 新增业主信息接口
    // ------------------------------------------------------------
    //JSON 格式：
//    @PostMapping(value = "/insert", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
//    @Operation(
//            summary = "新增业主信息",
//            description = """
//                    新增一个业主用户：
//                    - 默认为未激活状态；
//                    - 使用默认密码；
//                    - 自动生成账号；
//                    - roomId 通过级联菜单获得。
//                    """,
//            responses = {
//                    @ApiResponse(responseCode = "200", description = "新增成功",
//                            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
//                                    schema = @Schema(implementation = ResponsePojo.class))),
//                    @ApiResponse(responseCode = "400", description = "请求参数错误"),
//                    @ApiResponse(responseCode = "500", description = "服务器异常")
//            }
//    )
//    public ResponsePojo<Integer> insertUser(
//            @RequestBody(
//                    description = "业主信息对象（包含身份证号、年龄、性别、用户名、房间ID等）",
//                    required = true,
//                    content = @Content(schema = @Schema(implementation = User.class))
//            )
//            @org.springframework.web.bind.annotation.RequestBody User user
//    ) {
//        try {
//            int result = userService.insertUser(user);
//            return ResponsePojo.success(result, "新增用户成功");
//        } catch (DuplicateKeyException e) {
//            return ResponsePojo.error("身份证或账号已存在，新增失败");
//        } catch (Exception e) {
//            e.printStackTrace();
//            return ResponsePojo.error("新增用户时出现错误：" + e.getMessage());
//        }
//    }

    // ------------------------------------------------------------
    //JSON 接口改成 表单/选项框式 Swagger 风格的接口
// ------------------------------------------------------------
    @PostMapping(value = "/insert", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(
            summary = "新增业主信息（表单）",
            description = """
                新增一个业主用户：
                - 默认为未激活状态；
                - 使用默认密码；
                - 自动生成账号；
                - roomId 通过级联菜单获得。
                """,
            responses = {
                    @ApiResponse(responseCode = "200", description = "新增成功",
                            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = ResponsePojo.class))),
                    @ApiResponse(responseCode = "400", description = "请求参数错误"),
                    @ApiResponse(responseCode = "500", description = "服务器异常")
            }
    )
    public ResponsePojo<Integer> insertUser(
            @Parameter(description = "用户名", required = true, example = "张三")
            @RequestParam String username,

            @Parameter(description = "身份证号", required = true, example = "510101200001010001")
            @RequestParam String idcard,

            @Parameter(description = "性别 0=未知,1=男,2=女", required = true, example = "1")
            @RequestParam Short gender,

            @Parameter(description = "年龄", required = true, example = "25")
            @RequestParam Short age,

            @Parameter(description = "用户类型 1=管理员,2=员工,3=业主", required = true, example = "3")
            @RequestParam Short userType,

            @Parameter(description = "用户状态 1=正常,2=禁用,3=未激活", required = false, example = "3")
            @RequestParam(required = false) Short userStatus,

            @Parameter(description = "房间ID（room_id）", required = true, example = "11")
            @RequestParam Short userRoomId
    ) {
        try {
            // ----- 构造 User 对象 -----
            User user = new User();
            user.setUsername(username);
            user.setIdcard(idcard);
            user.setGender(gender);
            user.setAge(age);
            user.setUserType(userType);
            user.setUserRoomId(null); //不指定房间

            // ----- 默认用户状态 -----
            if (userStatus == null) {
                user.setUserStatus((short) 3); // 未激活
            } else {
                user.setUserStatus(userStatus);
            }

            // ----- 自动生成账号 -----
            String rawAccount = username + System.currentTimeMillis();
            user.setAccount(DigestUtils.md5DigestAsHex(rawAccount.getBytes(StandardCharsets.UTF_8)));

            // ----- 默认密码 -----
            user.setPassword("123456"); // setPassword 内部自动 MD5

            // ----- 调用 Service 保存 -----
            int result = userService.insertUser(user);
            return ResponsePojo.success(result, "新增用户成功");

        } catch (Exception e) {
            e.printStackTrace();
            return ResponsePojo.error("新增用户时出现错误：" + e.getMessage());
        }
    }
    // ------------------------------------------------------------
    // ✅ 根据ID查询用户信息
    // ------------------------------------------------------------
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

    // ------------------------------------------------------------
    // ✅ 分页查询业主信息
    // ------------------------------------------------------------
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

    // ------------------------------------------------------------
    // ✅ 欠费名单查询
    // ------------------------------------------------------------
    @GetMapping("/unpaidOwnerList")
    @Operation(summary = "单项费用的欠费名单查询")
    public ResponsePojo<PageResult<UnpaidOwner>> unpaidOwnerList(
            @RequestParam(defaultValue = "1") Integer current,
            @RequestParam(defaultValue = "10") Integer size,
            @RequestParam @Parameter(description = "费用类型ID") Integer typeId) {

        PageResult<UnpaidOwner> pageResult = userService.pageOfUnpaidOwnerList(current, size, typeId);
        return ResponsePojo.success(pageResult);
    }
}
