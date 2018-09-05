// 302错误处理（未登录用户ajax请求）
$.ajaxSetup({
	statusCode : {
		302 : function() {
			alert('登陆超时，请重新登陆');
		}
	}
});

$(document).ready(function() {
	
//	$("#ques_survey_id_parent").on("click", "#ques_survey_id", function(e) {
//		var REMOVE_URL = "http://localhost:8080/crm-web/queryQuesSurveyList";
//        var data = syncGet(REMOVE_URL, {
//		});
//		if (data) {
//			alert(data);
//            location.href = "ques-survey.html";
//		} else {
//			alert("失败！请稍后再试。");
//		}
//	});
	
});