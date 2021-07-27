<%--
  Created by IntelliJ IDEA.
  User: 小柒的Java
  Date: 2021/5/27
  Time: 20:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>登录</title>
    <link rel="stylesheet" type="text/css" href="css/public.css"/>
    <link rel="stylesheet" type="text/css" href="css/login.css"/>
    <script type="text/javascript" src="js/jquery-1.12.4.min.js"></script>
    <style>
        .login p .error{
            height: 25px;
            border: 1px solid #ff6600;
            margin-left: 5px;
            /*padding-left:3px;
            padding-right: 3px;*/
        }
    </style>
    <script type="text/javascript">
        var isSuccessfull=true;
        /*表单项获取焦点时移除span标签*/
        function checkFocusUser(obj){
            $(obj).next('span').html('').removeClass('error');
        }
        /*表单项失去焦点时添加span标签并且验证表单项*/
        function checkBlurUser(obj) {

            var val = $(obj).next('span');
            switch ($(obj).attr('name')){
                case "username":
                        if (obj.value=="" || obj.trim().length==0){
                            val.html("账号不能为空")
                            val.addClass("error");
                            isSuccessfull=false;
                        }else {
                            isSuccessfull=true;
                        }
                        break;
                case "password":
                        if (obj.value=="" || obj.trim().length==0){
                            val.html("密码不能为空")
                            val.addClass("error");
                            isSuccessfull=false;
                        }else {
                            isSuccessfull=true;
                        }
                        break;
            }

        }
        function checkForm(obj) {
            // 获取所有标签
            let userInfo = obj.getElementsByTagName("input");
            // var els = frm.getElementsByTagName('input');
            // 遍历所有标签
            for (let i = 0; i <userInfo.length ; i++) {
                if (userInfo[i].getAttribute("onblur")){
                    checkBlurUser(userInfo[i]);
                    // alert(isSuccessfull);
                }
            }
            return isSuccessfull;
        }
    </script>
</head>
<body><!-------------------login-------------------------->
<div class="login">
    <form action="${pageContext.request.contextPath}/loginServlet" onsubmit="return checkForm(this)" method="post"><h1><a href="index.jsp"><img src="img/temp/logo.png"></a></h1>
        <span class="error">${msg}</span>
        <div class="msg-warn hide"><b></b>公共场所不建议自动登录，以防账号丢失</div>
        <p><input type="text" name="username" value="" onfocus="checkFocusUser(this)" onblur="checkBlurUser(this)" placeholder="昵称/邮箱/手机号"><span class="error"></span></p>
        <p><input type="text" name="password" value="" onfocus="checkFocusUser(this)" onblur="checkBlurUser(this)" placeholder="密码"><span class="error"></span></p>
        <p><input type="submit" name="" value="登  录"></p>
        <p class="txt"><a class="" href="reg.jsp">免费注册</a><a href="forget.html">忘记密码？</a></p>
    </form>
</div>
</body>
</html>
