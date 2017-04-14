<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page isELIgnored="false"%>
<%@ page import="com.crm.base.controller.dto.ClassInfoItem"%>
<%@ page import="java.util.List"%>
<html>
<%
    String path = request.getContextPath();
%>
<head>
<title>CRM-Mobile端API接口文档</title>
<meta http-equiv="pragma" content="no-cache" />
<meta http-equiv="cache-control" content="no-cache" />
<meta http-equiv="expires" content="0" />
<script type="text/javascript" src="<%=path%>/js/jquery-1.9.1.min.js"></script>
<script type="text/javascript">
	function getControllerApi(obj) {
		$("#menuList ul li").css("color", "black");
		$(obj).css("color", "#0011ff");
		var className = $(obj).attr("className");
		var url = "./controllerInterfaces?className=" + className;
		$.ajax({url : url, type : 'GET', datatype: "json",
			success : function(rs) {
				rs = eval('(' + rs + ')');
				if (rs != null && rs.success) {
					var html = "";
					if (rs.data != null && rs.data.length > 0) {
						$.each(rs.data, function(idx, method) {
							var desc = method.description == null ? method.name : method.description;
							desc += method.isDeprecated ? "【<span style='color:red'>Declared</span>】" : "";
							html += "<h3>" + (idx+1) + "、" + desc + "</h3>";
							html += "<h3>请求URL:<span style='color:blue'>http://~/" + method.requestMapping + "</span>【" + method.reqMethod + "】</h3>";
							html += "<table><tr style='text-align:center; background-color:#eeeeee'>";
							html += "<td style='width: 250px'>参数名</td>";
							html += "<td style='width: 100px'>是否必输</td>";
							html += "<td style='width: 150px'>参数类型</td>";
							html += "<td style='width: 200px'>默认值</td></tr>";
							if (method.methodParams != null && method.methodParams.length > 0) {
								$.each(method.methodParams, function(index, methodParam) {
									html += "<tr><td>" + methodParam.value + "</td><td>" + methodParam.required + "</td>";
									html += "<td>" + methodParam.type + "</td>";
									html += "<td>" + (methodParam.defaultValue == null ? " " : methodParam.defaultValue) + "</td></tr>";
								});
							} else {
								html += "<tr><td colspan='4' style='text-align:center'>无</td></tr>";
							}
	
							html += "</tr></table>";
						});
					} else {
						html = "该业务模块下无API接口";
					}
					$("#htmlArea").html(html);
				}
			}
		});
	}
</script>

<style type="text/css">
div {
	display: block;
	font-size: 14px;
}

table {
	border-collapse: collapse;
	margin-left: auto;
	margin-right: auto;
	line-height: 24px;
}

table tr td {
	border: solid #ccc 1px;
	padding-left: 3px;
}

ul {
	display: block;
	line-height: 24px;
	padding: 0px;
	margin: 5px 0px;
}

li {
	list-style-type: none;
	padding-left: 10px;
}

li:hover {
	color: #0011ff;
	cursor: pointer;
}

.oddLi {
	background-color: #eeeeee;
}

.evenLi {
	
}

.workArea {
	width: 1200px;
	margin-left: auto;
	margin-right: auto;
	position: relative;
}

.grid {
	display: inline;
	float: left;
}

.grid-r {
	display: inline;
	float: right;
}

.menuArea {
	width: 260px;
	display: inline;
	padding-right: 10px;
}

.menuList {
	height: 720px;
	overflow: auto;
}

.container {
	width: 900px;
	height: 700px;
	padding: 10px;
	overflow: auto;
}

.styleBorder {
	border: solid #ccc 1px;
}
</style>

</head>
<body>
	<div class="workArea">
		<div style="text-align: center">
			<h1>CRM端API接口文档</h1>
		</div>
		<div class="grid menuArea">
			<div id="menuList" class="styleBorder menuList">
				<ul>
					<%
					    List<ClassInfoItem> classList = (List<ClassInfoItem>) request.getAttribute("classList");
					    if (classList != null && classList.size() > 0) {
					        int i = 0;
					        for (ClassInfoItem clazz : classList) {
					            
					            String name = clazz.getName();
					            String description = clazz.getDescription() == null ? clazz.getSimpleName() : clazz.getDescription();
					            if (i%2 == 0) {
					%>
					<li className="<%=name%>" onclick="getControllerApi(this)" title="<%=name%>" class="evenLi"><%=description%></li>
					<%
					            }else {
					%>
					<li className="<%=name%>" onclick="getControllerApi(this)" title="<%=name%>" class="oddLi"><%=description%></li>
					<%
					            }
								i++;
					    	}
					    }
					%>
				</ul>
			</div>
		</div>
		<div id="htmlArea" class="grid-r container styleBorder"></div>
	</div>
</body>
</html>