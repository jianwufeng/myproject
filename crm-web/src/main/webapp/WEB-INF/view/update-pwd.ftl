<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>修改密码</title>
    <link rel="stylesheet" href="./frame/layui/css/layui.css">
    <link rel="stylesheet" href="./frame/static/css/style.css">
    <link rel="icon" href="./frame/static/image/code.png">
</head>
<body class="body">

<form class="layui-form" action="">
	<fieldset class="layui-elem-field layui-field-title">
	  <legend>修改密码</legend>
	</fieldset>
	<div class="layui-form-item layui-form-text">
        <label class="layui-form-label">用户名</label>
        <div class="layui-input-block">
            <input type="text" name="userName" autocomplete="off"  lay-verify="required"
                   class="layui-input" value="${loginUser.userName}" readonly="readonly">
        </div>
    </div>
    <div class="layui-form-item layui-form-text">
        <label class="layui-form-label">请输入新密码</label>
        <div class="layui-input-block">
            <input type="password" id="password_id" name="password" autocomplete="off" placeholder="请输入新密码" lay-verify="required"
                   class="layui-input">
        </div>
    </div>
    <div class="layui-form-item layui-form-text">
        <label class="layui-form-label">请确认新密码</label>
        <div class="layui-input-block">
            <input type="password" id="confirm_password_id" name="confirm_password" autocomplete="off" placeholder="请确认新密码" lay-verify="required"
                   class="layui-input">
        </div>
    </div>
    
    <div class="layui-form-item">
	    <div class="layui-input-block">
	        <button class="layui-btn" lay-submit="" lay-filter="sub">提交</button>
	    </div>
    </div>
</form>

<script src="./js/jquery-1.9.1.min.js"></script>
<script src="./js/common.js" charset="utf-8"></script>
<script src="./frame/layui/layui.all.js" charset="utf-8"></script>
<script type="text/javascript">
    layui.use(['form', 'layedit', 'laydate', 'element'], function () {
        var form = layui.form
                , layer = layui.layer
                , layedit = layui.layedit
                , laydate = layui.laydate
                , element = layui.element;

        //创建一个编辑器
        //var editIndex = layedit.build('LAY_demo_editor');

        //自定义验证规则
        /*form.verify({
            pass: [/(.+){6,12}$/, '密码必须6到12位']
            , content: function (value) {
                layedit.sync(editIndex);
            }
        });*/

        //监听提交
        form.on('submit(sub)', function (data) {
            /* layer.alert(JSON.stringify(data.field), {
                title: '最终的提交信息'
            });
        	console.log(data.field); */
        	
        	var pwd = $("#password_id").val();
        	var repwd = $("#confirm_password_id").val();
        	
        	if(pwd != repwd){
        		alert("两次输入密码不同，请重新输入。");
        		return ;
        	}
        	
        	var formData = {
        		userName : data.field.userName,
        		password : pwd
        	};
        	
      	    asyncXhr2('/crm-web/updatePwd.ftl', JSON.stringify(formData), "POST", 'application/json', function(data){
      	    	if(data){
   	              layer.msg('修改密码成功');
   	          	  parent.location.href="/crm-web/index.ftl";
   	            }else {
   	              layer.msg('修改密码失败'); 
   	            }
      	    });
        	
            return false;
        });

    });
    
</script>
</body>
</html>