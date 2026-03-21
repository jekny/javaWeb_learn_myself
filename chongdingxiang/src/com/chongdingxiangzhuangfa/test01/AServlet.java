package com.chongdingxiangzhuangfa.test01;

import com.chongdingxiangzhuangfa.bean.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * ClassName: AServlet
 * Description:
 *
 * @Author jekny
 * @Create 2026/3/21 7:27
 * @Version 1.0
 */
public class AServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        String contextPath = request.getContextPath();

        User user = new User();
        user.setName("张三");
        user.setAge(18);

        request.setAttribute("user1",user);

        //request.getRequestDispatcher("/b").forward(request,response);

        //重定向，这里是浏览器再发送一次请求到服务器，然后服务器再响应一次改路径到浏览器上
        response.sendRedirect(contextPath+"/b");


    }
}
