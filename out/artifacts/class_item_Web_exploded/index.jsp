<%@ page import="java.sql.Connection" %>
<%@ page import="Util.jdbcUtil" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.util.List" %>
<%@ page import="javaBeanObject.stuffBean" %>
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
    <form action="add.jsp" method="get">
        <table border="1px solid" align="center" width = "1000px">
            <tr >
                <th>物料编号</th>
                <th>物料名称</th>
                <th>种&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp类</th>
                <th>数量&nbsp&nbsp&nbsp&nbsp&nbsp(箱)</th>
                <th>操&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp作</th>
            </tr>
            <%
                List<stuffBean> list = (List<stuffBean>) request.getAttribute("stuff");
                for (stuffBean sb :
                        list) {
                    int wno = sb.getWno();
                    String wname = sb.getWname();
                    String wsp = sb.getWsp();
                    int wnumb = sb.getWnumb();
                    String wposition = sb.getWposition();
            %>
            <tr style="text-align: center">
                <td><%=wno%></td>
                <td><%=wname%></td>
                <td><%=wsp%></td>
                <td><%=wnumb%></td>
                <td>
                    <input type="checkbox" name="deleteAbout" value="<%=wno%>">
                    <a href="">删除</a>|
                    <a href="<%=request.getContextPath()%>/edit.jsp?no=<%=wno%>">修改</a>|
                    <a href="<%=request.getContextPath()%>/detail.jsp?no=<%=wno%>">详细</a>
                </td>
            </tr>
            <%}%>
        </table>
        <div style="padding-left: 1140px">
            <input type="submit" name="sbm" value="删除选择项"/>
        </div>
    </form>
</div>
<hr>
</body>
</html>
