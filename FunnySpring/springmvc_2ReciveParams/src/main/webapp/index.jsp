<html>
<body>
<h2>Hello World!</h2>
</body>

        <center>
            <form action="${pageContext.request.contextPath}/user/requestParamsAnno" method="post">
                用户名<input type="text" name="cusername">
                密码<input type="password" name="cpassword">
                <input type="submit" value="提交">
            </form>
        </center>

</html>
