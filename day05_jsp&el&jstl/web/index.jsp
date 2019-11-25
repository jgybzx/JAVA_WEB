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

<body>
<input type="button" id="btn" value=显示 onclick="start()"/><br>
<input type="button" id="btn1" value="停止" onclick="stop()">
<span id="span"></span>
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
