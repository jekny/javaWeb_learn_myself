package com.test.test01;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

/**
 * ClassName: Aservlet
 * Description:
 *
 * @Author jekny
 * @Create 2026/3/18 18:21
 * @Version 1.0
 */
public class Aservlet extends HttpServlet {
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        response.setContentType("text/html;charset=utf-8");
//        PrintWriter out = response.getWriter();
//        Date date = new Date();
//        out.print("时间："+date);
//    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        System.out.println("Aservlet 中的 request: " + request.hashCode());
        ServletContext servletContext = this.getServletContext();
        String realPath = servletContext.getRealPath("/a");//D:\All_class_code\javaWeb_code\laodu_javaWeb\LaoDu_class_test_All\out\artifacts\servlet_request_test_Web_exploded\a
        System.out.println(realPath);


        Date date = new Date();
//        out.print("时间nama："+date);

        request.setAttribute("time",date);//存数据到请求域当中
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/mypage.jsp"); //获取请求转发器
        requestDispatcher.forward(request,response);//传递
        //request.getRequestDispatcher("/b").forward(request,response);//连接




    }



}


