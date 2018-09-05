// 302错误处理（未登录用户ajax请求）
$.ajaxSetup({
	statusCode : {
		302 : function() {
			alert('登陆超时，请重新登陆');
		}
	}
});

$(document).ready(function() {
	
	$(".layui-form").on("click", "#login-id", function(e) {
		var REMOVE_URL = "http://localhost:8080/crm-web/login";
        var email = $('#username').val();
        alert(email);
        var password = $('#pwd').val();
        var data = syncPost(REMOVE_URL, {
			email : email,
			password : password
		});
		if (data) {
			alert('登录成功');
            location.href = "index.ftl";
            alert(location.href)
		} else {
			alert("失败！请稍后再试。");
		}
	});
	
});