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

<form class="layui-form layui-form-pane" action="">

    <input type="hidden" name="quesSurveyId" value="${ques.quesSurveyId}">
    <input type="hidden" name="quesTypeId" value="${ques.quesTypeId}">

	<div class="layui-form-item">
        <label class="layui-form-label">题目名称</label>

        <div class="layui-input-block">
            <input type="text" name="quesName" autocomplete="off" placeholder="请输入题目名称" lay-verify="required"
                   class="layui-input">
        </div>
    </div>
    
    <div class="layui-form-item">
        <label class="layui-form-label">题目类型</label>

        <div class="layui-input-block">
            <input type="text" name="quesType" autocomplete="off" placeholder="题目类型（1：单选，2：多选）" lay-verify="required"
                   class="layui-input">
        </div>
    </div>
    
    <div class="layui-form-item">
        <label class="layui-form-label">题目排序标识</label>

        <div class="layui-input-block">
            <input type="text" name="orderById" autocomplete="off" placeholder="题目排序标识(如1,2,3)" lay-verify="required"
                   class="layui-input">
        </div>
    </div>
    
    <div class="layui-form-item">
        <button class="layui-btn" lay-submit="" lay-filter="sub">提交</button>
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
            layer.alert(JSON.stringify(data.field), {
                title: '最终的提交信息'
            });
            
            asyncXhr2('http://localhost:8080/crm-web/addQues', JSON.stringify(data.field), "POST", 'application/json', function(data){
      	    	if(data){
   	              layer.msg('添加成功');
   	              //parent.location.href="/queryQuesSurveyList";
   	            }else {
   	              layer.msg('添加失败'); 
   	            }
      	    });
            return false;
        });

    });
</script>
</body>
</html>