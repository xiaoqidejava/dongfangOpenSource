<%--
  Created by IntelliJ IDEA.
  User: 小柒的Java
  Date: 2021/5/24
  Time: 22:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>注册</title>
    <link rel="stylesheet" type="text/css" href="css/public.css"/>
    <link rel="stylesheet" type="text/css" href="css/login.css"/>
    <script type="text/javascript" src="js/calendar.js"></script>
    <script src="js/jquery-1.12.4.min.js"></script>

    <%--对注册页面的各种验证--%>
    <script type="text/javascript" src="js/checkUser.js"></script>
    <style>

        .reg p .error{
            /*变成块级元素*/
            display: inline-block;
            border: 1px solid #ff855a;
            background: #ffe8e0;
            line-height: 20px;
            padding-left:2px ;
            padding-right:2px ;
            margin-left: 7px;
        }
    </style>
</head>
<body>
<!-------------------reg-------------------------->
<div class="reg">
    <form action="${pageContext.request.contextPath}/registerServlet" method="post" onsubmit="return checkUserInfo(this)"><h1><a href="index.html"><img src="img/temp/logo.png"></a></h1>
        <h1 style="text-align: center;margin: 0px;padding: 0px">用户注册</h1>
        <p><input type="text" name="username" value="" placeholder="请输入用户名" onfocus="FocusObject(this)" onblur="BlurObject(this)"><span class="error"></span></p>
        <p><input type="text" name="name" value="" onfocus="FocusObject(this)" onblur="BlurObject(this)" placeholder="请输入姓名" ><span class="error"></span></p>
        <p><input type="text" name="password" value="" onfocus="FocusObject(this)" onblur="BlurObject(this)" placeholder="请输入密码" ><span class="error"></span></p>
        <p>
            请选择您的性别:
            <input style="width: 15px;height: 15px" type="radio" name="sex" value="T" checked="checked">男
            <input style="width: 15px;height: 15px" type="radio" name="sex" value="F">女
            <span class="error"></span>
        </p>
        <p><input type="text" name="dopassword" value="" onfocus="FocusObject(this)" onblur="BlurObject(this)" placeholder="请确认密码" ><span class="error"></span></p>
        <p><input type="text" name="birthday" value=""  placeholder="请输入生日 (格式:年-月-日)"><span class="error"></span></p>
        <p><input type="text" name="email" value="" placeholder="请输入邮箱"><span class="error"></span></p>
        <p><input type="text" name="mobile" value="" placeholder="请输入电话号码"><span class="error"></span></p>
        <p><input type="text" name="address" value="" placeholder="请输入地址"><span class="error"></span></p>
        <p><input class="code" type="text" name="veryCode" value="" onfocus="FocusObject(this)" onblur="BlurObject(this)" placeholder="验证码">
            <img src="getcode" alt="看不清，换一张" onclick="change(this)"  ><span class="error"></span></p>
        <p><input type="submit" name="" value="注册" ><span class="error"></span></p>
        <p class="txtL txt">完成此注册，即表明您同意了我们的<a href="#">
            lgt;使用条款和隐私策略>
        </a></p>
        <p class="txt"><a href="#"><span></span>已有账号登录</a></p>
        <!--<a href="#" class="off"><img src="img/temp/off.png"></a>-->
    </form>
</div>
</body>
</html>