<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>地图插件</title>
    <link rel="stylesheet" href="./frame/layui/css/layui.css">
    <link rel="stylesheet" href="./frame/static/css/style.css">
    <link rel="icon" href="./frame/static/image/code.png">
</head>
<body class="body">

<!-- 为 ECharts 准备一个具备大小（宽高）的 DOM -->
<div id="main-line" style="width: 100%;height:400px;"></div>

<div id="main-line2" style="width: 100%;height:400px;"></div>

<div id="main-bing" style="width: 100%;height:400px;"></div>

<script type="text/javascript" src="./frame/layui/layui.js"></script>
<script type="text/javascript" src="./frame/echarts/echarts.min.js"></script>
<script src="./js/jquery-1.9.1.min.js"></script>
<script src="./js/common.js" charset="utf-8"></script>
<script type="text/javascript">

	asyncXhrGet('/crm-web/getDataMap.ftl?quesSurveyId='+${quesSurveyId}, '', function(data){
  	var jsonData =  eval("("+data+")");
    	if(jsonData.success){
    		var data1 = jsonData.data.quesTypeNameAgreeList;
    		var data2 = jsonData.data.quesTypePerAgreeList;
    		setChart1(data1,data2);
    		
    		var data3 = jsonData.data.quesTypeNameDisAgreeList;
    		var data4 = jsonData.data.quesTypePerDisAgreeList;
    		setChart2(data3,data4);
        }else {
          	alert(jsonData.success);
        }
    });
	
	
	function setChart1(data1,data2){
	    // 基于准备好的dom，初始化echarts实例
	    var myChart = echarts.init(document.getElementById('main-line'));
	
	    // 使用刚指定的配置项和数据显示图表。
	    myChart.setOption({
	        title: {
	            text: '满意度TOP5(百分比)'
	        },
	        tooltip: {},
	        legend: {
	            data:['满意度TOP5']
	        },
	        xAxis: {
	            data: data1
	        },
	        yAxis: {
	        	//data: ["20","40","60","80","100"]
	        },
	        series: [{
	            name: '满意度TOP5',
	            type: 'bar',
	            //data: [20, 40]
	            data: data2
	        }
	        ]
	    });
	}
	
    function setChart2(data1,data2){
	 	// 基于准备好的dom，初始化echarts实例
	    var myChart2 = echarts.init(document.getElementById('main-line2'));
	
	    // 使用刚指定的配置项和数据显示图表。
	    myChart2.setOption({
	        title: {
	            text: '不满意度TOP5(百分比)'
	        },
	        tooltip: {},
	        legend: {
	            data:['不满意度TOP5']
	        },
	        xAxis: {
	            data: data1
	        },
	        yAxis: {
	        	//data: ["20","40","60","80","100"]
	        },
	        series: [{
	            name: '不满意度TOP5',
	            type: 'bar',
	            itemStyle: {
	                normal: {
	                    show: true,//鼠标悬停时显示label数据
	                    color: '#6197fb'
	                }
	            },
	            data: data2
	        }
	        ]
	    },true);
    }

    // 基于准备好的dom，初始化echarts实例
    /*var chart = echarts.init(document.getElementById('main-bing'));

    // 配置
    chart.setOption({
        series : [
            {
                name: '满意度分布',
                type: 'pie',
                radius: '50%',
                data:[
                    {value:400, name:'非常不满意'},
                    {value:335, name:'不满意'},
                    {value:310, name:'一般'},
                    {value:274, name:'满意'},
                    {value:235, name:'非常满意'}
                ]
            }
        ]
    }); */

    layui.use(['element'], function(){
        var element = layui.element
            ,$      = layui.jquery;

        // you code ...
    });
</script>
</body>
</html>