
/*
用户注册页面检查用户提交表单中的信息
 */

// 标记位(如果表单中有错误就返回false，让表单提交不上去)
var isFlag=true;

/*改变验证码中的内容*/
function change(object) {
    object.src = "getcode?" + new Date().getTime();
}



/*鼠标获取焦点时移除span标签*/
function FocusObject(obj) {

    /*如果标签是验证码获取他的下下个标签并且移除*/
    if ($(obj).attr('name') == 'veryCode') {
        $(obj).next('img').next('span').html('').removeClass('error');
    }
    /*如果是平常标签获取他的下个标签并且移除*/
    $(obj).next('span').html('').removeClass('error');

}
/*鼠标失去去焦点时添加span标签*/
function BlurObject(obj) {
/*检测各个表单项的内容是否符合要求*/
    let next = $(obj).next('span');
    switch ($(obj).attr('name')) {
        case "username":
            if (obj.value == "") {
                next.html('用户名不能为空');
                next.addClass('error');
                isFlag=false;
            }
            /*用ajax判断一下该用户名是否可用*/
            else {
                var url = "usernameCheck?username=" + encodeURI($(obj).val());
                $.get(url, function (data) {

                    if (data == 'false') {
                        next.html('用户名已被占用');
                        next.addClass('error');
                        isFlag=false;
                    } else {
                        next.html('用户名可以使用');
                        next.addClass('error');
                        isFlag=true;
                    }
                })
            }
            break;
        case "password":
            if (obj.value == "") {
                next.html('密码不能为空');
                next.addClass('error');
                isFlag=false;
            }else {
                isFlag=true;
            }
            break;
        case "dopassword":
            if (obj.value == "") {
                next.html('密码不能为空');
                next.addClass('error');
                isFlag=false;
            } else if ($(obj).val() != $('input[name="password"]').val()) {
                next.html('两次输入的密码不一致');
                next.addClass('error');
                isFlag=false;
            }else {
                isFlag=true;
            }
            break;
        case "veryCode":
            let next1 = $(obj).next().next();
            if (obj.value == "") {
                next1.html('验证码不能为空');
                next1.addClass('error');
                isFlag=false;
            } else {
                // var url="checkusernum?num="+encodeURI($(obj).val());
                var url = "checkusernum?num=" + encodeURI($(obj).val());
                // alert(url);
                $.get(url, function (numdata) {

                    if (numdata == "false") {
                        next1.html('验证码输入错误');
                        next1.addClass('error');
                        isFlag=false;
                    } else {
                        next1.html('验证码正确');
                        next1.addClass('error');
                        isFlag=true;
                    }

                })
            }
            break;
    }
}

/*检查表单提交信息*/
function checkUserInfo(frm) {

    // 获取所有表单标签
    var els = frm.getElementsByTagName('input');

    // 循环所有表单项
    for (let i = 0; i < els.length; i++) {
        if (els[i] != null) {
            // 判断这些表单标签中哪些含有onblur属性
            if (els[i].getAttribute("onblur")) {
                // 就检查一下表单中的内容是否符合
                BlurObject(els[i]);
            }
        }
        return isFlag;
    }


}