<%@ page import="javaBeanObject.stuffBean" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>详细</title>
</head>
<%stuffBean obj1 = (stuffBean) request.getAttribute("obj");%>
<body>

物料编号：<%=obj1.getWno()%><br>
物料名称：<%=obj1.getWname()%><br>
物种：<%=obj1.getWsp()%><br>
数量：<%=obj1.getWnumb()%><br>
仓库位置：<%=obj1.getWposition()%><br>
<hr>
<a href="<%=request.getContextPath()%>/stuff/list">返回首页列表</a>
</body>
</html>
