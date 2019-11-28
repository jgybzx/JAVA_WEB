<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Jgybz
  Date: 2019/11/26
  Time: 15:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    List<String> list = new ArrayList<>();
    list.add("张三");
    list.add("李四");
    list.add("王五");
    request.setAttribute("list",list);
%>
<%--http:localhost:8080/day05/jsp/forEach.jsp--%>
<c:if test="${not empty list}">
    <c:forEach items="${list}" var="name" varStatus="i">
        <span>索引${i.index}/序号${i.count}:${name}</span><br>
    </c:forEach>
</c:if>
<c:if test="${not empty list}">
    <c:forEach items="${list}" var="name" varStatus="i" begin="0" end="${list.size()-1}" step="1">
        <span>索引${i.index}/序号${i.count}:${name}</span><br>
    </c:forEach>
</c:if>
</body>
</html>
