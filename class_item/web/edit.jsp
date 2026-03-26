<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>编辑</title>
</head>
<body style="font-size: 20px">
<%--这里是先查询出来放到这里，在修改并提交给真正的修改逻辑--%>

物料编号：<input type="text" name="Wno" value=""/><br>
物料名称：<input type="text" name="Wname" value=""/><br>
物种：<input type="text" name="Wsp" value=""/><br>
数量：<input type="number" name="Wnumb" value=""/><br>
仓库位置：<input type="text" name="Wposition" value=""/><br>
<hr>
<a href="<%=request.getContextPath()%>/index.jsp">返回首页列表</a>
</body>
</html>
