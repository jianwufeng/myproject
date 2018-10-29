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
		var REMOVE_URL = "/crm-web/login";
        var userName = $('#username').val();
        var password = $('#pwd').val();
        var formData = {
        	userName : userName,
			password : password
		};
        
        asyncXhr2('/crm-web/login', JSON.stringify(formData), "POST", 'application/json', function(data){
        	var jsonData =  eval("("+data+")");
  	    	if(jsonData.data){
  	    		window.location.href="/crm-web/index.ftl";
  	    		//$(location).attr("href","/crm-web/index.ftl");
            }else {
            	alert('用户名或密码错误!');
            }
  	    });
	});
	
});