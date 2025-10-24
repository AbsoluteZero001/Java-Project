package com.banksystem.application.Filter;


import com.banksystem.application.utills.ConvertUtils;
import com.banksystem.application.utills.ErrorCode;
import com.banksystem.application.utills.ResponseUtil;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Objects;



/**
 * 登录验证过滤器
 * 用于验证用户是否已登录，拦截未登录用户的请求
 */
@WebFilter("/*")  // 过滤所有URL路径
public class LoginCore implements Filter {
    /**
     * 执行过滤操作的核心方法
     * @param servletRequest 请求对象
     * @param servletResponse 响应对象
     * @param filterChain 过滤器链
     * @throws IOException IO异常
     * @throws ServletException Servlet异常
     */
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // 将请求和响应对象转换为HttpServletRequest和HttpServletResponse
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;

        // 获取请求方法
        String method = req.getMethod();
        System.out.println("method:"+method);
        // 处理OPTIONS预检请求，直接放行
        if ("OPTIONS".equals(method.toLowerCase())) {
            filterChain.doFilter(req, resp);
            return;
        }

        // 获取请求URI
        String url = req.getRequestURI();
        // 如果是登录请求，直接放行
        if (("/login".equals(url))) {
            filterChain.doFilter(req, resp);
            return;
        }
        // 从请求头中获取token
        String token = req.getHeader("token");
        // 检查token是否存在或为空
        if (token == null || "".equals(token)) {
            ResponseUtil.fail(resp, ErrorCode.NOT_LOGIN);
            return;
        }
        // 检查token是否在管理员登录映射中存在
        if(Objects.isNull(ConvertUtils.ADMIN_LOGIN_MAP.get(token))) {
            ResponseUtil.fail(resp, ErrorCode.NOT_LOGIN);
            return;
        }
        // 验证通过，放行请求
        filterChain.doFilter(req, resp);
    }
}
