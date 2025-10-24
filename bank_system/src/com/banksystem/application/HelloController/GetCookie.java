package com.banksystem.application.HelloController;

import com.alibaba.fastjson.JSONArray;
import com.banksystem.application.dao.AdminInfoDao;
import com.banksystem.application.utills.ConvertUtils;
import com.banksystem.application.utills.ErrorCode;
import com.banksystem.application.utills.ResponseUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Objects;

@WebServlet("/admin/list")
public class GetCookie extends HttpServlet {

    private  AdminInfoDao adminInfoDao = new AdminInfoDao();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String token = req.getHeader("token");
        if (Objects.isNull(ConvertUtils.ADMIN_LOGIN_MAP.get(token))) {
//            resp.sendRedirect("/login");
            ResponseUtil.fail(resp,ErrorCode.NOT_LOGIN);
            return;
        }
        JSONArray adminList = adminInfoDao.queryAll();
        ResponseUtil.success(resp, adminList);

    }
}
