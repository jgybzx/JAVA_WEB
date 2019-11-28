<%--
  Created by IntelliJ IDEA.
  User: Jgybz
  Date: 2019/11/26
  Time: 17:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>展示People</title>
</head>
<body>
http://localhost:8080/day05/jsp/showPeople.jsp
<div align="center">
    <table bgcolor="#7fffd4" border="1px" cellpadding="0" cellspacing="0">
        <tr>
            <th>序号</th>
            <th>名字</th>
            <th>年龄</th>
            <th>性别</th>
        </tr>
        <c:if test="${not empty people}">
            <c:forEach items="${people}" var="p" varStatus="i">
                <tr>
                    <td>${i.count}</td>
                    <td>${p.getName()}</td>
                    <td>${p.getSex()}</td>
                    <td>${p.getAge()}</td>
                </tr>
            </c:forEach>
        </c:if>
    </table>
</div>
</body>
</html>
