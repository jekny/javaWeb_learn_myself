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
 * ClassName: detailServer
 * Description:
 *
 * @Author jekny
 * @Create 2026/3/20 7:59
 * @Version 1.0
 */
public class detailServer extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("GBK");
        PrintWriter out = response.getWriter();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String name = request.getParameter("nameno");
        String contextPath = request.getContextPath();

        out.print("<!DOCTYPE html>");
        out.print("<html lang='zh-CN'>");
        out.print("<head>");
        out.print("    <meta charset='UTF-8'>");
        out.print("    <meta name='viewport' content='width=device-width, initial-scale=1.0'>");
        out.print("    <title>部门详情</title>");
        out.print("</head>");
        out.print("<body>");
        out.print("    <h2>部门详情</h2>");
        out.print("    <hr>");

        try {
            con = jdbc_util.getcon();
            String sql = "select deptno,dname,loc from dept where deptno = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1,name);
            System.out.println("this detail");
            rs = ps.executeQuery();
            if (rs.next()){
                int deptno = Integer.parseInt(rs.getString("deptno"));
                String dname = rs.getString("dname");
                String loc = rs.getString("loc");
                out.print("    部门编号："+deptno+"<br>");
                out.print("    部门名称："+dname+"<br>");
                out.print("    部门位置："+loc+"<br>");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            jdbc_util.close(con,ps,rs);
        }
        out.print("    <br>");
        out.print("        <hr>");
        out.print("    <a href='"+contextPath+"/dept/list'>返回列表</a>");
        out.print("</body>");
        out.print("</html>");

    }
}
