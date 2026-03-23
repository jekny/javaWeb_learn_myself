package com.mytext.cookie_test;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * ClassName: shixianCookie
 * Description:用来接受cookie的类
 *
 * @Author jekny
 * @Create 2026/3/23 19:17
 * @Version 1.0
 */
@WebServlet(value = {"/cookie/red"})
public class shixianCookie extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie cookie = new Cookie("mycookie","1234567");
        Cookie cookie1 = new Cookie("mycookie1","66778899");

        cookie.setMaxAge(60*60);//设置的期限大于0则cookie会保存在硬盘上，0是销毁，负数相当于没有设置setMaxAge
        cookie.setPath(request.getContextPath());
        cookie1.setPath(request.getContextPath());

        response.addCookie(cookie);//http://localhost:8080/_04cookie_test_Web_exploded/cookie以及它的子路径都能拿到cookie
        response.addCookie(cookie1);

    }
}
