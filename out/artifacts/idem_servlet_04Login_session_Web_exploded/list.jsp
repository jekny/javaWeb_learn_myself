<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="com.oa.myItem.deptServer.deptServer" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.oa.myItem.jdbcUtil.jdbc_util" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="com.oa.myItem.bean.myJavaBean" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>indexPage</title>

</head>
<body>
    <p style="text-align: center;">welcome the page system  ： <%=session.getAttribute("username")%></p>
    <div style="text-align: right ;padding-right: 500px"><a href="<%=request.getContextPath()%>/user/exit" > 安全退出</a></div>
    <hr>
    <table border="1px solid" align="center" width = "800px">
        <tr>
            <th style="border: 1px solid;">部门序号</th>
            <th>部门编号</th>
            <th>部门名称</th>
            <th>操作</th>
        </tr>

        <%
            String contextPath = request.getContextPath();
            ArrayList<myJavaBean> nums = (ArrayList) request.getAttribute("nums");
            int i = 0;
            for (myJavaBean obj :
                    nums) {
                int deptno = obj.getDeptno();
                String dname = obj.getDname();
                String loc = obj.getLoc();
        %>
        <tr>
            <td><%=(++i)%></td>
            <td><%=deptno%></td>
            <td><%=dname%></td>
            <td>
                <a href="<%=contextPath%>/dept/delete?no=<%=deptno%>">删除</a>
                <a href="<%=contextPath%>/edit.jsp?no=<%=deptno%>">修改</a>
                <a href="<%=contextPath%>/dept/detail?no=<%=deptno%>">详细</a>
            </td>
        </tr>
        <%
            }
        %>



    </table>
    <hr>
    <a href="<%=contextPath%>/add.jsp">添加部门</a>
</body>
</html>