<%@ page import="javaBeanObject.stuffBean" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>编辑</title>
</head>
<body style="font-size: 20px">
<%--这里是先查询出来放到这里，在修改并提交给真正的修改逻辑--%>
<%
    stuffBean obj1 = (stuffBean) request.getAttribute("obj1");
%>
<form action="<%=request.getContextPath()%>/stuff/editreal?no=<%=obj1.getWno()%>" method="post">
    物料编号：<input type="text" name="Wno" value="<%=obj1.getWno()%>" readonly/><br>
    物料名称：<input type="text" name="Wname" value="<%=obj1.getWname()%>"/><br>
    物种：<input type="text" name="Wsp" value="<%=obj1.getWsp()%>"/><br>
    数量：<input type="number" name="Wnumb" value="<%=obj1.getWnumb()%>"/><br>
    仓库位置：<input type="text" name="Wposition" value="<%=obj1.getWposition()%>"/><br>
    <input type="submit" name="sbt" value="修改"/>
</form>
<hr>
<a href="<%=request.getContextPath()%>/stuff/list">返回首页列表</a>
</body>
</html>
