package com.chongdingxiangzhuangfa.test01;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * ClassName: BServlet
 * Description:
 *
 * @Author jekny
 * @Create 2026/3/21 7:27
 * @Version 1.0
 */
public class BServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        Object user1 = request.getAttribute("user1");

        out.print("拿到请求域当中的对象为："+user1);

    }
}
