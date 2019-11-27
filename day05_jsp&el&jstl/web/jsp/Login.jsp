<%--
  Created by IntelliJ IDEA.
  User: Jgybz
  Date: 2019/11/26
  Time: 20:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户登录</title>
</head>
<body>
http://localhost:8080/day05/jsp/Login.jsp
<form action="/day05/LoginServlet" >
    用户名：<input type="text" name="userName" value="${cookie.userCookie.value}"><br>
    密码：<input type="password" name="userPass"><br>
    <input type="checkbox" name="remember" value="remember" ${cookie.userCookie.value!=null?"checked":""}>记住用户名<br>
    <input type="submit" name="btn" value="登录">
</form>
</body>
</html>
