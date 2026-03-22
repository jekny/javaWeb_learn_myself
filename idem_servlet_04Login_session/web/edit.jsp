<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="com.oa.myItem.jdbcUtil.jdbc_util" %>
<%@ page import="java.sql.SQLException" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>

<body>
    <h2>修改页面</h2><hr>
    <form action="<%=request.getContextPath()%>/dept/xiugai" method="get">

        <%
            Connection con = null;
            PreparedStatement ps = null;
            ResultSet rs = null;

            int no = Integer.parseInt(request.getParameter("no"));
            String contextPath = request.getContextPath();

            try {
                con = jdbc_util.getcon();
                String sql = "select deptno,dname,loc from dept where deptno = ?";
                ps = con.prepareStatement(sql);
                ps.setInt(1,no);

                rs = ps.executeQuery();
                if (rs.next()){
                    int no1 = rs.getInt("deptno");
                    String dname = rs.getString("dname");
                    String loc = rs.getString("loc");
               %>
        部门编号：<input type="text" name="no" readonly value="<%=no1%>"><br>
        修改部门名称：<input type="text" name="name" value="<%=dname%>"><br>
        修改部门地址：<input type="text" name="address" value="<%=loc%>"><br>
               <% }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }finally {
                jdbc_util.close(con,ps,rs);
            }
        %>
        <input type="submit" value="提交" name="sbt">
        <input type="reset" value="重置" name="reset">
    </form>

</body>
</html>