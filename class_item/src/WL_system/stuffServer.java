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
@WebServlet(value = {"/stuff/list","/stuff/add"})
public class stuffServer extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        String servletPath = request.getServletPath();
        if("/stuff/list".equals(servletPath)){
            doList(request,response);
        }
    }

    private void doList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<stuffBean> list = new ArrayList<>();
        stuffBean stuff1 = new stuffBean();

        try {
            con = jdbcUtil.getCon();
            String sql = "select Wno,Wname,Wsp,Wnumb,Wposition from wlsystem";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
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
