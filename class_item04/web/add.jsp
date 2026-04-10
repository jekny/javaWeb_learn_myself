<%--
  Created by IntelliJ IDEA.
  User: 26568
  Date: 2026/4/10
  Time: 8:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>add</title>
</head>
<body>
<div style="font-size: 20px;padding-left: 50px">
  <form action="<%=request.getContextPath()%>/add" method="get">
    id:<input type="text" name="id" ><br>
    name:<input type="text" name="name"><br>
    age:<input type="text" name="age"><br>
    <input type="submit" name="sbt" value="提交添加">
  </form>
</div>
<a href="<%=request.getContextPath()%>/index.jsp">返回列表</a>
</body>
</html>
