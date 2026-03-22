<%@ page import="com.oa.myItem.bean.myJavaBean" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>

<%
    myJavaBean num = (myJavaBean) request.getAttribute("num");
%>

<body>
    <h2>部门详情</h2>
    <hr>
    部门编号：<%=num.getDeptno()%><br>
    部门名称：<%=num.getDname()%><br>
    部门位置：<%=num.getLoc()%><br>
    <br>
        <hr>
    <a href="<%=request.getContextPath()%>/dept/list">返回列表</a>
</body>
</html>