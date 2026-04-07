package com.hyw.test.servlet;

import com.hyw.test.entity.stu;
import com.hyw.test.util.jdbcUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * ClassName: servletAll
 * Description:
 *
 * @Author jekny
 * @Create 2026/4/6 21:52
 * @Version 1.0
 */
@WebServlet(value = {"/user/add","/user/edit","/user/detail",""})
public class servletAll extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String servletPath = request.getServletPath();
        if ("/user/add".equals(servletPath)){
            doAdd(request,response);
        }else if ("/user/edit".equals(servletPath)){
            doEdit(request,response);
        }else if ("/user/detail".equals(servletPath)){
            doDetail(request,response);
        }
    }

    private void doDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        int id = Integer.parseInt(request.getParameter("id"));
        String method = request.getParameter("method");
        stu stu = new stu();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            con = jdbcUtil.getCon();
            String sql = "select id,name,age from t_stu1 where id = ?";
            ps = con.prepareStatement(sql);
            ps.setInt(1,id);
            rs = ps.executeQuery();
            if (rs.next()) {
                String name = rs.getString("name");
                int age = rs.getInt("age");
                stu.setId(id);
                stu.setName(name);
                stu.setAge(age);
                request.setAttribute("stu",stu);
                if ("xx".equals(method)){
                    request.getRequestDispatcher("/detail.jsp").forward(request,response);
                }else{
                    request.getRequestDispatcher("/edit.jsp").forward(request,response);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void doEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String age = request.getParameter("age");

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
            jdbcUtil.close(con,ps,rs);
        }

    }

    private void doAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        stu stu = new stu();

        try {
            con = jdbcUtil.getCon();
            String sql = "insert into t_stu1 (id,name,age) values (?,?,?)";
            ps = con.prepareStatement(sql);
            int id = Integer.parseInt(request.getParameter("id"));
            String name = request.getParameter("name");
            int age = Integer.parseInt(request.getParameter("age"));
            ps.setInt(1,id);
            ps.setString(2,name);
            ps.setInt(3,age);
            int count = ps.executeUpdate();
            if (count==1) {
                stu.setId(id);
                stu.setName(name);
                stu.setAge(age);
                response.sendRedirect(request.getContextPath()+"/index.jsp");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            jdbcUtil.close(con,ps,rs);
        }
    }
}
