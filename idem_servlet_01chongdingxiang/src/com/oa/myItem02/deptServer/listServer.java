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
 * ClassName: listServer
 * Description:
 *
 * @Author jekny
 * @Create 2026/3/19 18:31
 * @Version 1.0
 */
public class listServer extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        //Connection con = null;
        //PreparedStatement ps = null;
        //ResultSet rs = null;
        out.print("<!DOCTYPE html>");
        out.print("<html lang='zh-CN'>");
        out.print("<head>");
        out.print("    <meta charset='UTF-8'>");
        out.print("    <meta name='viewport' content='width=device-width, initial-scale=1.0'>");
        out.print("    <title>indexPage</title>");
        out.print("</head>");
        out.print("<body>");
        out.print("   <p style='text-align: center;'>welcome the page system</p>");
        out.print("   <hr>");
        out.print("   <table border='1px solid' align='center' width = '800px'>");
        out.print("       <tr>");
        out.print("           <th style='border: 1px solid;'>部门序号</th>");
        out.print("           <th>部门编号</th>");
        out.print("           <th>部门名称</th>");
        out.print("           <th>操作1</th>");
        out.print("       </tr>");
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String contextPath = request.getContextPath();
        try {
            con = jdbc_util.getcon();
            String sql = "select deptno,dname,loc from dept";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            int i = 0;
            while (rs.next()) {
                int no = Integer.parseInt(rs.getString("deptno"));
                String name = rs.getString("dname");
                String loc = rs.getString("loc");

                out.print("       <tr>");
                out.print("           <td>" + (++i) + "</td>");
                out.print("           <td>" + no + "</td>");
                out.print("           <td>" + name + "</td>");
                out.print("           <td>");
                out.print("               <a href='"+contextPath+"/dept/delete?nameno="+no+"   '>删除</a>");
                out.print("               <a href='"+contextPath+"/dept/edit?nameno="+no+"'>修改</a>");
                out.print("               <a href='"+contextPath+"/dept/detail?nameno="+no+"'>详细</a>");
                out.print("           </td>");
                out.print("       </tr>");
            }
        }catch (SQLException e) {
            e.printStackTrace();  // 输出到控制台
            out.print("<p style='color:red;'>数据库错误：" + e.getMessage() + "</p>");
            throw new RuntimeException(e);
        } catch (Exception e) {  // 捕获其他异常（如类初始化错误）
            e.printStackTrace();
            out.print("<p style='color:red;'>系统错误：" + e.getMessage() + "</p>");
            throw new RuntimeException(e);
        }
        finally {
            jdbc_util.close(con, ps, rs);
        }
        out.print("   </table>");
        out.print("   <hr>");
        out.print("<a href='"+contextPath+"/add.html'>新增部门</a>");
        out.print("</body>");
        out.print("</html>");


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
