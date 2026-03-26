package WL_system;

import Util.jdbcUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import javaBeanObject.stuffBean;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * ClassName: stuffServer
 * Description:
 *
 * @Author jekny
 * @Create 2026/3/25 19:15
 * @Version 1.0
 */
@WebServlet(value = {"/stuff/list","/stuff/add","/stuff/delete","/stuff/deleteabout","/stuff/editselect","/stuff/editreal","/stuff/detail"})
public class stuffServer extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        String servletPath = request.getServletPath();
        if("/stuff/list".equals(servletPath)){
            doList(request,response);
        }else if ("/stuff/add".equals(servletPath)){
            doAdd(request,response);
        } else if ("/stuff/delete".equals(servletPath)) {
            doDelete_one(request,response);
        }else if ("/stuff/deleteabout".equals(servletPath)){
            doDeleteAbout(request,response);
        }else if ("/stuff/editselect".equals(servletPath)){
            doEditSelect(request,response);
        }else if ("/stuff/editreal".equals(servletPath)){
            doEditReal(request,response);
        }else if ("/stuff/detail".equals(servletPath)){
            doDetail(request,response);
        }
    }

    private void doDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = jdbcUtil.getCon();
            String sql = "select Wno,Wname,W";
            ps = con.prepareStatement(sql);
        }
    }

    private void doEditReal(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String no = request.getParameter("no");
        String wname = request.getParameter("Wname");
        String wsp = request.getParameter("Wsp");
        int wnumb = Integer.parseInt(request.getParameter("Wnumb"));
        String wposition = request.getParameter("Wposition");

        try {
            con = jdbcUtil.getCon();
            String sql = "update wlsystem set Wname= ?,Wsp= ?,Wnumb= ?,Wposition= ? where Wno = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1,wname);
            ps.setString(2,wsp);
            ps.setInt(3,wnumb);
            ps.setString(4,wposition);
            ps.setString(5,no);
            int count = ps.executeUpdate();
            if (count ==1 ){
                response.sendRedirect(request.getContextPath()+"/stuff/list");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            jdbcUtil.getClose(con,ps,rs);
        }

    }

    private void doEditSelect(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String wno = request.getParameter("no");
        stuffBean obj = new stuffBean();
        try {
            con = jdbcUtil.getCon();
            String sql = "select Wno,Wname,Wsp,Wnumb,Wposition from wlsystem where Wno = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1,wno);
            rs = ps.executeQuery();
            if (rs.next()){
                int wno1 = rs.getInt("Wno");
                String wname = rs.getString("Wname");
                String wsp = rs.getString("Wsp");
                int wnumb = rs.getInt("Wnumb");
                String wposition = rs.getString("Wposition");
                obj.setWno(wno1);
                obj.setWname(wname);
                obj.setWsp(wsp);
                obj.setWnumb(wnumb);
                obj.setWposition(wposition);
            }
            request.setAttribute("obj1",obj);
            request.getRequestDispatcher("/edit.jsp").forward(request,response);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void doDeleteAbout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String[] deleteAbouts = request.getParameterValues("deleteAbout");//这里获取复选框的所有value，遍历删除，可以删除多个
        int length = deleteAbouts.length;
        int count = 0;
        try {
            for (String str : deleteAbouts) {
                con = jdbcUtil.getCon();
                String sql = "delete from wlsystem where Wno = ?";
                ps = con.prepareStatement(sql);
                ps.setString(1, str);
                count += ps.executeUpdate();
                if (count == length) {
                    response.sendRedirect(request.getContextPath()+"/stuff/list");
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            jdbcUtil.getClose(con,ps,rs);
        }
    }

    private void doDelete_one(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int wno = Integer.parseInt(request.getParameter("no"));
        try {
            con = jdbcUtil.getCon();
            String sql = "delete from wlsystem where Wno = ?";
            ps = con.prepareStatement(sql);
            ps.setInt(1,wno);
            int count = ps.executeUpdate();
            if (count==1){
                response.sendRedirect(request.getContextPath()+"/stuff/list");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            jdbcUtil.getClose(con,ps,rs);
        }
    }

    private void doAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int wno = Integer.parseInt(request.getParameter("Wno"));
        String wname = request.getParameter("Wname");
        String wsp = request.getParameter("Wsp");
        int wnumb = Integer.parseInt(request.getParameter("Wnumb"));
        String wposition = request.getParameter("Wposition");

        try {
            con = jdbcUtil.getCon();
            String sql = "insert into wlsystem (Wno,Wname,Wsp,Wnumb,Wposition) values (?,?,?,?,?)";
            ps = con.prepareStatement(sql);
            ps.setInt(1,wno);
            ps.setString(2,wname);
            ps.setString(3,wsp);
            ps.setInt(4,wnumb);
            ps.setString(5,wposition);
            int count = ps.executeUpdate();
            if(count==1){
                response.sendRedirect(request.getContextPath()+"/stuff/list");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            jdbcUtil.getClose(con,ps,rs);
        }
    }

    private void doList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<stuffBean> list = new ArrayList<>();

        try {
            con = jdbcUtil.getCon();
            String sql = "select Wno,Wname,Wsp,Wnumb,Wposition from wlsystem";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                stuffBean stuff1 = new stuffBean();
                int wno = Integer.parseInt(rs.getString("Wno"));
                String wname = rs.getString("Wname");
                String wsp = rs.getString("Wsp");
                int wnumb = Integer.parseInt(rs.getString("Wnumb"));
                String wposition = rs.getString("Wposition");
                stuff1.setWno(wno);
                stuff1.setWname(wname);
                stuff1.setWsp(wsp);
                stuff1.setWnumb(wnumb);
                stuff1.setWposition(wposition);
                list.add(stuff1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            jdbcUtil.getClose(con,ps,rs);
        }
        request.setAttribute("stuff",list);
        request.getRequestDispatcher("/index.jsp").forward(request,response);
    }
}
