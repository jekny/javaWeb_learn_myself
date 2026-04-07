<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="com.hyw.javawebtest.entity.stu" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.hyw.javawebtest.util.jdbc" %><%--
  Created by IntelliJ IDEA.
  User: 26568
  Date: 2026/4/7
  Time: 20:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="<%=request.getContextPath()%>/deleteSome">
    <table border="1px brake solid" width="800" align="center">
        <tr>
            <th>id</th>
            <th>name</th>
            <th>age</th>
            <th>操作</th>
        </tr>
        <%
            Connection con = null;
            PreparedStatement ps = null;
            ResultSet rs = null;
            stu stu = new stu();
            List<stu> lists = new ArrayList<>();
            con = jdbc.getCon();
            String sql = "select id,name,age from t_stu1";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
        %>

        <tr>
            <td><%=id%></td>
            <td><%=name%></td>
            <td><%=age%></td>
            <td>
                    <input type="checkbox" name="deletesome" value="<%=id%>">
                    <a href="<%=request.getContextPath()%>/delete?id=<%=id%>">删除</a>
                    <a href="<%=request.getContextPath()%>/detail?id=<%=id%>&sendMethod=xx">查询详细</a>
                    <a href="<%=request.getContextPath()%>/detail?id=<%=id%>&sendMethod=xg">修改</a>
            </td>
        </tr>
        <%
            }
        %>
    </table>
    <div style="padding-left: 860px">
        <input type="submit" name="sbt" value="删除所选项"/>
    </div>
</form>
<hr>
<a href="<%=request.getContextPath()%>/add.jsp">添加</a>
</body>
</html>
