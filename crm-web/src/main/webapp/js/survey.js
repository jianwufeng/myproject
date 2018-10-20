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
	
	$("#formSubmit").on("click", "#submitAnswer", function(e) {
		var REMOVE_URL = "http://localhost:8080/crm-web/publish";
		
		var data = [];
		$("#formSubmit").find("input[type='radio']").each(function(){
	        if($(this).is(":checked")){
//	            alert($(this).val());
	            var answerName=$(this).val();
	            var answerId=$(this).next().val();
	            var answerScore=$(this).next().next().val();
	            alert("answerScore = " + answerScore);
	            var quesId = $(this).parent().parent().find($("input[name^='quesId']")).val();
	            var quesTypeId = $(this).parent().parent().find($("input[name^='quesTypeId']")).val();
	            var quesSurveyId = $(this).parent().parent().find($("input[name^='quesSurveyId']")).val();
	            var quesName = $(this).parent().parent().find($("input[name^='quesName']")).val();
	            var quesType = $(this).parent().parent().find($("input[name^='quesType']")).val();
	            var ansObj = {
	            		"quesSurveyId":quesSurveyId,
	            		"quesTypeId":quesTypeId,
	            		"quesId":quesId,
	            		"quesName":quesName,
	            		"quesType":quesType,
	            		"answerId":answerId,
	            		"answerName":answerName,
	            		"answerScore":answerScore
	            };
	            data.push(ansObj);
	        }
	    });
		
//		asyncXhrPost(REMOVE_URL, JSON.stringify(data), function(res){
//			if(res){
//				
//			}
//		});
		
		$.ajax({
			type:'POST',
	         url:REMOVE_URL,
	         dataType:"json",      
	         contentType:"application/json",   
	         data:JSON.stringify(data),
	         success:function(data){		
	        	 if(data.isSuccess){
	        		 alert("提交成功");
	        		 //window.location.href ="https:" + salesorder_domain + "/order/goSubmitPage";
	        	 }else{
//	        		 showMessage(data.data);
//	        		 loadCart_normal();
	        	 }
	         }
		});
	});
	
});