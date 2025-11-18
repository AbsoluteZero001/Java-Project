package com.banksystem.application.HelloController;

import com.alibaba.fastjson.JSONArray;
import com.banksystem.application.dao.AdminInfoDao;
import com.banksystem.application.utills.ResponseUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/admin/list")
public class GetAdmin extends HttpServlet {
    private  AdminInfoDao adminInfoDao = new AdminInfoDao();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        JSONArray adminList = adminInfoDao.queryAll();
        ResponseUtil.success(resp, adminList);
    }
}
