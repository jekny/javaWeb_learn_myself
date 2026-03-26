<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>新增页面</title>
</head>
<body style="font-size: 20px">
<form action="<%=request.getContextPath()%>/stuff/add" method="post">
    物料编号：<input type="text" name="Wno"/><br>
    物料名称：<input type="text" name="Wname"/><br>
    物种：<input type="text" name="Wsp"/><br>
    数量：<input type="number" name="Wnumb"/><br>
    仓库位置：<input type="text" name="Wposition"/><br>
    <input type="submit" value="提交新增信息" name="sbt"/>
    <input type="reset" value="重置" name="res"/>
</form>
<hr>
<a href="<%=request.getContextPath()%>/index.jsp">返回首页列表</a>
</body>
</html>
