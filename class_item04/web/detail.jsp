<%@ page import="com.hyw.javawebtest.entity.Stu" %><%--
  Created by IntelliJ IDEA.
  User: 26568
  Date: 2026/4/10
  Time: 8:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>detail</title>
</head>
<body>
<%
    Stu stu = (Stu) request.getAttribute("stu");//向请求域中取资源
%>
<div style="font-size: 20px;padding-left: 50px">
    id:&nbsp<%=stu.getId()%><br>
    name:<%=stu.getName()%><br>
    age:<%=stu.getAge()%><br>
</div>
<a href="<%=request.getContextPath()%>/index.jsp">返回列表</a>
</body>
</html>
