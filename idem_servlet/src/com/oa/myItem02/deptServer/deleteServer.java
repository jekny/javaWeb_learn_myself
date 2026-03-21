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
 * ClassName: deleteServer
 * Description:
 *
 * @Author jekny
 * @Create 2026/3/20 9:50
 * @Version 1.0
 */
public class deleteServer extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("GBK");
        PrintWriter out = response.getWriter();
        String nameno = request.getParameter("nameno");
        Connection con =  null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            con = jdbc_util.getcon();
            String sql = "delete from dept where deptno = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1,nameno);
            int count = ps.executeUpdate();
            if (count==1){
                request.getRequestDispatcher("/dept/list").forward(request,response);
            }else {
                request.getRequestDispatcher("/delete.html").forward(request,response);
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}
