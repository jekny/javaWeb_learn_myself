package com.hyw.javawebtest.servletall;

import com.hyw.javawebtest.util.jdbcUtil;
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
 * ClassName: EditServlet
 * Description:
 *
 * @Author jekny
 * @Create 2026/4/10 9:34
 * @Version 1.0
 */
@WebServlet(value = {"/edit"})
public class EditServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("UTF-8");
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String age = request.getParameter("age");
        Connection con = null;
        PreparedStatement ps = null;
        con = jdbcUtil.getCon();
        String sql = "update t_stu1 set name=?,age=? where id = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1,name);
            ps.setString(2,age);
            ps.setString(3,id);
            int count = ps.executeUpdate();
            if (count == 1) {
                response.sendRedirect(request.getContextPath()+"/index.jsp");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            jdbcUtil.closeCon(con,ps,null);
        }

    }
}
