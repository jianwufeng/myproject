<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>${(survey.quesSurveyName)!}</title>
    <style type="text/css">
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
		
//		p {text-indent: 1cm}
		//li {text-indent: 1cm}
	</style>
</head>
<body>
	<h2 align="center" style="font-weight:bold;">${(survey.quesSurveyName)!}</h2>
	<form action=""method="get" id="formSubmit">
		<#if survey.quesTypeList?default([])?size !=0>
		<#list survey.quesTypeList as quesType>
			<h3 style="font-weight:bold;">${quesType.orderById}. ${quesType.quesTypeName}</h3> 
			<ul>
			<#if quesType.quesList?default([])?size !=0>
			<#list quesType.quesList as ques> 
				<li><p><font size="3" >${ques.orderById}. ${ques.quesName}</font></p>
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
								 <input type="radio" name="${ques.quesId}-answerName" value="${aswer.answerName}"/>${aswer.answerName}
								 <input type="hidden" name="${aswer.answerId}-answerId" value="${aswer.answerId}"/>
								 <input type="hidden" name="${aswer.answerId}-answerScore" value="${aswer.answerScore}"/>
							</li>
						</#list>
					</#if>
				<#elseif ques.quesType == 2>
					<#if ques.quesAnswerDetailList?default([])?size !=0>
						<#list ques.quesAnswerDetailList as aswer> 
							<li class="big" >
								<input type="checkbox" name="${ques.quesId}-answerName" value="${aswer.answerName}"/>${aswer.answerName}
							</li>
						</#list>
					</#if>
				<#else>
					
				</#if>
				</ul>
				</li>
			</#list>
			</#if>
		</ul>
		</#list>
		</#if>
		<br><br>
		<input type="button" id="submitAnswer" value="提交">
		<input type="reset">
	</form>
	<script src="js/jquery-1.9.1.min.js"></script>
	<script src="frame/layui/layui.js"></script>
	<script src="js/common.js"></script>
	<script src="js/survey.js"></script>
</body>
</html>