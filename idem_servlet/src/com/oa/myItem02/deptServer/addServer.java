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
 * ClassName: addServer
 * Description:
 *
 * @Author jekny
 * @Create 2026/3/20 10:18
 * @Version 1.0
 */
public class addServer extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        String contextPath = request.getContextPath();
        PrintWriter out = response.getWriter();
        Connection con =  null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        int no = Integer.parseInt(request.getParameter("no"));
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        try {
            con = jdbc_util.getcon();
            String sql = "insert into dept(deptno,dname,loc) values (?,?,?)";
            ps = con.prepareStatement(sql);
            ps.setInt(1,no);
            ps.setString(2,name);
            ps.setString(3,address);
            int count = ps.executeUpdate();
            if (count==1){
                request.getRequestDispatcher("/dept/list").forward(request,response);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}
