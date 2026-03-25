<%--
  Created by IntelliJ IDEA.
  User: 26568
  Date: 2026/3/25
  Time: 17:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>主页</title>
</head>
<body>
<h1 style="text-align: center">welcome the 物料 system</h1>
<hr>
<div >
    <a href="<%=request.getContextPath()%>/add.jsp" style="padding-left: 130px; font-size: 25px">添加物料</a>
    <table border="1px solid" align="center" width = "1000px">
        <tr >
            <th>物料编号</th>
            <th>物料名称</th>
            <th>种&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp类</th>
            <th>数量&nbsp&nbsp&nbsp&nbsp&nbsp(箱)</th>
            <th>操&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp作</th>
        </tr>

        <tr style="text-align: center">
            <td>x</td>
            <td>x</td>
            <td>x</td>
            <td>x</td>
            <td>
                <input type="checkbox" name="deleteAll" value="">
                <a href="">删除</a>|
                <a href="<%=request.getContextPath()%>/edit.jsp">修改</a>|
                <a href="<%=request.getContextPath()%>/detail.jsp">详细</a>
            </td>
        </tr>

    </table>
</div>
<hr>


</body>
</html>
