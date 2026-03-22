<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
<%--    <h1><a href="<%=request.getContextPath()%>/dept/login">查看列表</a></h1>--%>
<h1>welcome to login page</h1>
    <form action="<%=request.getContextPath()%>/user/login" method="post">
        username:<input type="text" name="username" /><br>
        password:<input type="text" name="password"><br>

        <input type="submit" name="sbt" value="登录"/>
    </form>
</body>
</html>