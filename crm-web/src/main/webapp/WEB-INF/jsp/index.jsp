<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page isELIgnored="false"%>
<%@ page import="com.crm.base.controller.dto.ClassInfoItem"%>
<%@ page import="java.util.List"%>
<html>
<%
    String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<head>
<title>HD端API接口文档</title>
<meta http-equiv="pragma" content="no-cache" />
<meta http-equiv="cache-control" content="no-cache" />
<meta http-equiv="expires" content="0" />
<link rel="stylesheet" type="text/css" href="<%=path%>/res/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="<%=path%>/res/css/common.css" />
<link rel="stylesheet" type="text/css" href="<%=path%>/res/css/hDialog.css" />
<link rel="stylesheet" type="text/css" href="<%=path%>/res/css/jquery-confirm.css" />

</head>
<body>
<div class="workArea">
	<div style="text-align: center">
		<h1>HD端API接口文档</h1>
	</div>
	<input id="contextPath" type="hidden" value="<%= basePath %>"/>
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
				<li className="<%=name%>" onclick="common.getControllerApi(this)" title="<%=name%>" class="evenLi"><%=description%></li>
				<%
				            }else {
				%>
				<li className="<%=name%>" onclick="common.getControllerApi(this)" title="<%=name%>" class="oddLi"><%=description%></li>
				<%
				            }
							i++;
				    	}
				    }
				%>
			</ul>
		</div>
	</div>
	<div id="htmlArea" class="grid-r interface-container styleBorder"></div>

	<div id="testModal"> </div>
</div>

<script type="text/javascript" src="<%=path%>/res/js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="<%=path%>/res/js/jquery.hDialog.js"></script>
<script type="text/javascript" src="<%=path%>/res/js/vkbeautify.js"></script>
<script type="text/javascript" src="<%=path%>/res/js/jquery-confirm.js"></script>
<script type="text/javascript" src="<%=path%>/res/js/common.js"></script>

</body>
</html>