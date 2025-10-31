package com.banksystem.application.HelloController;

import com.alibaba.fastjson.JSONObject;
import com.banksystem.application.dao.AdminInfoDao;
import com.banksystem.application.entity.AdminInfo;
import com.banksystem.application.utills.RequestUtil;
import com.banksystem.application.utills.ResponseUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


@WebServlet("/updateAdmin")
public class UpdateAdmin extends HttpServlet {

        public static AdminInfoDao adminInfoDao = new AdminInfoDao();
        @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            JSONObject param= RequestUtil.getParam(req);
            String mobile = param.getString("mobile");
            String password = param.getString("pwd");
            String nickname = param.getString("nn");
            String name = param.getString("n");
            Long id = param.getLong("id");

            AdminInfo adminInfo = new AdminInfo();
            adminInfo.setId(id);
            adminInfo.setMobile(mobile);
            adminInfo.setNickname(nickname);
            adminInfo.setPassword(password);
            adminInfo.setName(name);
            adminInfoDao.updateAdmin( adminInfo );
            ResponseUtil.success(resp,null );


        }
    }


