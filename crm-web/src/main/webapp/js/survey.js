$(document).ready(function() {
	
	$("#formSubmit").on("click", "#submitAnswer", function(e) {
		
		var isSubmit = true;
		$("#formSubmit").find(".ques-required").each(function(){
			var $this = $(this).next().next();
			
			var quesType = $this.find($("input[name='quesType']")).val();
			
			if(quesType == 1){
				if($this.find("input[type='radio']:checked").length == 0){
					isSubmit = false;
					alert($(this).html() + ": 答案不能为空!");
					return false;
				}
			}
			
			if(quesType == 3){
				if($this.find("textarea").val() == ''){
					isSubmit = false;
					alert($(this).html() + ": 答案不能为空!");
					return false;
				}
			}
			
		});
		
		if(isSubmit){
			var REMOVE_URL = "/crm-web/publish";
			var data = [];
			$("#formSubmit").find("input[type='radio'],textarea").each(function(){
				var answerName=$(this).val();
				var isRequired = $(this).parents("#an-ques-answer-id").find($("input[name='isRequired']")).val();
				var quesId = $(this).parents("#an-ques-answer-id").find($("input[name='quesId']")).val();
				var quesTypeId = $(this).parents("#an-ques-answer-id").find($("input[name='quesTypeId']")).val();
				var quesSurveyId = $(this).parents("#an-ques-answer-id").find($("input[name='quesSurveyId']")).val();
				var quesName = $(this).parents("#an-ques-answer-id").find($("input[name='quesName']")).val();
				var quesType = $(this).parents("#an-ques-answer-id").find($("input[name='quesType']")).val();
				var answerId=$(this).next().val();
				var answerScore=$(this).next().next().val();
				if(quesType == 1){
					if($(this).is(":checked")){
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
				}
		        if(quesType == 3){
		        	if(isRequired == 1 && (answerName == null ||answerName == '')){
						isSubmit = false;
						alert(quesName + ": 答案不能为空!");
						return false;
					}
		        	var ansObj = {
		            		"quesSurveyId":quesSurveyId,
		            		"quesTypeId":quesTypeId,
		            		"quesId":quesId,
		            		"quesName":quesName,
		            		"quesType":quesType,
		            		"answerId":answerId,
		            		"answerName":answerName,
		            		"answerScore":0
		            };
		        	data.push(ansObj);
		        }
		    });
		
			$.ajax({
				type:'POST',
				url:REMOVE_URL,
				dataType:"json",      
				contentType:"application/json",   
				data:JSON.stringify(data),
				success:function(data){	
					if(data.data){
						alert("提交成功");
						$("#submitAnswer").attr({"disabled":"disabled"});
						//window.location.href ="https:" + salesorder_domain + "/order/goSubmitPage";
					}else{
						alert(data.message);
					}
				}
			});
			
		}
	});
	
});