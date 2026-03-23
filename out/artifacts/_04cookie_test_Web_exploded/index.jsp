<%--
  Created by IntelliJ IDEA.
  User: 26568
  Date: 2026/3/23
  Time: 19:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>先访问链接1（存了两个cookie），再访问链接2（专门取cookie，request.getCookies()）</div>
<a href="<%=request.getContextPath()%>/cookie/red">1、查看cookie，浏览器会自动facookie到服务器，所以在客户端存一个cookie就好</a><hr>
<a href="<%=request.getContextPath()%>/sendCookie">2、点击此路径会发送到接受cookie的类</a>
</body>
</html>
