package com.banksystem.application.HelloController;

import com.alibaba.fastjson.JSONObject;
import com.banksystem.application.dao.UserInfoDao;
import com.banksystem.application.entity.AdminInfo;
import com.banksystem.application.entity.UserInfo;
import com.banksystem.application.utills.ErrorCode;
import com.banksystem.application.utills.RequestUtil;
import com.banksystem.application.utills.ResponseUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Objects;

/**
 * 用户添加接口
 * 仅管理员登录后可使用
 * URL: /user/add
 */
@WebServlet(urlPatterns = "user/add")
public class UserAddServlet extends HttpServlet {

    // 用户数据访问对象（DAO）
    public static final UserInfoDao userInfoDao = new UserInfoDao();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // 1. 检查管理员是否登录
        AdminInfo adminInfo = RequestUtil.checkAdminLogin(request);
        if (Objects.isNull(adminInfo)) {
            ResponseUtil.fail(response, ErrorCode.ADMIN_NOT_LOGIN);
            return;
        }

        // 2. 获取请求参数（JSON 格式）
        JSONObject param = RequestUtil.getParam(request);
        String cardType = param.getString("cardType");
        String cardNo = param.getString("cardNo");
        String password = param.getString("password");
        String nickname = param.getString("nickname");
        String name = param.getString("name");
        String address = param.getString("address");
        String idNum = param.getString("idNum"); // 身份证号
        String mobile = param.getString("mobile");
        String state = param.getString("state"); // 状态: 0禁用 1启用 2冻结

        // 3. 校验：手机号是否已存在
        UserInfo userInfo = userInfoDao.selectByMobile(mobile);
        if (Objects.nonNull(userInfo)) {
            ResponseUtil.fail(response, ErrorCode.USER_MOBILE_EXIST);
            return;
        }

        // 4. 校验：卡号或身份证号是否已存在
        userInfo = userInfoDao.selectByCardNoAndIdNum(cardNo, idNum);
        if (Objects.nonNull(userInfo)) {
            ResponseUtil.fail(response, ErrorCode.USER_CARDNO_OR_IDNUM_SAME);
            return;
        }

        // 5. 构造用户对象
        userInfo = new UserInfo();
        userInfo.setCardType(cardType);
        userInfo.setCardNo(cardNo);
        userInfo.setPassword(password);
        userInfo.setNickname(nickname);
        userInfo.setName(name);
        userInfo.setAddress(address);
        userInfo.setIdNum(idNum);
        userInfo.setMobile(mobile);
        userInfo.setState(state);

        // 6. 写入数据库
        Long addId = userInfoDao.insert(userInfo);

        // 7. 返回成功响应
        RequestUtil.success(response, addId);
    }
}
