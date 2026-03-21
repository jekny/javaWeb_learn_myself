<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>addPage</title>
</head>
<body>
    <h2>新增页面</h2><hr>
    <form action="list.jsp" method="get">
        新增部门编号：<input type="text" name="no"><br>
        新增部门名称：<input type="text" name="name"><br>
        新增部门地址：<input type="text" name="address"><br>
        <input type="submit" value="提交" name="sbt">
        <input type="reset" value="重置" name="reset">
    </form>
    <hr>
    <a href="list.jsp">返回列表</a>
</body>
</html>