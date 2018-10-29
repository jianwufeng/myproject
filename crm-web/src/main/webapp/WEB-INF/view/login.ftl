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
        ${message!}
        <div class="layui-input-inline login-btn">
            <button type="button" id="login-id" class="layui-btn" lay-submit="" lay-filter="sub">登录</button>
        </div>
        <hr/>
        <!--<p><a href="javascript:;" class="fl">立即注册</a><a href="javascript:;" class="fr">忘记密码？</a></p>-->
    </form>
</div>

<script src="js/jquery-1.9.1.min.js"></script>
<script src="frame/layui/layui.js"></script>
<script src="js/common.js"></script>
<script src="js/survey_login.js"></script>
</body>
</html>