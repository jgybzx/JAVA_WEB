<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page import="java.util.ArrayList" %>
<%--
  Created by IntelliJ IDEA.
  User: Jgybz
  Date: 2019/11/25
  Time: 19:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
//http://localhost:8080/day05/index.jsp
<body>
<input type="button" id="btn" value=显示 onclick="start()"/><br>
<input type="button" id="btn1" value="停止" onclick="stop()">
<span id="span"></span><br>
<input type="text" name="checkcode"><img src="getMyCode">
<hr>
<%
    request.setAttribute("str",null);
    request.setAttribute("list",new ArrayList<>());
%>
${empty str}<br>
${empty list}<br>
${str == null? "数据为空":str}<br>
${not empty str}
<c:out value="out"> sa</c:out>
</body>
<script>
    let interval;

    function start() {
        interval = setInterval(Time, 100);
    }

    function Time() {
        let date = new Date();
        let year = String(date.getFullYear()).padStart(4, "0");
        let month = String(date.getMonth() + 1).padStart(2, "0");
        let day = String(date.getDay()).padStart(2, "0");
        let hour = String(date.getHours()).padStart(2, "0");
        let min = String(date.getMinutes()).padStart(2, "0");
        let sec = String(date.getSeconds()).padStart(2, "0");
        let mil = String(date.getMilliseconds()).padStart(3, "0");
        let str = `${year}-${month}-${day} ${hour}:${min}:${sec}:${mil}`;
        let str1 = year + "-" + month + "-" + day + " " + hour + ":" + min + ":" + sec + ":" + mil;
        document.querySelector("#span").innerHTML = str1;
    }

    function stop() {
        clearInterval(interval);
    }
</script>
</html>
