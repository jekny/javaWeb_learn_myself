<%@ page import="com.hyw.test.util.jdbcUtil" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="com.hyw.test.entity.stu" %><%--
  Created by IntelliJ IDEA.
  User: 26568
  Date: 2026/4/6
  Time: 21:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>index</title>
</head>
<body>
<%
    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    stu stu1 = new stu();

    con = jdbcUtil.getCon();
    String sql = "select * from t_stu1";
    ps = con.prepareStatement(sql);
    rs = ps.executeQuery();
    %>
<hr>

    <table border="1px brake solid" width="600px" align="center" >
        <tr style="text-align: center">
            <th>id</th>
            <th>name</th>
            <th>age</th>
            <th>操作</th><hr>
        </tr>
            <%while (rs.next()) {
                    int id = rs.getInt("id");
                    String name = rs.getString("name");
                    int age = rs.getInt("age");
                    stu1.setId(id);
                    stu1.setName(name);
                    stu1.setAge(age);
            %>
        <tr style="text-align: center">
            <td><%=stu1.getId()%></td>
            <td><%=stu1.getName()%></td>
            <td><%=stu1.getAge()%></td>
            <td>
                <a href="#?id=<%=stu1.getId()%>">删除</a>
                <a href="<%=request.getContextPath()%>/user/detail?method=xx&id=<%=stu1.getId()%>">查询详细</a>
                <a href="<%=request.getContextPath()%>/user/detail?method=xg&id=<%=stu1.getId()%>">修改</a>
            </td>

            <%}
                jdbcUtil.close(con,ps,rs);
            %>
        </tr>
    </table><hr>
    <a href="<%=request.getContextPath()%>/add.jsp">添加</a>
</body>
</html>
