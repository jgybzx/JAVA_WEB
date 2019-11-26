<%--
  Created by IntelliJ IDEA.
  User: Jgybz
  Date: 2019/11/26
  Time: 9:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
http://localhost:8080/day05/jsp/hello.jsp
<%=request.getParameter("name")%>你好，这里是服务器
<div>
    <%
        //java代码块
        String s = "要显示的内容";
        System.out.println("s = " + s);
        response.getWriter().write(s);
    %>
    <%=s%>
</div>
</body>
</html>
