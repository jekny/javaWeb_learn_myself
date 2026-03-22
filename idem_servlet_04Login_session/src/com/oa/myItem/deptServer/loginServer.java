package com.oa.myItem.deptServer;

import com.oa.myItem.jdbcUtil.jdbc_util;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

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
@WebServlet(value = {"/user/login"})
public class loginServer extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        String servletPath = request.getServletPath();

        if ("/user/login".equals(servletPath)){
            doLogin(request,response);
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
            response.sendRedirect(request.getContextPath()+"/dept/list");
        }else{
            response.sendRedirect(request.getContextPath()+"/error.jsp");
        }

    }
}
