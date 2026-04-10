<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="com.hyw.javawebtest.util.jdbcUtil" %><%--
  Created by IntelliJ IDEA.
  User: 26568
  Date: 2026/4/10
  Time: 8:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1 style="text-align: center">welcome</h1>
<hr>
<form action="<%=request.getContextPath()%>/deletesome" method="get">
  <a href="<%=request.getContextPath()%>/add.jsp" style="padding-left: 200px;font-size: 20px" >添加</a>
  <table border="1px brake solid" align="center" width="800">
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
      con = jdbcUtil.getCon();
      String sql = "select id,name,age from t_stu1";
      ps = con.prepareStatement(sql);
      rs = ps.executeQuery();
      while (rs.next()){
        String id = rs.getString("id");
        String name = rs.getString("name");
        String age = rs.getString("age");
    %>
    <tr style="text-align: center">
      <td><%=id%></td>
      <td><%=name%></td>
      <td><%=age%></td>
      <td>
        <input type="checkbox" name="some" value="<%=id%>">
        <a href="<%=request.getContextPath()%>/delete?id=<%=id%>">删除</a>&nbsp&nbsp
        <a href="<%=request.getContextPath()%>/detail?id=<%=id%>&sendMethod=selectDetail">查询详细</a>&nbsp&nbsp
        <a href="<%=request.getContextPath()%>/detail?id=<%=id%>&sendMethod=selectEdit">修改</a>
      </td>
    </tr>
    <%}%>
  </table>
  <div style="padding-left: 990px">
    <input type="submit" name="sbt" value="删除所选项">
  </div>
  <hr>
</form>
</body>
</html>
