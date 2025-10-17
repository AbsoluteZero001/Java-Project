package com.banksystem.application.HelloController;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Objects;

import com.alibaba.fastjson.JSONObject;
import com.banksystem.application.dao.AdminInfoDao;
import com.banksystem.application.entity.AdminInfo;
import com.banksystem.application.utills.ErrorCode;
import com.banksystem.application.utills.ResponseUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class TestController extends HttpServlet {
    private AdminInfoDao AdminInfoDao = new AdminInfoDao();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        BufferedReader reader = req.getReader();
        StringBuffer sb = new StringBuffer();
        String line = null;
        while ((line = reader.readLine()) != null) {
            sb.append(line);
        }
        System.out.println(sb.toString());
        JSONObject jsonObject = JSONObject.parseObject(sb.toString(),JSONObject.class);
        String mobile = jsonObject.getString("mobile");
        String pwd = jsonObject.getString("pwd");
        String LoginType = jsonObject.getString("LoginType");
        JSONObject json = new JSONObject();
        json.put("pwd",pwd);
        json.put("mobile",mobile);
        if ("admin".equals(LoginType)) {
            System.out.println("这是管理员端");
            AdminInfo adminInfo = AdminInfoDao.getAdminByMobile(mobile);
            //1.判断用户是否存在
            if(Objects.isNull(adminInfo)){
                ResponseUtil.fail(resp, ErrorCode.ADMIN_NOT_EXIST);
                return;
            }
            //2.判断密码是否正确
            if(!adminInfo.getPassword().equals(pwd)) {
                ResponseUtil.fail(resp, ErrorCode.PWD_ERR);
                return;
            }
            System.out.println(adminInfo);
            jsonObject = new JSONObject();
            jsonObject.put("adminInfo",adminInfo);
            ResponseUtil.success(resp,jsonObject);
        }
        ResponseUtil.fail(resp, ErrorCode.LOGIN_TYPE_ERROR);
    }
}
