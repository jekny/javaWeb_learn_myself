package com.hyw.javawebtest.util;

import javax.xml.transform.Result;
import java.sql.*;

/**
 * ClassName: jdbcUtil
 * Description:
 *
 * @Author jekny
 * @Create 2026/4/10 8:52
 * @Version 1.0
 */
public class jdbcUtil {
    private static String driver = "com.mysql.cj.jdbc.Driver";
    private static String url = "jdbc:mysql://localhost:3306/javaweb_class";
    private static String user = "root";
    private static String password = "1234";
    private static Connection con = null;
    private static PreparedStatement ps = null;
    private static ResultSet rs = null;
    static {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static Connection getCon(){
        try {
            con = DriverManager.getConnection(url,user,password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return con;
    }

    public static void closeCon(Connection con,PreparedStatement ps,ResultSet rs){
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        if (con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
