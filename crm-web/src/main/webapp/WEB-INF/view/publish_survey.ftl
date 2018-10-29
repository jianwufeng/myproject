<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>${(survey.quesSurveyName)!}</title>
    <link rel="stylesheet" href="frame/static/css/base.css">
    <style type="text/css">
    	h3.big
		  {
		  line-height: 50px
		  }
		p.small
		  {
		  line-height: 10px
		  }
		p.big
		  {
		  line-height: 30px
		  }
		
		li.small
		  {
		  line-height: 10px
		  }
		li.big
		  {
		  line-height: 30px
		  }
		textarea.big
		  {
		  line-height: 30px
		  }
		li {text-indent: 1.2cm}
		h3 {text-indent: 0.2cm}
	</style>
</head>
<body>
	<div id="survey_remarks_editer_id">${survey.quesSurveyRemarks!}</div>
	<h2 class="big" align="center" style="font-weight:bold;margin:10px">${(survey.quesSurveyName)!}</h2>
	<form action=""method="get" id="formSubmit">
		<div class="div_style">
		<#if survey.quesTypeList?default([])?size !=0>
		<#list survey.quesTypeList as quesType>
			<h3 class="big" style="font-weight:bold;background-color:#FFFF00;">${quesType.quesTypeName}</h3> 
			<ul>
			<#if quesType.quesList?default([])?size !=0>
			<#list quesType.quesList as ques> 
				<#assign index =ques_index + 1 > 
				<div id="an-ques-answer-id">
					<li><p class="big" style="background-color:#d0d0d0"><font size="3" >${index}. ${ques.quesName}</font></p>
					<ul id="${ques.quesId}">
					<input type="hidden" name="quesSurveyId" value="${ques.quesSurveyId}"/>
					<input type="hidden" name="quesTypeId" value="${ques.quesTypeId}"/>
					<input type="hidden" name="quesId" value="${ques.quesId}"/>
					<input type="hidden" name="quesName" value="${ques.quesName}"/>
					<input type="hidden" name="quesType" value="${ques.quesType}"/>
					<#if ques.quesType == 1>
						<#if ques.quesAnswerDetailList?default([])?size !=0>
							<#list ques.quesAnswerDetailList as aswer>
								<li class="big" id="${aswer.answerId}">
									 <input type="radio" name="${ques.quesId}-answerName" value="${aswer.answerName}" style="margin-right:10px;" />${aswer.answerName}
									 <input type="hidden" name="${aswer.answerId}-answerId" value="${aswer.answerId}"/>
									 <input type="hidden" name="${aswer.answerId}-answerScore" value="0"/>
								</li>
							</#list>
						</#if>
					<#elseif ques.quesType == 3>
						<div class="big" >
				            <textarea class="big" placeholder="请输入答案" id="${ques.quesId}-answerName" name="${ques.quesId}-answerName" class="layui-textarea" lay-verify="required" rows="5"cols="100" maxlength="200"></textarea>
							<#if ques.quesAnswerDetailList?default([])?size !=0>
									<#list ques.quesAnswerDetailList as aswer> 
										<input type="hidden" name="${aswer.answerId}-answerId" value="${aswer.answerId}"/>
										<input type="hidden" name="${aswer.answerId}-answerScore" value="0"/>
									</#list>
							</#if>
						</div>
					<#else>
						
					</#if>
					</ul>
					</li>
				</div>
			</#list>
			</#if>
		</ul>
		</#list>
		</#if>
		<br><br>
		<input type="button" id="submitAnswer" value="提交" style="margin-left:40px;height:30px;width:50px;">
		<input type="reset" style="height:30px;width:50px;">
		</div>
	</form>
	<script src="js/jquery-1.9.1.min.js"></script>
	<script src="frame/layui/layui.js"></script>
	<script src="js/common.js"></script>
	<script src="js/survey.js"></script>
</body>
</html>