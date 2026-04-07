<%@ page import="com.hyw.test.entity.stu" %><%--
  Created by IntelliJ IDEA.
  User: 26568
  Date: 2026/4/6
  Time: 21:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>

<body>
<%
    stu stu1 = (stu) request.getAttribute("stu");
%>
    id:<%=stu1.getId()%><br>
    name:<%=stu1.getName()%><br>
    age:<%=stu1.getAge()%><hr>
<a href="<%=request.getContextPath()%>/index.jsp">返回</a>

</body>
</html>
