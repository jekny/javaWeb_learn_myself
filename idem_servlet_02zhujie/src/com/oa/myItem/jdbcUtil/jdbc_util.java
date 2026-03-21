package com.oa.myItem.jdbcUtil;


import java.sql.*;
import java.util.ResourceBundle;

/**
 * ClassName: jdbc_util
 * Description:
 *
 * @Author jekny
 * @Create 2026/3/19 8:58
 * @Version 1.0
 */
public class jdbc_util {
    private static ResourceBundle bundle = ResourceBundle.getBundle("resource.jdbcUtil");
    private static String driver = bundle.getString("driver");
    private static String url = bundle.getString("url") ;

    private static String user = bundle.getString("user");
    private static String password = bundle.getString("password");

    //静态代码快在类加载的时候执行//下面注册驱动的时候尽量用配置文件
    static {
        try {
            Class.forName(driver);
            System.out.println("驱动加载成功");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    //获取数据库连接
    public static Connection getcon() throws SQLException {
        Connection con = DriverManager.getConnection(url, user, password);
        System.out.println("数据库连接成功：" + con);
        return con;
    }

    public static void close(Connection con,PreparedStatement ps,ResultSet rs)  {
        try {
            if (rs != null) rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (ps != null) ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (con != null) con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



}
