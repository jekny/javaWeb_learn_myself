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
import java.sql.SQLException;

/**
 * ClassName: DeleteServlet
 * Description:
 *
 * @Author jekny
 * @Create 2026/4/10 9:15
 * @Version 1.0
 */
@WebServlet(value = {"/delete"})
public class DeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("UTF-8");
        String id = request.getParameter("id");
        Connection con = null;
        PreparedStatement ps = null;
        con = jdbcUtil.getCon();
        String sql = "delete from t_stu1 where id = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1,id);
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
