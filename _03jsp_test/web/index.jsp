<%--
  Created by IntelliJ IDEA.
  User: 26568
  Date: 2026/3/21
  Time: 21:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--jsp专用注释，不会被编译到class文件中--%>

<%
    System.out.println("这个符号是java代码符号，jsp会将符号内的翻译成java语言，在外面什么都没包裹的文字则被翻译成out.print()在里面");
%>

hello,我是被out对象包裹着的输出

<%--这里的符号带！号，是翻译到类里面的，而上面不带！号的是翻译到service方法中的(这行东西不能在！里面)--%>
<%!
    public int i1 = 0;
%>


