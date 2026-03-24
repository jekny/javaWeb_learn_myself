<%@ page import="com.test.user" %><%--
  Created by IntelliJ IDEA.
  User: 26568
  Date: 2026/3/24
  Time: 21:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    user user1 = new user();
    user1.setAge(18);
    user1.setName("梨花");
request.setAttribute("user1",user1);
%>

${user1}
${user1.age}




