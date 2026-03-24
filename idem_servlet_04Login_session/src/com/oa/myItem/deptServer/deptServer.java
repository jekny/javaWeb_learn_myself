package com.oa.myItem.deptServer;

import com.oa.myItem.bean.myJavaBean;
import com.oa.myItem.jdbcUtil.jdbc_util;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * ClassName: deptServer
 * Description:
 *
 * @Author jekny
 * @Create 2026/3/22 8:11
 * @Version 1.0
 */
@WebServlet(value = {"/dept/list","/dept/add","/dept/delete","/dept/detail","/dept/xiugai"})
public class deptServer extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("UTF-8");
        String servletPath = request.getServletPath();
        HttpSession session = request.getSession(false);
        if (session!=null && session.getAttribute("username")!=null){
            if ("/dept/list".equals(servletPath)){
                doList(request,response);
            }else if ("/dept/add".equals(servletPath)){
                doAdd(request,response);
            }else if ("/dept/delete".equals(servletPath)){
                doDelete_my(request,response);
            }else if ("/dept/detail".equals(servletPath)){
                doDetail(request,response);
            }else if ("/dept/xiugai".equals(servletPath)){
                doXiuGai(request,response);
            }
        }else{
            response.sendRedirect(request.getContextPath()+"/index.jsp");
        }

    }

    private void doXiuGai(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        response.setContentType("text/html;chatset=utf-8");
        request.setCharacterEncoding("UTF-8");

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String contextPath = request.getContextPath();

        int no = Integer.parseInt(request.getParameter("no"));
        String name = request.getParameter("name");
        String address = request.getParameter("address");

        try {
            con = jdbc_util.getcon();
            String sql = "update dept set dname = ?,loc = ? where deptno = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1,name);
            ps.setString(2,address);
            ps.setInt(3,no);
            int count = ps.executeUpdate();
            if (count == 1) {
                response.sendRedirect(contextPath+"/dept/list");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            jdbc_util.close(con,ps,rs);
        }

    }

    private void doDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("UTF-8");
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        myJavaBean myJavaBean = new myJavaBean();
        int no = Integer.parseInt(request.getParameter("no"));

        try {
            con = jdbc_util.getcon();
            String sql = "select deptno,dname,loc from dept where deptno = ?";
            ps = con.prepareStatement(sql);
            ps.setInt(1,no);

            rs = ps.executeQuery();
            if (rs.next()) {
                String dname = rs.getString("dname");
                String loc = rs.getString("loc");

                myJavaBean.setDeptno(no);
                myJavaBean.setDname(dname);
                myJavaBean.setLoc(loc);

            }

            request.setAttribute("num", myJavaBean);
            request.getRequestDispatcher("/detail.jsp").forward(request,response);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            jdbc_util.close(con,ps,rs);
        }
    }

    private void doDelete_my(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("UTF-8");
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        int value = Integer.parseInt(request.getParameter("no")); //获取穿上来的deptno部门编号
        PrintWriter out = response.getWriter();

        try {
            con = jdbc_util.getcon();
            String sql = "delete from dept where deptno = ?";
            ps = con.prepareStatement(sql);
            ps.setInt(1,value);

            int count = ps.executeUpdate();
            if (count == 1) {
                response.sendRedirect(request.getContextPath()+"/dept/list");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            jdbc_util.close(con,ps,rs);
        }
    }

    private void doAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("UTF-8");

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        int no = Integer.parseInt(request.getParameter("no"));
        String name = request.getParameter("name");
        String address = request.getParameter("address");

        try {
            con = jdbc_util.getcon();
            String sql = "insert into dept (deptno,dname,loc) values (?,?,?)";
            ps = con.prepareStatement(sql);
            ps.setInt(1,no);
            ps.setString(2,name);
            ps.setString(3,address);

            int count = ps.executeUpdate();

            if (count == 1) {
                response.sendRedirect(request.getContextPath()+"/dept/list");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            jdbc_util.close(con,ps,rs);
        }
    }

    private void doList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("UTF-8");
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<myJavaBean> deptServers = new ArrayList<>();

        try {
            con = jdbc_util.getcon();
            String sql = "select deptno,dname,loc from dept";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                myJavaBean num = new myJavaBean();
                int deptno = rs.getInt("deptno");
                String dname = rs.getString("dname");
                String loc = rs.getString("loc");
                num.setDeptno(deptno);
                num.setDname(dname);
                num.setLoc(loc);
                deptServers.add(num);
            }
            request.setAttribute("nums",deptServers);
            request.getRequestDispatcher("/list.jsp").forward(request,response);
            //System.out.println(deptServers);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            jdbc_util.close(con,ps,rs);
        }
    }
}
