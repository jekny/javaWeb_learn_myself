package com.myservlet.myserver;

import com.myservlet.apendaServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

import java.io.IOException;

/**
 * ClassName: httpServer
 * Description:
 *
 * @Author jekny
 * @Create 2026/3/14 16:49
 * @Version 1.0
 */
public class httpServer extends apendaServlet {

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("欢迎使用http方法");

    }
}
