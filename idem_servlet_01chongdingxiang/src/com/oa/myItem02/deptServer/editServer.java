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
 * ClassName: editServer
 * Description:
 *
 * @Author jekny
 * @Create 2026/3/20 18:47
 * @Version 1.0
 */
public class editServer extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        String nameno = request.getParameter("nameno");
        String contextPath = request.getContextPath();

        out.print("<!DOCTYPE html>");
        out.print("<html lang='zh-CN'>");
        out.print("<head>");
        out.print("    <meta charset='UTF-8'>");
        out.print("    <meta name='viewport' content='width=device-width, initial-scale=1.0'>");
        out.print("    <title>Document</title>");
        out.print("</head>");
        out.print("<body>");
        out.print("    <h2>修改页面</h2><hr>");
        out.print("    <form action='"+contextPath+"/dept/xiugai' method='post'>");
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            con = jdbc_util.getcon();
            String sql = "select deptno,dname,loc from dept where deptno = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1,nameno);
            rs = ps.executeQuery();
            if (rs.next()){
                String dname = rs.getString("dname"); //这里的数据获取一定一定一定一定一定一定一定一定一定一定一定一定要放在rs.next()里面，因为它一开是是指向头节点的，头节点是空
                String loc = rs.getString("loc");
                out.print("        部门编号：<input type='text' name='no' readonly value='"+nameno+"'><br>");
                out.print("        修改部门名称：<input type='text' name='name' value='"+dname+"'><br>");
                out.print("        修改部门地址：<input type='text' name='address' value='"+loc+"'><br>");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            jdbc_util.close(con,ps,rs);
        }




        out.print("        <input type='submit' value='提交' name='sbt'>");
        out.print("    </form>");
        out.print("</body>");
        out.print("</html>");
    }

}
