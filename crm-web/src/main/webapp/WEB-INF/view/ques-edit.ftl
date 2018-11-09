<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>添加-修改</title>
    <link rel="stylesheet" href="frame/layui/css/layui.css">
    <link rel="stylesheet" href="frame/static/css/style.css">
    <link rel="icon" href="frame/static/image/code.png">
</head>
<body class="body">

<form class="layui-form" action="">
	<input type="hidden" name="quesId" value="${ques.quesId}">
    <input type="hidden" name="quesSurveyId" value="${ques.quesSurveyId}">
    <input type="hidden" name="quesTypeId" value="${ques.quesTypeId}">

    <fieldset class="layui-elem-field layui-field-title">
	  <legend>题目</legend>
	</fieldset>
	
	<div id="quesListId">
		<div id="ques_dev">
			<div class="layui-form-item">
			 	<div class="layui-inline">
			        <label class="layui-form-label">题目名称</label>
			        <div class="layui-input-inline">
			            <input type="text" name="quesName" autocomplete="off" placeholder="请输入题目名称" lay-verify="required"
			                   class="layui-input" value="${ques.quesName!}">
			        </div>
			        <label class="layui-form-label">题目类型</label>
			        <div class="layui-input-inline">
			            <select id="quesTypeSelectionId" name="quesType" disabled>
				          <option value="0">请选择</option>
				          <option <#if ques.quesType == 1>selected="selected"</#if> value="1">单选</option>
				          <option <#if ques.quesType == 3>selected="selected"</#if> value="3">问答</option>
				        </select>
			        </div>
			        <label class="layui-form-label">是否必答</label>
			        <div class="layui-input-inline">
			            <select name="isRequired">
				          <option value="0">请选择</option>
				          <option <#if ((ques.isRequired) == 1)>selected="selected"</#if> value="1">是</option>
				          <option <#if ((ques.isRequired) == 2)>selected="selected"</#if> value="2">否</option>
				        </select>
			        </div>
		        </div>
		        <div class="layui-inline">
		        	<label class="layui-form-label"></label>
			        <div class="layui-input-inline">
			            <input type="text" name="quesEnglishName" autocomplete="off" placeholder="请输入题目英文名称" lay-verify="required"
			                   class="layui-input" value="${ques.quesEnglishName!}">
			        </div>
			     </div>
		    </div>
		    <div class="layui-form-item">
			    <div class="layui-inline">
			        <label class="layui-form-label">答案选项：</label>
			        <div class="layui-input-inline">
				        <input type="button" class="layui-btn layui-btn-xs" id="button-add" value="添加选项"></input>
				    </div>
			    </div>
		    </div>
		    <div id="answer-add">
		   		<#assign xx = 1 > 
		    	<#if answerDetailList??>
		    		<#list answerDetailList as quesAnswer>
		    			<#if ques.quesType == 1>
							<#assign xx =quesAnswer_index + 1 > 
							<div class="layui-form-item">
								<label class="layui-form-label">选项${xx!} :</label>
								<div class="layui-input-block">
									<input type="hidden" name="answerId${xx!}" autocomplete="off" placeholder="请输入答案选项名称" lay-verify="required" class="layui-input" value="${quesAnswer.answerId!}"> 
									<input type="text" name="answerName${xx!}" autocomplete="off" placeholder="请输入答案选项名称" lay-verify="required" class="layui-input" value="${quesAnswer.answerName!}">
								</div>
							</div>
						<#elseif ques.quesType == 3>
							<#assign xx =quesAnswer_index + 1 > 
							<div class="layui-form-item">
								<label class="layui-form-label">选项 :</label>
								<div class="layui-input-block">
									<input type="hidden" id="answerId" name="answerId" class="layui-input" value="${quesAnswer.answerId!}"> 
									<textarea id="answerName" name="answerName" placeholder="问答题不用输入" class="layui-textarea" disabled>${quesAnswer.answerName!}</textarea>
								</div>
							</div>
						</#if>
						
					</#list>
				</#if>
		    </div>
		    <hr>
		</div>
	</div>
			
    <div class="layui-form-item">
	    <div class="layui-input-block">
	        <button class="layui-btn" lay-submit="" lay-filter="sub">更新问卷</button>
	    </div>
    </div>
</form>

<script src="js/jquery-1.9.1.min.js"></script>
<script src="js/common.js" charset="utf-8"></script>
<script src="frame/layui/layui.js" charset="utf-8"></script>
<script type="text/javascript">
    layui.use(['form', 'layedit', 'laydate', 'element'], function () {
        var form = layui.form
                , layer = layui.layer
                , layedit = layui.layedit
                , laydate = layui.laydate
                , element = layui.element;

        //创建一个编辑器
        var editIndex = layedit.build('LAY_demo_editor');
        
        //自定义验证规则
        /* form.verify({
            title: function (value) {
                if (value.length < 5) {
                    return '标题至少得5个字符啊';
                }
            }
            , pass: [/(.+){6,12}$/, '密码必须6到12位']
            , content: function (value) {
                layedit.sync(editIndex);
            }
        }); */

        //监听提交
        form.on('submit(sub)', function (data) {
            /*layer.alert(JSON.stringify(data.field), {
                title: '最终的提交信息'
            });*/
            
            var formData = new FormData();
            
            var quesTypeReq = {
				quesTypeName : data.field.quesTypeName,
				quesTypeEnglishName : data.field.quesTypeEnglishName,
				quesTypeRemarks : data.field.quesTypeRemarks,
				quesSurveyId : data.field.quesSurveyId,
				orderById : data.field.orderById
			}
			
			var quesReq = {
				quesId : data.field.quesId,
				quesName:data.field.quesName,
				quesEnglishName:data.field.quesEnglishName,
				quesType:data.field.quesType,
				quesSurveyId:data.field.quesSurveyId,
				quesTypeId:data.field.quesTypeId,
				isRequired:data.field.isRequired,
				orderById:data.field.orderById
			}
			
			var quesAnswerDetailListReq = [];
			if($("#answer-add").find("input[type='text']").length > 0){
				$("#answer-add").find("input[type='text']").each(function(i){
					var answerName = $(this).val();
					var answerId = $(this).prev().val();
					/*var quesAnswerDetailReq = {
						answerName : answerName,
						orderById : i+1
					};*/
					
					var quesAnswerDetailReq = {};
					quesAnswerDetailReq['answerId'] = answerId;
					quesAnswerDetailReq['answerName'] = answerName;
					quesAnswerDetailReq['orderById'] = i+1;
					quesAnswerDetailListReq.push(quesAnswerDetailReq);
				});
			}else {
				var answerId = $("#answerId").val();
				var answerName = "";
				var quesAnswerDetailReq = {};
				quesAnswerDetailReq['answerId'] = answerId;
				quesAnswerDetailReq['answerName'] = answerName;
				quesAnswerDetailReq['orderById'] = $("#orderById").val();
				quesAnswerDetailListReq.push(quesAnswerDetailReq);
			}
			
            formData.quesType = quesTypeReq; 
            formData.ques = quesReq; 
            formData.quesAnswerDetailList = quesAnswerDetailListReq; 
            /*layer.alert(JSON.stringify(formData));*/
            asyncXhr2('/crm-web/editQues.ftl', JSON.stringify(formData), "POST", 'application/json', function(data){
      	    	if(data){
   	              layer.msg('添加成功');
   	              parent.location.href="survey/ques.ftl";
   	            }else {
   	              layer.msg('添加失败'); 
   	            }
      	    });
            return false;
        });
        
        var xuanxiang = ${xx!};
        $("#button-add").click(function(){
        	if($('#quesTypeSelectionId').val() == 1){
        		if($("#answer-add").find("input[type='text']").length == 0){
	        		$("#answer-add").html("");
	        		xuanxiang = 0;
        		}
	        	xuanxiang ++ ;
				$("#answer-add").append("<div class='layui-form-item'><label class='layui-form-label'>选项"+xuanxiang+" :</label><div class='layui-input-block'> <input type='text' name='quesAnswerName"+xuanxiang + "' autocomplete='off' placeholder='请输入答案选项名称' lay-verify='required' class='layui-input'></div></div>");
        	}else if($('#quesTypeSelectionId').val() == 3){
        		$("#answer-add").html("<div class='layui-form-item'><label class='layui-form-label'>选项 :</label><div class='layui-input-block'> <textarea id='quesAnswerId' name='quesAnswerName' autocomplete='off' placeholder='问答题不需要输入' class='layui-textarea'></textarea></div></div>");
        		$("#answer-add").attr({"disabled":"disabled"});
        	}else {
        		layer.alert("请选择题目类型！")
        	}
		});
        
    });
</script>
</body>
</html>