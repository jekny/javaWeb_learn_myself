<%@ page import="com.hyw.test.entity.stu" %><%--
  Created by IntelliJ IDEA.
  User: 26568
  Date: 2026/4/6
  Time: 21:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    stu stu1 = (stu) request.getAttribute("stu");
%>
<form action="<%=request.getContextPath()%>/user/edit" method="post">
    id:<input type="text" name="id" value="<%=stu1.getId()%>"/><br>
    name:<input type="text" name="name" value="<%=stu1.getName()%>"><br>
        age:<input type="text" name="age" value="<%=stu1.getAge()%>"><br>
        <input type="submit" name="sbt" value="提交修改">
    </form>
<a href="<%=request.getContextPath()%>/index.jsp">返回</a>
</body>
</html>
