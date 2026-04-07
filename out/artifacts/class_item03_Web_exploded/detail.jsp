<%@ page import="com.hyw.javawebtest.entity.stu" %><%--
  Created by IntelliJ IDEA.
  User: 26568
  Date: 2026/4/7
  Time: 20:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>detail</title>
</head>
<body>
<%stu stu = (stu)request.getAttribute("stu");%>
id:<%=stu.getId()%><br>
name:<%=stu.getName()%><br>
age:<%=stu.getAge()%>
<hr>
<a href="<%=request.getContextPath()%>/index.jsp">返回</a>
</body>
</html>
