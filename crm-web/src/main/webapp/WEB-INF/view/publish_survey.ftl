<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>${(survey.quesSurveyName)!}</title>
    <link rel="stylesheet" href="frame/static/css/base.css">
    <link rel="stylesheet" href="frame/layui/css/layui.css">
    <link rel="stylesheet" href="frame/static/css/style.css">
    <style type="text/css">
    	h3.big
		  {
		  line-height: 40px
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
		body {width: 1000px; margin: 0 auto;}
		.layui-elem-quote_ext {
		    line-height: 30px;
		    border-left: 5px solid #009688;
		    border-radius: 0 2px 2px 0;
		    background-color: #f2f2f2;
		}
	</style>
</head>
<body>
	<table width="100%">
	    <tbody>
		     <tr width="20%">
			      <th align="left"><img width="360" height="135" src="./frame/static/image/survey.jpg" /></th>
			      <th align="right" style="font-weight:bold;margin:20px;letter-spacing:10px"><font size="5"><i>上海波音航空改装维修工程有限公司</i></font></th>
		     </tr>
    	</tbody>
    </table>
    <hr style="margin-bottom:10px">
	<div id="survey_remarks_editer_id" style="text-indent: 0.2cm;line-height: 30px;margin:10px"><font color="#666">${survey.quesSurveyRemarks!}</font></div>
	<br>
	<div id="survey_valid_data_id" style="text-indent: 0.2cm;font-weight:bold;margin:10px"><font color="red"><i style="letter-spacing:3px">答卷开始和截止时间 :</i> ${survey.startDate!} 到 ${survey.endDate!}</font></div>
	<form action=""method="get" id="formSubmit">
		<h2 class="big" align="center" style="font-weight:bold;margin:40px;letter-spacing:10px"><font size="5"> <i class="layui-icon" style="font-size: 30px; color: #1E9FFF;">&#xe6b2;</i>${(survey.quesSurveyName)!}</font></h2>
		<div class="div_style">
		<#if survey.quesTypeList?default([])?size !=0>
		<#list survey.quesTypeList as quesType>
			<div class="layui-elem-quote_ext" class="big">
				<h3 style="font-weight:bold;line-height: 50px;margin:10px;font-size: 18px;">${quesType.quesTypeName} ${quesType.quesTypeEnglishName!}</h3>
			</div>
			<ul>
			<#if quesType.quesList?default([])?size !=0>
			<#list quesType.quesList as ques> 
				<#assign index =ques_index + 1 > 
				<div id="an-ques-answer-id">
					<li><p class="big<#if ques.isRequired==1> ques-required</#if>" style="margin-top:10px"><b>${index}. ${ques.quesName}</b></p>
					<p class="big" style="margin-bottom:10px"><b>  ${ques.quesEnglishName!}</b></p>
					<ul id="${ques.quesId}">
					<input type="hidden" name="quesSurveyId" value="${ques.quesSurveyId}"/>
					<input type="hidden" name="quesTypeId" value="${ques.quesTypeId}"/>
					<input type="hidden" name="quesId" value="${ques.quesId}"/>
					<input type="hidden" name="quesName" value="${ques.quesName}"/>
					<input type="hidden" name="quesType" value="${ques.quesType}"/>
					<input type="hidden" name="isRequired" value="${ques.isRequired}"/>
					<#if ques.quesType == 1>
						<#if ques.quesAnswerDetailList?default([])?size !=0>
							<#list ques.quesAnswerDetailList as aswer>
								<li class="big" style="margin-left:20px" id="${aswer.answerId}">
									 <input type="radio" name="${ques.quesId}-answerName" value="${aswer.answerName}" style="margin-right:10px;" />${aswer.answerName}
									 <input type="hidden" name="${aswer.answerId}-answerId" value="${aswer.answerId}"/>
									 <input type="hidden" name="${aswer.answerId}-answerScore" value="0"/>
								</li>
							</#list>
						</#if>
					<#elseif ques.quesType == 3>
						<div class="big" >
				            <textarea class="big" placeholder="请输入答案" id="${ques.quesId}-answerName" name="${ques.quesId}-answerName" class="layui-textarea" rows="5"cols="100" maxlength="2000"></textarea>
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
		<br>
		<input type="button" class="layui-btn" id="submitAnswer" value="提交/submit" style="margin-left:40px;height:40px;width:120px;">
		<!--<input type="reset" style="height:30px;width:50px;">-->
		<br><br>
		</div>
	</form>
	<script src="js/jquery-1.9.1.min.js"></script>
	<script src="frame/layui/layui.js"></script>
	<script src="js/common.js"></script>
	<script src="js/survey.js"></script>
	<script type="text/javascript">
    layui.use(['form', 'layedit', 'laydate', 'element'], function () {
        var form = layui.form
                , layer = layui.layer
                , layedit = layui.layedit
                , laydate = layui.laydate
                , element = layui.element;
        
        // you code ...
        laydate.render({
            elem: '#date'
            //,type: 'datetime'
            ,range: true
          });
        
        var xuanxiang = 0;
        $("#button-add").click(function(){
        	xuanxiang ++ ;
			$("#answer-add").append("<div class='layui-form-item'><label class='layui-form-label'>选项"+xuanxiang+" :</label><div class='layui-input-block'> <input type='text' name='quesAnswerName"+xuanxiang + "' autocomplete='off' placeholder='请输入答案选项名称' lay-verify='required' class='layui-input'></div></div>");
		});

    });
  </script>
</body>
</html>