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
 * ClassName: DeleteSomeServlet
 * Description:
 *
 * @Author jekny
 * @Create 2026/4/10 9:45
 * @Version 1.0
 */
@WebServlet(value = {"/deletesome"})
public class DeleteSomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("UTF-8");
        String[] ids = request.getParameterValues("some");
        int count = 0;
        Connection con = null;
        PreparedStatement ps = null;
        con = jdbcUtil.getCon();
        for (String id :ids) {
            String sql = "delete from t_stu1 where id = ?";
            try {
                ps = con.prepareStatement(sql);
                ps.setString(1,id);
                count += ps.executeUpdate();
                if (count == ids.length) {
                    response.sendRedirect(request.getContextPath()+"/index.jsp");
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        jdbcUtil.closeCon(con,ps,null);
    }
}
