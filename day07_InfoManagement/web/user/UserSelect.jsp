<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body bgcolor="#f0f8ff">
http://localhost:8080/day07/user/UserSelect.jsp

<p align="center">查询用户信息&emsp; <a href="${pageContext.request.contextPath}/user/UserInsert.jsp">新增</a></p>
<table border="1" align="center" cellpadding="5" cellspacing="0" width="550" bgcolor="#f5f5dc">
    <tr bgcolor="#7fffd4">
        <th hidden>顺序</th>
        <th>序号</th>
        <th>用户姓名</th>
        <th>用户密码</th>
        <th>用户年龄</th>
        <th>操作</th>
    </tr>
    <c:if test="${not empty list}">
        <c:forEach items="${list}" var="user" varStatus="status">
            <tr align="center">
                <td>${status.count}</td>
                    <%--                <td>${user.userId}</td>--%>
                    <%--                <td>${user.userName}</td>--%>
                    <%--                <td>${user.userPass}</td>--%>
                    <%--                <td>${user.userAge}</td>--%>
                <td hidden>${user.getUserId()}</td>
                <td>${user.getUserName()}</td>
                <td>${user.getUserPass()}</td>
                <td>${user.getUserAge()}</td>
                <td>
                    <a href="${pageContext.request.contextPath}/UserUpdateShow?id=${user.getUserId()}">修改</a>
                    |
                    <a href="${pageContext.request.contextPath}/UserDelete?id=${user.getUserId()}">删除</a>
                </td>
            </tr>
        </c:forEach>
    </c:if>


</table>


</body>
</html>
