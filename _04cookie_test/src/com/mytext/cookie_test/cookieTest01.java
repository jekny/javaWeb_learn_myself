package com.mytext.cookie_test;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * ClassName: cookieTest01
 * Description:
 *
 * @Author jekny
 * @Create 2026/3/23 19:14
 * @Version 1.0
 */
@WebServlet(value = {"/sendCookie"})
public class cookieTest01 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie :
                cookies) {
            System.out.println(cookie);
        }

    }
}
