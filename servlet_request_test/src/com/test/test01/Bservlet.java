package com.test.test01;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

/**
 * ClassName: Bservlet
 * Description:
 *
 * @Author jekny
 * @Create 2026/3/18 18:21
 * @Version 1.0
 */
public class Bservlet extends HttpServlet {
    //在Bservlet类中取数据
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        System.out.println("Bservlet 中的 request: " + request.hashCode());
        PrintWriter out = response.getWriter();
        Object time1 = request.getAttribute("time");//获取请求域中绑定的数据
        out.print("B中的时间为:"+time1);


    }
}
