package com.banksystem.application.HelloController;

import com.banksystem.application.utills.ConvertUtils;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Objects;

public class GetCookie extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
        Cookie[] cookies = req.getCookies();
        for (Cookie cookie : cookies) {
            System.out.println(cookie.getName() + " " + cookie.getValue());
        }
        String token = req.getHeader("token");
        if (Objects.isNull(ConvertUtils.ADMIN_LOGIN_MAP.get(token))) {
            resp.sendRedirect("/login");
            return;
        }

    }
}
