<%--
  Created by IntelliJ IDEA.
  User: 26568
  Date: 2026/3/25
  Time: 19:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>详细</title>
</head>
<body>
物料编号：<input type="text" name="Wno"/><br>
物料名称：<input type="text" name="Wname"/><br>
物种：<input type="text" name="Wsp"/><br>
数量：<input type="number" name="Wnumb"/><br>
仓库位置：<input type="text" name="Wposition"/><br>
<hr>
<a href="<%=request.getContextPath()%>/index.jsp">返回首页列表</a>
</body>
</html>
