<%--
  Created by IntelliJ IDEA.
  User: 小柒的Java
  Date: 2021/7/25
  Time: 20:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>doAjax</title>
    <script src="js/jquery-3.5.1.js"></script>
    <script >
        $(function (){
            alert(1)
            $("#btn1").click(function () {
                alert(2)
                $.get("doAjax",{username:"wujie"},function (resp) {
                    alert(resp)
                    $("#username").innerHTML = resp.username;
                })
            })
        })
    </script>
</head>
<body>
        用户名:<input type="text" id="username" name="username">
        <button  id="btn1">执行ajax操作，返回值void</button>
</body>
</html>
