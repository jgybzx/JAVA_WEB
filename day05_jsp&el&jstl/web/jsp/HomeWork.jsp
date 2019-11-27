<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Jgybz
  Date: 2019/11/26
  Time: 20:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
http:localhost:8080/day05/jsp/HomeWork.jsp
${1<2?"<h1>a</h1>":"b"}
<c:choose >
    <c:when test="${3>2}">
        <h1>aaa</h1>
    </c:when>
    <c:when test="${3>1}">
        <h1>aaaaaaa</h1>
    </c:when>
    <c:otherwise>
        <h1>otherwise</h1>
    </c:otherwise>
</c:choose>
<hr>
<%
    List list1=new ArrayList();
    list1.add("abc");
    List list2=new ArrayList();
    request.setAttribute("list1", list1);
    request.setAttribute("list2", list2);
%>
<c:if test="${not empty list1}">
    <span>list不为空</span>
</c:if>
<c:if test="${empty list2}">
    <span>list2=null</span>
</c:if>
<hr>
<%
    List list3=new ArrayList();
    list3.add(12);
    list3.add("qwqw");
    list3.add(123);
    request.setAttribute("list3",list3);
%>
<c:if test="${not empty list3 }">
    <c:forEach items="${list3}" var="obj">
        <div>${obj}</div>
    </c:forEach>
</c:if>
<hr>
<c:forEach var="Integer" begin="1" end="10" step="1">
    <span>${Integer}</span>
</c:forEach>
<hr>
<c:forEach var="Integer" begin="1" end="10" step="1">
    <c:if test="${Integer%2==0}">
        <span>${Integer}</span>
    </c:if>
</c:forEach>
</body>
</html>
