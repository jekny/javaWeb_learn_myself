<%--
  Created by IntelliJ IDEA.
  User: 26568
  Date: 2026/4/7
  Time: 20:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>add</title>
</head>
<body>
<%--要点：注意加项目的根路径--%>
    <form action="<%=request.getContextPath()%>/add" method="post">
        id:<input type="text" name="id"><br>
        name:<input type="text" name="name"><br>
        age:<input type="text" name="age"><br>
        <input type="submit" value="提交添加">
    </form>
<hr>
    <a href="<%=request.getContextPath()%>/index.jsp">返回</a>
</body>
</html>
