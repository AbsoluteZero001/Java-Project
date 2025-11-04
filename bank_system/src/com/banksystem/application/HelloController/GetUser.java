package com.banksystem.application.HelloController;

import com.alibaba.fastjson.JSONObject;
import com.banksystem.application.dao.UserInfoDao;
import com.banksystem.application.dao.UserInfoDao;
import com.banksystem.application.entity.UserInfo;
import com.banksystem.application.entity.UserInfo;
import com.banksystem.application.utills.RequestUtil;
import com.banksystem.application.utills.ResponseUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


@WebServlet("/getUser")

public class GetUser extends HttpServlet {

    // 创建UserInfoDao对象，用于操作管理员信息数据
    public static UserInfoDao userInfoDao = new UserInfoDao();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        JSONObject param= RequestUtil.getParam(req);
        String mobile = param.getString("mobile");
        String password = param.getString("pwd");
        String nickname = param.getString("nn");
        String name = param.getString("n");
        Long id = param.getLong("id");
        UserInfo userInfo = new UserInfo();
        userInfo.setId(id);
        userInfo.setMobile(mobile);
        userInfo.setNickname(nickname);
        userInfo.setPassword(password);
        userInfo.setName(name);
        userInfoDao.updateUser( userInfo );
        ResponseUtil.success(resp,null );


    }
}


