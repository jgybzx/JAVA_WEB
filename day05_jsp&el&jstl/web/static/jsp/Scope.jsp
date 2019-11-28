<%--
  Created by IntelliJ IDEA.
  User: Jgybz
  Date: 2019/11/26
  Time: 14:10
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--http:localhost:8080/day05/--%>
<%
    pageContext.setAttribute("attr", "pageContext");
%>
<%
    String pageContextAttribute = (String) pageContext.getAttribute("attr");
    out.println("pageContextAttribute = " + pageContextAttribute+"<br>");
    //获取 request 中的 属性值
    String requestAttribute = (String) request.getAttribute("attr");
    out.println("requestAttribute = " + requestAttribute+"<br>");
    //获取 session中的属性值
    String sessionAttribute = (String) session.getAttribute("attr");
    out.println("sessionAttribute = " + sessionAttribute+"<br>");
    //获取整个项目 的值
    String applicationAttribute = (String) application.getAttribute("attr");
    out.println("applicationAttribute = " + applicationAttribute);
%>
</body>
</html>
