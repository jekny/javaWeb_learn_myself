package com.oa.myItem.deptServer;

import com.oa.myItem.jdbcUtil.jdbc_util;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * ClassName: welcome_judge
 * Description:
 *
 * @Author jekny
 * @Create 2026/3/24 7:51
 * @Version 1.0
 */
@WebServlet(value = {"/welcome"})
public class welcome_judge extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie[] cookies = request.getCookies();
        String username = null;
        String password = null;
        if (cookies != null){
            for (Cookie cookie :cookies) {
                String name = cookie.getName();
                if ("name".equals(name)){
                    username = cookie.getValue();
                }else if ("password".equals(name)){
                    password = cookie.getValue();
                }
            }
        }

        boolean success = false;
        if (username!=null && password !=null){
            Connection con = null;
            PreparedStatement ps = null;
            ResultSet rs = null;
            try {
                con = jdbc_util.getcon();
                String sql = "select * from my_user where username = ? and password = ?";
                ps = con.prepareStatement(sql);
                ps.setString(1,username);
                ps.setString(2,password);
                rs = ps.executeQuery();
                if (rs.next()){
                    success = true;
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }finally {
                jdbc_util.close(con,ps,rs);
            }
            if (success) {
                HttpSession session = request.getSession();
                session.setAttribute("username",username);
                response.sendRedirect(request.getContextPath()+"/dept/list");
            }else {
                response.sendRedirect(request.getContextPath()+"/index.jsp");
            }
        }else {
            response.sendRedirect(request.getContextPath()+"/index.jsp");
        }









    }
}
