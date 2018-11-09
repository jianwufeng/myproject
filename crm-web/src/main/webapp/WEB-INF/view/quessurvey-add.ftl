<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>添加-修改</title>
    <link rel="stylesheet" href="../frame/layui/css/layui.css">
    <link rel="stylesheet" href="../frame/static/css/style.css">
    <link rel="icon" href="../frame/static/image/code.png">
</head>
<body class="body">

<form class="layui-form" action="">
	<fieldset class="layui-elem-field layui-field-title">
	  <legend>问卷信息</legend>
	</fieldset>
    <div class="layui-form-item">
        <label class="layui-form-label">问卷名称</label>

        <div class="layui-input-block">
            <input type="text" name="quesSurveyName" autocomplete="off" placeholder="请输入问卷名称" lay-verify="required"
                   class="layui-input">
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
                   class="layui-input" value="/crm-web/images/bsh-logo.jpg">
        </div>
    </div>
    
    <div class="layui-form-item layui-form-text">
        <label class="layui-form-label">问卷说明</label>
        <div class="layui-input-block">
            <textarea id="LAY_demo_editor" placeholder="请输入问卷说明" name="quesSurveyRemarks" class="layui-textarea" lay-verify="required"></textarea>
        </div>
    </div>
    
    <div class="layui-form-item">
	    <div class="layui-input-block">
	        <button class="layui-btn" lay-submit="" lay-filter="sub">提交生成问卷</button>
	    </div>
    </div>
</form>

<script src="../js/jquery-1.9.1.min.js"></script>
<script src="../js/common.js" charset="utf-8"></script>
<script src="../frame/layui/layui.all.js" charset="utf-8"></script>
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
            /* layer.alert(JSON.stringify(data.field), {
                title: '最终的提交信息'
            });
        	console.log(data.field); */
        	/* var url = "http://localhost:8080/crm-web/addQuesSurvey";
        	var data = JSON.stringify(data.field);
        	var data = syncPost(url, data);
        	if(data){
        		layer.msg('添加成功');
        	}else{
        		layer.msg('添加失败');
        	} */
        	
        	/* var $=layui.$;
      	    $.ajax({  
      	          type: 'post',  
      	          url: 'http://localhost:8080/crm-web/addQuesSurvey', // ajax请求路径  
      	          contentType : 'application/json',
      	          data:JSON.stringify(data.field),
      	          success: function(data){ 
      	            if(data){
      	              layer.msg('添加成功');
      	              //parent.location.href="/queryQuesSurveyList";
      	            }else {
      	              layer.msg('添加失败'); 
      	            }
      	          }  
      	      });  */
        	var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引  
      	    asyncXhr('/crm-web/addQuesSurvey', JSON.stringify(data.field), "POST", 'application/json', function(data){
      	    	if(data){
   	              layer.msg('添加成功');
   	              //parent.location.href="http://localhost:8080/crm-web/queryQuesSurveyList?page=1&limit=30";
   	            }else {
   	              layer.msg('添加失败'); 
   	            }
      	    });
        	
            //parent.layer.close(index); //再执行关闭 
            return false;
        });

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
    
    //$(function(){
		//$(".layui-form-item").on("click", "#button-add", function(e) {
		/* $("#button-add").click(function(){
			alert(111);
			//$("#answer-add").append("<div class='layui-form-item'><label class='layui-form-label'>选项1</label><div class='layui-inline'><div class='layui-input-inline'><input type='text' name='quesAnswerName' autocomplete='off' placeholder='请输入题目名称' lay-verify='required' class='layui-input'></div></div></div>");
		}); */
	//});
</script>
</body>
</html>