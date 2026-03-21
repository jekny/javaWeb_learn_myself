package com.oa.myItem02.deptServer;

import com.oa.myItem02.jdbcUtil.jdbc_util;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * ClassName: xiugaiServer
 * Description:
 *
 * @Author jekny
 * @Create 2026/3/20 21:45
 * @Version 1.0
 */
public class xiugaiServer extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        doGet(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        String contextPath = request.getContextPath();

        String no = request.getParameter("no");
        String name = request.getParameter("name");
        String address = request.getParameter("address");

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;


        try {
            con = jdbc_util.getcon();
            String sql = "update dept set dname = ?,loc = ? where deptno = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1,name);
            ps.setString(2,address);
            ps.setString(3,no);
            int count = ps.executeUpdate();
            if (count == 1){
                request.getRequestDispatcher("/dept/list").forward(request,response);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            jdbc_util.close(con,ps,rs);
        }

    }
}
