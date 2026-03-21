package com.myservlet.myserver;

import com.myservlet.apendaServlet;
import jakarta.servlet.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

/**
 * ClassName: vipServer
 * Description:
 *
 * @Author jekny
 * @Create 2026/3/14 16:46
 * @Version 1.0
 */
public class vipServer extends apendaServlet {
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("欢迎使用vip方法");

        servletResponse.setContentType("text/html;charset=utf-8");
        PrintWriter out = servletResponse.getWriter();

        //ServletConfig servletConfig = this.getServletConfig();

        ServletContext servletContext = this.getServletConfig().getServletContext();

        Enumeration<String> initParameterNames = servletContext.getInitParameterNames();

        while(initParameterNames.hasMoreElements()){
            String name = initParameterNames.nextElement();
            String value = servletContext.getInitParameter(name);
            out.print("<br>" + name + " = "+ value + "<br>");
        }

    }
}
