<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>详细</title>
</head>
<body>
<%--展示详细信息这里直接展示数据即可，不要文本框--%>
物料编号：<input type="text" name="Wno"/><br>
物料名称：<input type="text" name="Wname"/><br>
物种：<input type="text" name="Wsp"/><br>
数量：<input type="number" name="Wnumb"/><br>
仓库位置：<input type="text" name="Wposition"/><br>
<hr>
<a href="<%=request.getContextPath()%>/stuff/list">返回首页列表</a>
</body>
</html>
