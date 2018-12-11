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
<fieldset class="layui-elem-field layui-field-title">
	  <legend>题目满意度</legend>
</fieldset>

<div id="main-line3" style="width: 100%;height:400px;"></div>

<div id="main-line4" style="width: 100%;height:400px;"></div>

<div id="main-bing" style="width: 100%;height:400px;"></div>

<script type="text/javascript" src="./frame/layui/layui.js"></script>
<script type="text/javascript" src="./frame/echarts/echarts.min.js"></script>
<script src="./js/jquery-1.9.1.min.js"></script>
<script src="./js/common.js" charset="utf-8"></script>
<script type="text/javascript">

	asyncXhrGet('/crm-web/getDataMap.ftl?quesSurveyId='+${quesSurveyId}, '', function(data){
  	var jsonData =  eval("("+data+")");
    	if(jsonData.success){
    		/*var data1 = jsonData.data.quesTypeNameAgreeList;
    		var data2 = jsonData.data.quesTypePerAgreeList;
    		setChart1(data1,data2);
    		
    		var data3 = jsonData.data.quesTypeNameDisAgreeList;
    		var data4 = jsonData.data.quesTypePerDisAgreeList;
    		setChart2(data3,data4);*/
    		
    		var data5 = jsonData.data.quesNameAgreeList;
    		var data6 = jsonData.data.quesPerAgreeList;
    		setChart3(data5,data6);
    		
    		var data7 = jsonData.data.quesNameDisAgreeList;
    		var data8 = jsonData.data.quesPerDisAgreeList;
    		setChart4(data7,data8);
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
	            text: '满意度TOP5(%)'
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
	            text: '不满意度TOP5(%)'
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
    
    
    function setChart3(data1,data2){
	    // 基于准备好的dom，初始化echarts实例
	    var myChart = echarts.init(document.getElementById('main-line3'));
	
	    // 使用刚指定的配置项和数据显示图表。
	    myChart.setOption({
	        title: {
	            text: '题目满意度TOP5(%)'
	        },
	        tooltip: {},
	        legend: {
	            data:['题目满意度TOP5']
	        },
	        grid: {
				left: '10%',
				bottom:'50%'
			},
	        xAxis: {
	            data: data1,
	        	axisLabel: {  
                    interval: 0,
                        formatter:function(value)
                        {
                            return formatter(value);
                        }
				}
	        },
	        yAxis: {
	        	//data: ["20","40","60","80","100"]
	        },
	        series: [{
	            name: '题目满意度TOP5',
	            type: 'bar',
	            //data: [20, 40]
	            data: data2
	        }
	        ]
	    });
	}
	
    function setChart4(data1,data2){
	 	// 基于准备好的dom，初始化echarts实例
	    var myChart2 = echarts.init(document.getElementById('main-line4'));
	
	    // 使用刚指定的配置项和数据显示图表。
	    myChart2.setOption({
	        title: {
	            text: '题目不满意度TOP5(%)'
	        },
	        tooltip: {},
	        legend: {
	            data:['题目不满意度TOP5']
	        },
	        
			grid: {
				left: '10%',
				bottom:'50%'
			},
	        xAxis: {
	            data: data1,
	            axisLabel: {  
                    interval: 0,
                        formatter:function(value)
                        {
                            return formatter(value);
                        }
				}
	        },
	        yAxis: {
	        	//data: ["20","40","60","80","100"]
	        },
	        series: [{
	            name: '题目不满意度TOP5',
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
    
    function formatter(value){
    	var ret = "";//拼接加\n返回的类目项
        var maxLength = 8;//每项显示文字个数
        var valLength = value.length;//X轴类目项的文字个数
        var rowN = Math.ceil(valLength / maxLength); //类目项需要换行的行数
        if (rowN > 1)//如果类目项的文字大于3,
        {
            for (var i = 0; i < rowN; i++) {
                var temp = "";//每次截取的字符串
                var start = i * maxLength;//开始截取的位置
                var end = start + maxLength;//结束截取的位置
                //这里也可以加一个是否是最后一行的判断，但是不加也没有影响，那就不加吧
                temp = value.substring(start, end) + "\n";
                ret += temp; //凭借最终的字符串
            }
            return ret;
        }
        else {
            return value;
        }
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