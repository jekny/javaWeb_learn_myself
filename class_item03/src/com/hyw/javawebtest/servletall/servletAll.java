package com.hyw.javawebtest.servletall;

import com.hyw.javawebtest.entity.stu;
import com.hyw.javawebtest.util.jdbc;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * ClassName: servletAll
 * Description:
 *
 * @Author jekny
 * @Create 2026/4/7 20:51
 * @Version 1.0
 */
@WebServlet(value = {"/add","/edit","/detail","/delete","/deleteSome"})
public class servletAll extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("UTF-8");
        String servletPath = request.getServletPath();
        if ("/add".equals(servletPath)){
            doAdd(request,response);
        }else if ("/edit".equals(servletPath)){
            doEdit(request,response);
        }else if ("/detail".equals(servletPath)){
            doDetail(request,response);
        }else if ("/delete".equals(servletPath)){
            doDeleteMy(request,response);
        }else if ("/deleteSome".equals(servletPath)){
            doDeleteSome(request,response);
        }
    }

    private void doEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("UTF-8");
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String age = request.getParameter("age");

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        con = jdbc.getCon();
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
            jdbc.close(con,ps,null);
        }

    }

    private void doDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("UTF-8");
        String id = request.getParameter("id");
        String sendMethod = request.getParameter("sendMethod");
        stu stu = new stu();

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        con = jdbc.getCon();
        String sql = "select id,name,age from t_stu1 where id = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1,id);
            rs = ps.executeQuery();
            if (rs.next()) {
                stu.setId(rs.getInt("id"));
                stu.setName(rs.getString("name"));
                stu.setAge(rs.getInt("age"));
                request.setAttribute("stu",stu);
                if ("xx".equals(sendMethod)){
                    request.getRequestDispatcher("/detail.jsp").forward(request,response);
                }else{
                    request.getRequestDispatcher("/edit.jsp").forward(request,response);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            jdbc.close(con,ps,rs);
        }
    }

    private void doDeleteSome(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("UTF-8");
        String[] ids = request.getParameterValues("deletesome");//注意点，这个方法可以根据相同的name获取多个value

        Connection con = null;
        PreparedStatement ps = null;
        int count = 0;
        con = jdbc.getCon();
        try {
            for (String id :ids) {
                String sql = "delete from t_stu1 where id = ?";
                ps = con.prepareStatement(sql);
                ps.setString(1,id);
                count += ps.executeUpdate();
            }
            if (count == ids.length){
                response.sendRedirect(request.getContextPath()+"/index.jsp");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            jdbc.close(con,ps,null);
        }

    }

    private void doDeleteMy(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("UTF-8");
        String id = request.getParameter("id");

        Connection con = null;
        PreparedStatement ps = null;

        con = jdbc.getCon();
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
            jdbc.close(con,ps,null);
        }
    }

    private void doAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("UTF-8");
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String age = request.getParameter("age");

        Connection con = null;
        PreparedStatement ps = null;

        con = jdbc.getCon();
        String sql = "insert into t_stu1 (id,name,age) values (?,?,?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1,id);
            ps.setString(2,name);
            ps.setString(3,age);
            int count = ps.executeUpdate();
            if (count == 1){
                response.sendRedirect(request.getContextPath()+"/index.jsp");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            jdbc.close(con,ps,null);
        }
    }
}
