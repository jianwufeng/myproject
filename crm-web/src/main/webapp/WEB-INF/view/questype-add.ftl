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

<form class="layui-form" action="" lay-filter="surveyRes">

    <input type="hidden" name="quesSurveyId" value="${survey.quesSurveyId}">

	<fieldset class="layui-elem-field layui-field-title">
	  <legend>问卷信息</legend>
	</fieldset>
    <div class="layui-form-item">
        <label class="layui-form-label">问卷名称</label>

        <div class="layui-input-block">
            <input type="text" name="quesSurveyName" autocomplete="off" placeholder="请输入问卷名称" lay-verify="required"
                   class="layui-input" value="${survey.quesSurveyName!}">
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">日期选择</label>

            <div class="layui-input-inline">
                <input type="text" name="startDate" id="startDate" autocomplete="off" class="layui-input" placeholder="开始时间" value="${survey.startDate}">
            </div>
            <div class="layui-input-inline">
                <input type="text" name="endDate" id="endDate" autocomplete="off" class="layui-input" placeholder="结束时间" value="${survey.endDate}">
            </div>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">问卷LOGO</label>

        <div class="layui-input-block">
            <input type="text" name="quesSurveyLogoUrl" autocomplete="off" placeholder="请输入问卷LOGO链接" lay-verify="required"
                   class="layui-input" value="${survey.quesSurveyLogoUrl}">
        </div>
    </div>
    
    <div class="layui-form-item layui-form-text">
        <label class="layui-form-label">问卷说明</label>
        <div class="layui-input-block">
            <textarea id="LAY_demo_editor" placeholder="请输入问卷说明" name="quesSurveyRemarks" class="layui-textarea" lay-verify="content">${survey.quesSurveyRemarks}</textarea>
        </div>
    </div>
    <fieldset class="layui-elem-field layui-field-title">
	  <legend>大类信息</legend>
	</fieldset>
	<input type="hidden" name="quesTypeId" value="${quesType.quesTypeId!}"/>
    <div class="layui-form-item">
        <label class="layui-form-label">大类标题</label>
        <div class="layui-input-block">
            <input type="text" name="quesTypeName" autocomplete="off" placeholder="请输入大类标题" lay-verify="required"
                   class="layui-input" value="${quesType.quesTypeName!}">
        </div>
    </div>
    <div class="layui-form-item layui-form-text">
        <label class="layui-form-label">说明</label>
        <div class="layui-input-block">
            <textarea placeholder="请输入大类说明" name="quesTypeRemarks" class="layui-textarea" lay-verify="required">${quesType.quesTypeRemarks!}</textarea>
        </div>
    </div>
    <!-- <div class="layui-form-item">
        <label class="layui-form-label">题目标题</label>
        <div class="layui-input-block">
            <input type="text" name="quesTypeName" autocomplete="off" placeholder="请输入标题" lay-verify="required"
                   class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label"></label>
        <div class="layui-input-block">
            <input type="text" name="quesTypeName" autocomplete="off" placeholder="请输入英文标题" lay-verify="required"
                   class="layui-input">
        </div>
    </div>-->
    
    <div class="layui-form-item">
        <label class="layui-form-label">题目大类排序标识</label>

        <div class="layui-input-block">
            <input type="text" name="orderById" autocomplete="off" placeholder="题目大类排序标识(如1,2,3)" lay-verify="required"
                   class="layui-input" value="${quesType.orderById!}">
        </div>
    </div>
    
    <div class="layui-form-item">
	    <div class="layui-input-block">
	        <button class="layui-btn" lay-submit="" lay-filter="sub">提交生成问卷</button>
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
        form.verify({
           content: function (value) {
                layedit.sync(editIndex);
            }
        });

        //监听提交
        var typeIndex = form.on('submit(sub)', function (data) {
            /*layer.alert(JSON.stringify(data.field), {
                title: '最终的提交信息'
            });*/
            
            var formData = new FormData();
            
            var quesTypeReq = {
            	quesTypeId : data.field.quesTypeId,
				quesTypeName : data.field.quesTypeName,
				quesTypeRemarks : data.field.quesTypeRemarks,
				quesSurveyId : data.field.quesSurveyId,
				orderById : data.field.orderById
			}
			
			var quesSurveyReq = {
				quesSurveyId : data.field.quesSurveyId,
				quesSurveyName : data.field.quesSurveyName,
				quesSurveyLogoUrl : data.field.quesSurveyLogoUrl,
				quesSurveyRemarks : data.field.quesSurveyRemarks,
				startDate : data.field.startDate,
				endDate : data.field.endDate
			}
            formData.quesType = quesTypeReq; 
            formData.quesSurvey = quesSurveyReq;
            asyncXhr2('/crm-web/saveQuesType.ftl', JSON.stringify(formData), "POST", 'application/json', function(data){
      	    	if(data){
   	              layer.msg('添加成功');
   	              parent.location.href="survey/ques-type.html";
   	            }else {
   	              layer.msg('添加失败'); 
   	            }
      	    });
            return false;
        });
        
        //layer.close(typeIndex);
        laydate.render({
        	elem: '#startDate',
		});
		laydate.render({
		    elem: '#endDate'
		});
    });
</script>
</body>
</html>