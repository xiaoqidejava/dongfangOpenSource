<%--
  Created by IntelliJ IDEA.
  User: 小柒的Java
  Date: 2021/7/25
  Time: 11:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>自己做的ssm整合</title>
</head>
<body>
<center>
    <h1>所有的用户</h1>
    <c:forEach items="${user}" var="user">
        <table>
            <tr>
                <td>用户名</td>
                <td>用户密码</td>
            </tr>
            <tr>
                <td>${user.username}</td>
                <td>${user.password}</td>
            </tr>
        </table>
    </c:forEach>


</center>
</body>
</html>
