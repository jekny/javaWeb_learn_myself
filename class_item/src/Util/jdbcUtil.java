package Util;

import java.sql.*;
import java.util.ResourceBundle;

public class jdbcUtil {
    private static Connection con = null;
    private static PreparedStatement ps = null;
    private static  ResultSet rs = null;
    static ResourceBundle bundle = ResourceBundle.getBundle("source.jdbc");
    static String driver = bundle.getString("driver");
    static String url = bundle.getString("url");
    static String user = bundle.getString("user");
    static String password = bundle.getString("password");
    static {
        try {
            Class.forName(driver);
            System.out.println("数据库驱动加载成功");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public static Connection getCon(){
        try {
             con = DriverManager.getConnection(url, user, password);
             System.out.println("获取数据库连接成功");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return con;
    }

    public static void getClose(Connection con,PreparedStatement ps,ResultSet rs){
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
