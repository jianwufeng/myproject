<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>Data-Table 表格</title>
    <link rel="stylesheet" href="../frame/layui/css/layui.css">
    <!--<link rel="stylesheet" href="http://cdn.datatables.net/1.10.13/css/jquery.dataTables.min.css">-->
    <link rel="stylesheet" href="../frame/static/css/style.css">
    <link rel="icon" href="../frame/static/image/code.png">
</head>
<body class="body">

<!-- 工具集 -->
<div class="my-btn-box">
    <span class="fl">
        <!-- <a class="layui-btn layui-btn-danger radius btn-delect" id="btn-delete-all">批量删除</a> -->
        <a class="layui-btn btn-add btn-default" id="btn-add">添加问卷</a>
        <!-- <a class="layui-btn btn-add btn-default" id="btn-refresh"><i class="layui-icon">&#x1002;</i></a> -->
    </span>
    <!-- <span class="fr">
        <span class="layui-form-label">搜索条件：</span>
        <div class="layui-input-inline">
            <input type="text" autocomplete="off" placeholder="请输入搜索条件" class="layui-input">
        </div>
        <button class="layui-btn mgl-20">查询</button>
    </span> -->
</div>

<!-- 表格 -->
<div id="dateTableId" lay-filter="dateTableId"></div>

<script type="text/javascript" src="../frame/layui/layui.js"></script>
<script type="text/javascript" src="../js/index.js"></script>
<script src="../js/jquery-1.9.1.min.js"></script>
<script src="../js/common.js" charset="utf-8"></script>
<script type="text/javascript">

    // layui方法
    layui.use(['table', 'form', 'layer', 'vip_table'], function () {
        // 操作对象
        var form = layui.form
                , table = layui.table
                , layer = layui.layer
                , vipTable = layui.vip_table
                , $ = layui.jquery;
        
      //时间戳的处理
        layui.laytpl.toDateString = function(d, format){
          var date = new Date(d || new Date())
          ,ymd = [
            this.digit(date.getFullYear(), 4)
            ,this.digit(date.getMonth() + 1)
            ,this.digit(date.getDate())
          ]
          ,hms = [
            this.digit(date.getHours())
            ,this.digit(date.getMinutes())
            ,this.digit(date.getSeconds())
          ];

          format = format || 'yyyy-MM-dd HH:mm:ss';

          return format.replace(/yyyy/g, ymd[0])
          .replace(/MM/g, ymd[1])
          .replace(/dd/g, ymd[2])
          .replace(/HH/g, hms[0])
          .replace(/mm/g, hms[1])
          .replace(/ss/g, hms[2]);
        };
         
        //数字前置补零
        layui.laytpl.digit = function(num, length, end){
          var str = '';
          num = String(num);
          length = length || 2;
          for(var i = num.length; i < length; i++){
            str += '0';
          }
          return num < Math.pow(10, length) ? str + (num|0) : num;
        };

        //执行一个 table 实例
        var tableIns = table.render({
            elem: '#dateTableId'
            ,height: vipTable.getFullHeight()
            ,id: 'dataCheck'
            ,url: '/crm-web/queryQuesSurveyList' //数据接口
            ,title: '问卷表'
            ,page: true //开启分页
            ,toolbar: 'default' //开启工具栏，此处显示默认图标，可以自定义模板，详见文档
            ,totalRow: true //开启合计行
            , cols: [[                  //标题栏
                {checkbox: true, sort: true, fixed: true, space: true}
                , {field: 'quesSurveyId', title: '问卷编号', width: 200}
                , {field: 'quesSurveyName', title: '问卷名称', width: 230}
                , {field: 'createTime', title: '创建时间', width: 160,templet: '<div>{{ layui.laytpl.toDateString(d.createTime) }}</div>'}
                , {fixed: 'right', title: '操作', width: 460, align: 'center', toolbar: '#barOption'} //这里的toolbar值是模板元素的选择器
            ]]
        });

        // 表格渲染
        /* var tableIns = table.render({
            elem: '#dateTableId'                  //指定原始表格元素选择器（推荐id选择器）
            , height: vipTable.getFullHeight()    //容器高度
            , cols: [[                  //标题栏
                {checkbox: true, sort: true, fixed: true, space: true}
                , {field: 'id', title: 'ID', width: 80}
                , {field: 'quesSurveyId', title: '问卷编号', width: 120}
                , {field: 'quesSurveyName', title: '问卷名称', width: 120}
                , {field: 'quesSurveyLogoUrl', title: 'LOGO地址', width: 180}
                , {field: 'quesSurveyTitle', title: '问卷标题', width: 120}
                , {field: 'quesSurveyRemarks', title: '问卷说明', width: 160}
                , {field: 'createTime', title: '创建时间', width: 180}
                , {fixed: 'right', title: '操作', width: 150, align: 'center', toolbar: '#barOption'} //这里的toolbar值是模板元素的选择器
            ]]
            , id: 'dataCheck'
            , url: '/crm-web/queryQuesSurveyList'
            , method: 'get'
            , page: true
            , limits: [30, 60, 90, 150, 300]
            , limit: 30 //默认采用30
            , loading: false
            , done: function (res, curr, count) {
                //如果是异步请求数据方式，res即为你接口返回的信息。
                //如果是直接赋值的方式，res即为：{data: [], count: 99} data为当前页数据、count为数据总长度
                console.log(res);
                //得到当前页码
                console.log(curr);
                //得到数据总量
                console.log(count);
            } 
        }); */

        // 获取选中行
        table.on('checkbox(dateTableId)', function (obj) { //able.on('event(filter)', callback)
            layer.msg(obj.data.quesSurveyId);
            console.log(obj.checked); //当前是否选中状态
            console.log(obj.data); //选中行的相关数据
            console.log(obj.type); //如果触发的是全选，则为：all，如果触发的是单选，则为：one
        }); 

        // 刷新
        $('#btn-refresh').on('click', function () {
            tableIns.reload();
        });

      //监听行工具事件
        table.on('tool(dateTableId)', function(obj){ //注：tool 是工具条事件名，dateTableId 是 table 原始容器的属性 lay-filter="对应的值"
          var data = obj.data //获得当前行数据
          ,layEvent = obj.event; //获得 lay-event 对应的值
          if(layEvent === 'share'){
            //layer.msg('http://' + document.domain + '/crm-web/publishSurvey?quesSurveyId=' + data.quesSurveyId);
            layer.open({
        		  type: 1,
        		  content: '<div style="padding: 20px 100px;">'+ 'http://' + location.host + '/crm-web/publishSurvey?quesSurveyId=' + data.quesSurveyId +'</div>'
                ,btn: '关闭'
                ,btnAlign: 'c' //按钮居中
                ,shade: 0 //不显示遮罩
            });     
          } else if(layEvent === 'add'){
        	  //layer.msg('添加操作');
              	var index = layer.open({
              		  type: 2,
              		  area: ['700px', '300px'],
              		  fixed: false, //不固定
              		  maxmin: true,
              		  content: '/crm-web/getQuesTypeFtl.ftl?quesSurveyId=' + data.quesSurveyId
              	});
              	layer.full(index);
          } else if(layEvent === 'del'){
            layer.confirm('真的删除行么', function(index){
              obj.del(); //删除对应行（tr）的DOM结构
              layer.close(index);
              //向服务端发送删除指令
              asyncXhr2('/crm-web/deleteSurvey.ftl?quesSurveyId='+data.quesSurveyId, '', "POST", 'application/json', function(data){
              	var jsonData =  eval("("+data+")");
        	    	if(jsonData.data){
        	    		alert("删除成功");
	                }else {
	                  	alert('删除失败!');
	                }
        	    });
            });
          } else if(layEvent === 'edit'){
            //layer.msg('编辑操作');
            var index = layer.open({
        		  type: 2,
        		  area: ['700px', '350px'],
        		  fixed: false, //不固定
        		  maxmin: true,
        		  content: '/crm-web/getQuesSurvey.ftl?quesSurveyId=' + data.quesSurveyId
        	});
            layer.full(index);
          }else if(layEvent === 'detail'){
        	  alert("detail");
          }else if(layEvent === 'download'){
        	  sync('/crm-web/exportExcel.ftl?quesSurveyId='+data.quesSurveyId, '', "POST");
        	  window.open('/crm-web/exportExcel.ftl?quesSurveyId='+data.quesSurveyId);
          }else if(layEvent === 'datareport'){
        	  //sync('/crm-web/getDataMapFtl.ftl?quesSurveyId='+data.quesSurveyId, '', "GET");
        	  var index = layer.open({
        		  type: 2,
        		  area: ['700px', '350px'],
        		  fixed: false, //不固定
        		  maxmin: true,
        		  content: '/crm-web/getDataMapFtl.ftl?quesSurveyId=' + data.quesSurveyId
        	});
            layer.full(index);
          }
        });

      
        $('#btn-add').on('click', function () {
        	var index = layer.open({
        		  type: 2,
        		  area: ['700px', '450px'],
        		  fixed: false, //不固定
        		  maxmin: true, 
        		  content: '/crm-web/getQuesSurvey.ftl'
        	});
        	layer.full(index);
        });
        

        // you code ...

    });
</script>
<!-- 表格操作按钮集 -->
<script type="text/html" id="barOption">
    <!--<a class="layui-btn layui-btn-mini" lay-event="detail">查看</a>-->
	<a class="layui-btn layui-btn-mini layui-btn-normal" id="ques_type_id_add" lay-event="add">添加题目大类</a>
    <a class="layui-btn layui-btn-mini layui-btn-normal" id="ques_survey_id_edit" lay-event="edit">编辑</a>
    <a class="layui-btn layui-btn-mini layui-btn-danger" id="ques_survey_id_del" lay-event="del">删除</a>
	<a class="layui-btn layui-btn-mini" lay-event="share">分享链接</a>
	<a class="layui-btn layui-btn-mini" lay-event="download">下载数据</a>
	<a class="layui-btn layui-btn-mini" lay-event="datareport">查看报表</a>
</script>
</body>
</html>