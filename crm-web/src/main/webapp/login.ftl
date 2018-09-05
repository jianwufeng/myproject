<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>登录</title>
    <link rel="stylesheet" href="frame/layui/css/layui.css">
    <link rel="stylesheet" href="frame/static/css/style.css">
    <link rel="icon" href="frame/static/image/code.png">
</head>
<body>

<div class="login-main">
    <header class="layui-elip">后台登录</header>
    <form class="layui-form">
        <div class="layui-input-inline">
            <input type="text" name="account" id="username" required lay-verify="required" placeholder="邮箱" autocomplete="off"
                   class="layui-input">
        </div>
        <div class="layui-input-inline">
            <input type="password" name="password" id="pwd" required lay-verify="required" placeholder="密码" autocomplete="off"
                   class="layui-input">
        </div>
        <div class="layui-input-inline login-btn">
            <button type="submit" class="layui-btn" lay-submit="" lay-filter="sub">登录</button>
        </div>
        <hr/>
        <p><a href="javascript:;" class="fl">立即注册</a><a href="javascript:;" class="fr">忘记密码？</a></p>
    </form>
</div>


<script src="frame/layui/layui.js"></script>
<script src="js/common.js"></script>
<script type="text/javascript">
    layui.use(['form'], function () {

        // 操作对象
        var form = layui.form
                , $ = layui.jquery;

        // you code ...
		// 验证
        form.verify({
            account: function (value) {
            	layer.alert("----"+value);
                if (value == "") {
                    return "请输入用户名";
                }
            },
            password: function (value) {
                if (value == "") {
                    return "请输入密码";
                }
            }
        });
        // 提交监听
        form.on('submit(sub)', function () {
        	<!-- $.ajax({
                url:'http://localhost:8080/crm-web/login',
                type:'post',
                //dataType:'text',
                data:{
                    email:$('#username').val(),
                    password:$('#pwd').val()
                },
                success:function(data){
                	layer.alert(data);
                    layer.msg('登录成功');
                    location.href = "index.html";
                }
            }) -->
            var REMOVE_URL = "http://localhost:8080/crm-web/login";
            var email = $('#username').val();
            alert(email);
            var password = $('#pwd').val();
            var data = syncPost(REMOVE_URL, {
				email : email,
				password : password
			});
			if (data) {
				layer.msg('登录成功');
	            location.href = "index.html";
			} else {
				alert("失败！请稍后再试。");
			}
            //防止页面跳转
            //return false;
        })
    });
</script>
</body>
</html>