<%@ page import="com.hyw.test.entity.stu" %><%--
  Created by IntelliJ IDEA.
  User: 26568
  Date: 2026/4/6
  Time: 21:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>add</title>
</head>
<body>
    <form action="<%=request.getContextPath()%>/user/add" method="post">
        id:<input type="text" name="id"><br>
        name:<input type="text" name="name"><br>
        age:<input type="text" name="age"><br>
      <input type="submit" name="sbt" value="提交"><hr>
    </form>
<a href="<%=request.getContextPath()%>/index.jsp"> 返回首页</a>
</body>
</html>
