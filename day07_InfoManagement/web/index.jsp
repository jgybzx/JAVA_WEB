<%--
  Created by IntelliJ IDEA.
  User: Jgybz
  Date: 2019/11/29
  Time: 9:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%--http://localhost:8080/day07/index.jsp--%>
<head>
    <title>人员信息管理</title>
</head>
<body>
<h3>【人员信息展示 】</h3>
<a href="/day07/UserSelect">展示</a>
<hr>
<form method="post" enctype="multipart/form-data" action="${pageContext.request.contextPath}/FileServlet">
    文件<input type="file" name="myFile"/><br/>
    描述<input type="text" name="myDesc"/><br/>
    <input type="submit" value="提交"/>
</form>
</body>
</html>
