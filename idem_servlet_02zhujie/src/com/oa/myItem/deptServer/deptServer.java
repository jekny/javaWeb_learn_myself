package com.oa.myItem.deptServer;

import com.oa.myItem.jdbcUtil.jdbc_util;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
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
 * ClassName: deptServer
 * Description:
 *
 * @Author jekny
 * @Create 2026/3/21 10:31
 * @Version 1.0
 */
//模板类
@WebServlet(value = {"/dept/list","/dept/detail","/dept/delete","/dept/add","/dept/edit","/dept/xiugai"},urlPatterns = "/dept/addmy")
public class deptServer extends HttpServlet {

    //模板方法
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();

        String servletPath = request.getServletPath();
        if ("/dept/list".equals(servletPath)){
            doList(request,response);
        } else if ("/dept/detail".equals(servletPath)) {
            doDetail(request,response);
        } else if ("/dept/delete".equals(servletPath)) {
            doDeleteMy(request,response);
        } else if ("/dept/add".equals(servletPath)) {
            doAdd(request,response);
        } else if ("/dept/edit".equals(servletPath)) {
            doEdit(request,response);
        } else if ("/dept/xiugai".equals(servletPath)){
            doXiuGai(request,response);
        }
    }

    private void doXiuGai(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
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

    private void doEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
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
                String dname = rs.getString("dname"); //这里的数据获取一定一定一定一定一定一定一定一定一定一定一定一定要放在rs.next()条件判断里面，因为它一开是是指向头节点的，头节点是空
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
    private void doAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
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

    private void doDeleteMy(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
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

    private void doDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
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

    private void doList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
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
}
