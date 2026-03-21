package com.test.test02;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * ClassName: charset_about
 * Description:
 *
 * @Author jekny
 * @Create 2026/3/18 21:30
 * @Version 1.0
 */
public class charset_about extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        String name = request.getParameter("name");
        System.out.println(name);
        PrintWriter out = response.getWriter();
        System.out.println("Response CharacterEncoding: " + response.getCharacterEncoding());//Response CharacterEncoding: UTF-8
        out.print(name);

    }
}
