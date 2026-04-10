package com.hyw.javawebtest.servletall;

import com.hyw.javawebtest.entity.Stu;
import com.hyw.javawebtest.util.jdbcUtil;
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

/**
 * ClassName: DetailServlet
 * Description:
 *
 * @Author jekny
 * @Create 2026/4/10 9:19
 * @Version 1.0
 */
@WebServlet(value = {"/detail"})
public class DetailServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("UTF-8");
        String id = request.getParameter("id");
        String sendMethod = request.getParameter("sendMethod");
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Stu stu = new Stu();
        con = jdbcUtil.getCon();
        String sql = "select id,name,age from t_stu1 where id = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1,id);
            rs = ps.executeQuery();
            if (rs.next()) {
                int id1 = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                stu.setId(id1);
                stu.setName(name);
                stu.setAge(age);
                request.setAttribute("stu",stu);//向请求域中存资源
                if ("selectDetail".equals(sendMethod)){
                    request.getRequestDispatcher("/detail.jsp").forward(request,response);//资源转发
                }else if("selectEdit".equals(sendMethod)){
                    request.getRequestDispatcher("/edit.jsp").forward(request,response);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            jdbcUtil.closeCon(con,ps,rs);
        }
    }
}
