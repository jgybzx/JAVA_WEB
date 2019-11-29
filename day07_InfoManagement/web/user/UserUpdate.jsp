<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body bgcolor="#efefef">

<p align="center">修改用户信息</p>
<div style="margin:auto;width:500px;background-color: pink;">
    <form action="${pageContext.request.contextPath}/UserUpdate" method="post" style="width:300px;margin:auto;">
        用户编号<input type="text" name="userId" value="${user.userId}" hidden/><br/>
        用户姓名<input type="text" name="userName" value="${user.userName}" /><br/>
        用户密码<input type="password" name="userPass" value="${user.userPass}" /><br/>
        用户年龄<input type="text" name="userAge" value="${user.userAge}" /><br/>
        <button type="reset">重置</button><button type="submit">提交</button>
    </form>
</div>
</body>
</html>
