<%--
  Created by IntelliJ IDEA.
  User: 小柒的Java
  Date: 2021/5/28
  Time: 15:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>『学习猿地』后台管理</title>
    <link rel="stylesheet" type="text/css" href="css/admin_login.css"/>
    <script src="${pageContext.request.contextPath}/js/jquery-1.12.4.min.js"></script>
    <style>
        .error{
            height: 25px;
            margin-left: 5px;
            padding-left: 2px;
            padding-right: 2px;
            border: 1px solid darkred;
            color: darkred;
        }
    </style>
    <script>
        /*定义一个全局标签*/
        var isFlag=true;
        /*检查前端传来的用户名以及密码是否为空*/
        /*获取焦点*/
        function checkFocusInput(obj) {
            $(obj).next('span').html('').removeClass('error');
        }
        /*失去焦点*/
        function checkBlurInput(obj) {
            let next = $(obj).next('span');
            switch ($(obj).attr('name')) {
                case 'username':
                    if (obj.value == ""){
                        next.html('用户名不能为空');
                        next.addClass('error');
                        isFlag=false;
                    }else {
                        isFlag=true;
                    }
                    break;
                    case 'password':
                        if (obj.value == ""){
                            next.html('密码不能为空');
                            next.addClass('error');
                            isFlag=false;
                        }else {
                            isFlag=true;
                        }
                        break;
            }

        }
       function checkThisForm(obj){

            /*获取所有表单标签*/
            let eles = obj.getElementsByTagName('input');
           for (let i = 0; i <eles.length; i++) {
               if (eles[i].getAttribute('onblur')){
                   checkBlurInput(eles[i]);
               }

           }
            return isFlag;
       }
    </script>
</head>
<body>
<div class="admin_login_wrap">
    <h1>后台管理</h1>
    <div class="adming_login_border">
        <div class="admin_input">
            <span>${msg}</span>
            <form action="${pageContext.request.contextPath}/manager/adminloginServlet" onsubmit="return checkThisForm(this)" method="post">
                <ul class="admin_items">
                    <li>
                        <label for="user">用户名：</label>
                        <input type="text" name="username" value="" onfocus="checkFocusInput(this)" onblur="checkBlurInput(this)"  id="user" size="40" class="admin_input_style" />
                        <span class="error"></span>
                    </li>
                    <li>
                        <label for="pwd">密码：</label>
                        <input type="password" name="password" value="" onfocus="checkFocusInput(this)" onblur="checkBlurInput(this)" id="pwd" size="40" class="admin_input_style" />
                        <span class="error"></span>
                    </li>
                    <li>
                        <input type="submit" tabindex="3" value="提交" class="btn btn-primary" />
                    </li>
                </ul>
            </form>
        </div>
    </div>
    <p class="admin_copyright"><a tabindex="5" href="#" target="_blank">返回首页</a> &copy; 2014 Powered by 更多模板：<a href="http://www.lmonkey.com/" target="_blank">学习猿地</a></p>
</div>
</body>
</html>
