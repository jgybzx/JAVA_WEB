<%--
  Created by IntelliJ IDEA.
  User: Jgybz
  Date: 2019/11/29
  Time: 22:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" enctype="multipart/form-data" action="${pageContext.request.contextPath}/FileServlet">
    文件<input type="file" name="myFile"/><br/>
    描述<input type="text" name="myDesc"/><br/>
    <input type="submit" value="提交"/>
</form>
</body>
</html>
