<%@ page import="com.hyw.javawebtest.entity.stu" %><%--
  Created by IntelliJ IDEA.
  User: 26568
  Date: 2026/4/7
  Time: 20:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>edit</title>
</head>
<body>
<% stu stu = (stu)request.getAttribute("stu");%>
<form action="<%=request.getContextPath()%>/edit" method="post">
    id:<input type="text" name="id" value="<%=stu.getId()%>"><br>
    name:<input type="text" name="name" value="<%=stu.getName()%>"><br>
    age:<input type="text" name="age" value="<%=stu.getAge()%>"><br>
    <input type="submit" name="sbt" value="提交修改">
</form>
<hr>
    <a href="<%=request.getContextPath()%>/index.jsp">返回</a>
</body>
</html>
