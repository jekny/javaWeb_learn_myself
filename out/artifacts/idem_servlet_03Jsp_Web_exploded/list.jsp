<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>indexPage</title>

</head>
<body>
    <p style="text-align: center;">welcome the page system</p>
    <hr>
    <table border="1px solid" align="center" width = "800px">
        <tr>
            <th style="border: 1px solid;">部门序号</th>
            <th>部门编号</th>
            <th>部门名称</th>
            <th>操作</th>
        </tr>
        <tr>
            <td>1</td>
            <td>10</td>
            <td>销售部</td>
            <td>
                <a href="">删除</a>
                <a href="edit.jsp">修改</a>
                <a href="detail.jsp">详细</a>
            </td>
        </tr>
        <tr>
            <td>2</td>
            <td>20</td>
            <td>技术部</td>
            <td>
                <a href="">删除</a>
                <a href="edit.jsp">修改</a>
                <a href="detail.jsp">详细</a>
            </td>
        </tr>
        <tr>
            <td>3</td>
            <td>30</td>
            <td>美术部</td>
            <td>
                <a href="">删除</a>
                <a href="edit.jsp">修改</a>
                <a href="detail.jsp">详细</a>
            </td>
        </tr>
    </table>
    <hr>
    <a href="add.jsp">添加部门</a>
</body>
</html>