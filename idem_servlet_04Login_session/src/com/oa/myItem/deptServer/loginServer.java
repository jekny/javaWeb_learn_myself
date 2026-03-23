package com.oa.myItem.deptServer;

import com.oa.myItem.jdbcUtil.jdbc_util;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * ClassName: loginServer
 * Description:
 *
 * @Author jekny
 * @Create 2026/3/22 18:15
 * @Version 1.0
 */
@WebServlet(value = {"/user/login","/user/exit"})
public class loginServer extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        String servletPath = request.getServletPath();

        if ("/user/login".equals(servletPath)){
            doLogin(request,response);
        }else if ("/user/exit".equals(servletPath)){
            doExit(request,response);
        }
    }

    private void doExit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session!=null){
            session.invalidate();//手动销毁session对象，在list页面写一个链接连接到这里，如果有session就进入到这个循环中进行销毁
            response.sendRedirect(request.getContextPath()+"/index.jsp");
        }
    }


    private void doLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        boolean status = false;
        try {
            con = jdbc_util.getcon();
            String sql = "select * from my_user where username = ? and password = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1,username);
            ps.setString(2,password);
            rs = ps.executeQuery();
            if (rs.next()){
                status = true;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            jdbc_util.close(con,ps,rs);
        }
        if (status){
            HttpSession session = request.getSession();
            session.setAttribute("username",username);//登录成功将用户名存进去，注意这里要用session来setAttribute，因为我们想要将该信息存到HttpSession的会话域当中，不能用request 请求域
            response.sendRedirect(request.getContextPath()+"/dept/list");
        }else{
            response.sendRedirect(request.getContextPath()+"/error.jsp");
        }

    }
}
