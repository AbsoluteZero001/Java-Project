package com.springboot.springboot2.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.util.DigestUtils;

import java.nio.charset.StandardCharsets;
import java.util.List;

@Data
@Schema(description = "用户信息，包含管理员、物业人员和住户")
public class User {

    @Schema(description = "用户账号（自动生成）", example = "zhangsan1698734567890")
    private String account;

    @Schema(description = "用户姓名", example = "张三")
    private String username;

    @Schema(description = "用户密码（默认123456，自动MD5加密）", example = "123456")
    private String password;

    @Schema(description = "用户类型：1-管理员，2-物业，3-业主", allowableValues = {"1","2","3"}, example = "3")
    private Integer userType;

    @Schema(description = "用户ID（主键）")
    private Integer userId;

    @Schema(description = "用户性别：0-未知，1-男，2-女", allowableValues = {"0","1","2"}, example = "1")
    private Short gender;

    @Schema(description = "用户年龄", example = "25")
    private Short age;

    @Schema(description = "用户状态：1-正常，2-禁用，3-未激活", allowableValues = {"1","2","3"}, example = "3")
    private Integer userStatus;

    @Schema(description = "用户所属房屋ID（下拉选择有效房间）", example = "11")
    private Integer userRoomId;

    @Schema(description = "身份证号", example = "510101200001010001")
    private String idcard;

    @Schema(description = "用户房间信息, 可能一个人有多套房")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Room> rooms;

    // ===== MyBatis 单个房间映射 =====
    public void setRoom(Room room) {
        if (room != null) {
            this.rooms = List.of(room);
        }
    }

    // ===== 自定义 setPassword（MD5加密）=====
    public void setPassword(String password) {
        if (password != null && password.length() != 32) {
            this.password = DigestUtils.md5DigestAsHex(password.getBytes(StandardCharsets.UTF_8));
        } else {
            this.password = password;
        }
    }
}

