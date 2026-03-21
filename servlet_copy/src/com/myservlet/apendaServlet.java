package com.myservlet;

import jakarta.servlet.*;

import java.io.IOException;

/**
 * ClassName: apendaServlet
 * Description:
 *
 * @Author jekny
 * @Create 2026/3/14 16:42
 * @Version 1.0
 */
public abstract class apendaServlet implements Servlet {
    ServletConfig servletConfig = null;

    @Override
    public final void init(ServletConfig servletConfig) throws ServletException {
        this.servletConfig = servletConfig;
        init();
    }

    public void init()  {

    }

    @Override
    public ServletConfig getServletConfig() {
        return servletConfig;
    }

    @Override
    public abstract void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException;

    @Override
    public String getServletInfo() {
        return "";
    }

    @Override
    public void destroy() {

    }
}
