// 扩展JQuery方法
$.fn.autoHeight = function(){
	$.each(this,function(idx, obj){
		if (obj.tagName == "TEXTAREA") {
			$(obj).css("height", obj.scrollHeight);
		}
	});
}

var common = {
	currentInterfaceId : "",
	currentModalName : "",
	currentClassName : ""
};

// 组织接口页面
common.getControllerApi = function(obj) {
	$("#menuList ul li").css("color", "black");
	$(obj).css("color", "#0011ff");
	common.currentModalName = $(obj).get(0).innerText;
	common.currentClassName = $(obj).attr("className");
	var url = "./controllerInterfaces?className=" + common.currentClassName;
	$.ajax({url : url, type : 'GET',
		success : function(rs) {
			if (rs != null && rs.success) {
				var html = "";
				if (rs.data != null && rs.data.length > 0) {
					$.each(rs.data, function(idx, method) {
						var desc = method.description == null ? method.name : method.description;
						var reqResult = method.reqResult == null ? "" : method.reqResult;
						var idxTmp = idx+1;
						desc += method.isDeprecated ? "【<span style='color:red'>Deprecated</span>】" : "";
						html += "<h3>" + idxTmp + "、<span id='interface"+idxTmp+"desc'>" + desc + "</span></h3>";
						if ("POST" == method.reqMethod.toUpperCase()) {
							html += "<h3>请求URL:<span id='interface"+idxTmp+"' class='btn-url post-url' title='测试一下'>http://~/" + method.requestMapping + "</span>";
							html += "【<span id='interface"+idxTmp+"method'>" + method.reqMethod + "</span>】<span class='btn-url btn-save' id='interface"+idxTmp+"save' title='保存当前接口'>保存</span></h3>";
						} else {
							html += "<h3>请求URL:<span id='interface"+idxTmp+"' class='btn-url get-url' title='测试一下'>http://~/" + method.requestMapping + "</span>";
							html += "【<span id='interface"+idxTmp+"method'>" + method.reqMethod + "</span>】<span class='btn-url btn-save' id='interface"+idxTmp+"save' title='保存当前接口'>保存</span></h3>";
						}
						html += "<table><tr style='text-align:center; background-color:#eeeeee'>";
						html += "<td style='width: 195px'>参数名</td>";
						html += "<td style='width: 80px'>是否必输</td>";
						html += "<td style='width: 155px'>参数类型</td>";
						html += "<td style='width: 140px'>默认值</td>";
						html += "<td style='width: 168px'>备　注</td></tr>";
						if (method.methodParams != null && method.methodParams.length > 0) {
							$.each(method.methodParams, function(index, methodParam) {
								var defaultValue = (methodParam.defaultValue == null ? " " : methodParam.defaultValue);
								var remark = (methodParam.remark == null ? "" : methodParam.remark);
								html += "<tr><td id='interface"+idxTmp+"para"+index+"'>" + methodParam.value + "</td><td>" + methodParam.required + "</td>";
								html += "<td>" + methodParam.type + "</td>";
								html += "<td>" + defaultValue + "</td><input id='interface"+idxTmp+"para"+index+"testvalue' type='hidden' value='" + defaultValue + "'>";
								html += "<td><input id='interface"+idxTmp+"para"+index+"remark' type='text' style='border:0' value='" + remark.replace("'","") + "'></td></tr>";
							});
						} else {
							html += "<tr><td colspan='5' style='text-align:center'>无</td></tr>";
						}

						html += "</tr></table>";
						if ("" == reqResult) {
							html += "<div style='display:none'><h3>接口输出</h3>";
						} else {
							html += "<div><h3>接口输出</h3>";
						}
						html += "<div style='text-align:center'><textarea id='interface"+idxTmp+"result' style='width:750px;min-height: 100px;max-height:300px'>"+reqResult+"</textarea></div></div>";
					});
				} else {
					html = "该业务模块下无API接口";
				}
				$("#htmlArea").html(html); // 初始化页面
				$("textarea").autoHeight();
				$(".post-url").hDialog({
					title: 'Post接口测试页面',
					box: '#testModal',
					width: 700,
					height:600,
					modalHide: false,
					beforeShow: function(){ common.initPostModal(this); },
					afterHide: function(){ common.confirmSaveResult(); }
				});
				$(".get-url").hDialog({
					title: 'Get接口测试页面',
					box: '#testModal',
					width: 700,
					height:600,
					modalHide: false,
					beforeShow: function(){ common.initGetModal(this); },
					afterHide: function(){ common.confirmSaveResult(); }
				});
				$(".btn-save").on("click", function(){
					var interfaceId = $(this).attr("id").replace("save", "");
					// 组织接口信息
					var desc = $("#"+interfaceId+"desc")[0].innerText;
					var reqUrl = $("#"+interfaceId)[0].innerText.replace("http://~/", "");
					var method = $("#"+interfaceId+"method")[0].innerText == "GET" ? 0 : 1;
					var result = $("#"+interfaceId+"result").val();
					// 组织参数信息
					var paraListJson = "[";
					$.each($("td[id^='"+interfaceId+"para']"), function(idx, paraTd) {
						var paraName = $("#"+paraTd.id).get(0).innerText;
						var required = paraTd.nextSibling.innerText == "true" ? 1 : 0;
						var paraType = paraTd.nextSibling.nextSibling.innerText;
						var defaultValue = paraTd.nextSibling.nextSibling.nextSibling.innerText;
						var remark = $("#"+paraTd.id + "remark").val();
						if(idx > 0) {
							paraListJson += ",";
						}
						paraListJson = paraListJson + "{\"paraName\":\""+paraName+"\",\"isRequired\":\""+required+"\",\"paraType\":\""+paraType+"\",";
						paraListJson = paraListJson + "\"defaultValue\":\""+encodeURIComponent(encodeURIComponent(defaultValue))+"\",\"remark\":\""+encodeURIComponent(encodeURIComponent(remark))+"\"}";
					});
					paraListJson += "]";
					var reqPara = "modalName="+common.currentModalName+"&controller="+common.currentClassName+"&description="+desc;
					reqPara = reqPara +"&reqUrl="+reqUrl+"&reqMethod="+method+"&interfaceParas="+paraListJson+"&reqResult="+encodeURIComponent(encodeURIComponent(result));
					$.ajax({
			            url: "saveAppInterface",
			            type: "post", //(post或get),jquery默认为get
			            data: reqPara, //发送到服务器上的数据，如果不是字符串格式则自动转为字符串格式，get方法则附在html请求地址后面。
			            dataType: "json", //可为:html、script、text、xml、json、jsonp ，jsonp回调函数名的参数名(默认为:callback)
			            timeout: 30000, // 限定异步请求30秒超时
			            success: function (result) {
			            	$.tooltip('保存成功!', 800, true);
			            },
			            error:  function(result) {
			            	window.console.log(JSON.stringify(result));
			            	$.tooltip('保存失败!');
			            }
			        });
				});
			}
		}
	});
};

common.confirmSaveResult = function() {
	$reqResult = $("#reqResult");
	if ($reqResult != undefined && $reqResult.val() != "") {
		$.confirm({
			title: '提示!',
		    content: '保留请求结果吗？',
		    confirm: function() {
		    	$("#"+common.currentInterfaceId+"result").parent().parent().show();
	    		$("#"+common.currentInterfaceId+"result").val($reqResult.val()).autoHeight();
		    }
		});
	}
}

// 打开Post接口测试页面
common.initPostModal = function(obj) {
	$obj = $(obj)[0];
	var thisId = $obj.id;
	common.currentInterfaceId = thisId;
	var requestUrl = $obj.innerText.replace("http://~/", $("#contextPath").val());
	var getHtml = "<div class='request-container'><div id='request-url-container'><input type='text' name='url' id='url' class='keyvalueeditor' placeholder='Enter request URL here' value='"+requestUrl+"?testUserId=41868'></div>";
	getHtml = getHtml +"<div id='url-keyvaleditor' class='keyvaleditor'>";
	$.each($("td[id^='"+thisId+"para']"), function(idx, paraTd) {
		var testValue = $("#"+paraTd.id + "testvalue").get(0).value;
		testValue = (" " == testValue) ? "" : testValue;
		var required = paraTd.nextSibling.innerText;
		getHtml = getHtml + "<div class='keyvalueeditor-row'><input type='text' class='keyvalueeditor keyvalueeditor-key' placeholder='URL Parameter Key' name='keyvalueeditor-"+paraTd.textContent+"' value='"+paraTd.textContent+"'>";
		getHtml = getHtml + "<input type='text' class='keyvalueeditor keyvalueeditor-value' placeholder='Value' name='keyvalueeditor-"+testValue+"' value='"+testValue+"'>";
		getHtml = getHtml + "<a tabindex='"+idx+"' class='keyvalueeditor-delete'><img class='deleteButton' src='../../res/img/delete.png'></a>";
		if ("true" == required) {
			getHtml = getHtml + "<span style='color:red;padding-left:10px;'>*</span></div>";
		} else {
			getHtml = getHtml + "</div>";
		}
	});
	getHtml = getHtml + "<div class='keyvalueeditor-row keyvalueeditor-last'><input type='text' class='keyvalueeditor keyvalueeditor-key' placeholder='URL Parameter Key' name='keyvalueeditor-key' value=''>";
	getHtml = getHtml + "<input type='text' class='keyvalueeditor keyvalueeditor-value' placeholder='Value' name='keyvalueeditor-value' value=''></div></div>";
	getHtml = getHtml + "<div id='request-actions' class='clearfix keyvaleditor'>";
	getHtml = getHtml + "<button class='btn btn-primary' data-loading-text='Fetching data...' type='button' data-complete-text='Send request' id='submit-request'>Send</button>";
	getHtml = getHtml + "<button class='btn btn-danger' id='para-reset'>Reset</button></div>";
	getHtml = getHtml + "<div class='keyvaleditor'><textarea id='reqResult'></textarea></div></div>";
	$("#testModal").html(getHtml);
	
	common.bindPostClickEvent();
	// Send
	$("#submit-request").on("click", function(){
		$url = $('#url');
		var url = $url.val();
		if (url==undefined || url.trim() == "") {
			$.tooltip('请先维护 request url!');
			$url.focus();
			return;
		}
		var reqPara = "";
		$.each($(".keyvalueeditor-key"), function(idx, $key) {
			var $value = $key.nextSibling;
			if ($key.value != "") {
				reqPara = reqPara + "&" + $key.value + "=" + $value.value;
			}
		});
		$.ajax({
            url: url,
            type: "post", //(post或get),jquery默认为get
            cache: false, // 不记录缓存
            async: true, // 异步请求
            data: reqPara, //发送到服务器上的数据，如果不是字符串格式则自动转为字符串格式，get方法则附在html请求地址后面。
            dataType: "json", //可为:html、script、text、xml、json、jsonp ，jsonp回调函数名的参数名(默认为:callback)
            context: document.body,
            timeout: 30000, // 限定异步请求30秒超时
            success: function (result) {
            	$('#reqResult').val(vkbeautify.json(JSON.stringify(result), 4));
            },
            error:  function(result) {
            	$('#reqResult').html(vkbeautify.json(JSON.stringify(result), 4));
            }
        });
	});
	// Reset
	$("#para-reset").on("click", function(){
		$(".keyvalueeditor-value").val("");
	});
}

// 打开Get接口测试页面
common.initGetModal = function(obj) {
	$obj = $(obj)[0];
	var thisId = $obj.id;
	common.currentInterfaceId = thisId;
	var requestUrl = $obj.innerText.replace("http://~/", $("#contextPath").val());
	var getHtml = "<div class='request-container'><div id='request-url-container'><input type='text' name='url' id='url' class='keyvalueeditor' placeholder='Enter request URL here' value='"+requestUrl+"?testUserId=41868'></div>";
	getHtml = getHtml +"<div id='url-keyvaleditor' class='keyvaleditor'>";
	$.each($("td[id^='"+thisId+"para']"), function(idx, paraTd) {
		var testValue = $("#"+paraTd.id + "testvalue").get(0).value;
		testValue = (" " == testValue) ? "" : testValue;
		var required = paraTd.nextSibling.innerText;
		getHtml = getHtml + "<div class='keyvalueeditor-row'><input type='text' class='keyvalueeditor keyvalueeditor-key' placeholder='URL Parameter Key' name='keyvalueeditor-"+paraTd.textContent+"' value='"+paraTd.textContent+"'>";
		getHtml = getHtml + "<input type='text' class='keyvalueeditor keyvalueeditor-value' placeholder='Value' name='keyvalueeditor-"+testValue+"' value='"+testValue+"'>";
		getHtml = getHtml + "<a tabindex='"+idx+"' class='keyvalueeditor-delete'><img class='deleteButton' src='../../res/img/delete.png'></a>";
		if ("true" == required) {
			getHtml = getHtml + "<span style='color:red;padding-left:10px;'>*</span></div>";
		} else {
			getHtml = getHtml + "</div>";
		}
	});
	getHtml = getHtml + "<div class='keyvalueeditor-row keyvalueeditor-last'><input type='text' class='keyvalueeditor keyvalueeditor-key' placeholder='URL Parameter Key' name='keyvalueeditor-key' value=''>";
	getHtml = getHtml + "<input type='text' class='keyvalueeditor keyvalueeditor-value' placeholder='Value' name='keyvalueeditor-value' value=''></div></div>";
	getHtml = getHtml + "<div id='request-actions' class='clearfix keyvaleditor'>";
	getHtml = getHtml + "<button class='btn btn-primary' data-loading-text='Fetching data...' type='button' data-complete-text='Send request' id='submit-request'>Send</button>";
	getHtml = getHtml + "<button class='btn btn-danger' id='para-reset'>Reset</button></div>";
	getHtml = getHtml + "<div class='keyvaleditor'><textarea id='reqResult'></textarea></div></div>";
	$("#testModal").html(getHtml);
	
	common.bindGetClickEvent();
	// Send
	$("#submit-request").on("click", function(){
		$url = $('#url');
		var url = $url.val();
		if (url==undefined || url.trim() == "") {
			$.tooltip('请先维护 request url!');
			$url.focus();
			return;
		}
		var reqPara = "";
		$.each($(".keyvalueeditor-key"), function(idx, $key) {
			var $value = $key.nextSibling;
			if ($key.value != "") {
				reqPara = reqPara + "&" + $key.value + "=" + $value.value;
			}
		});
		var reqUrl = url;
		if (reqPara != "") {
			if (url.indexOf("?")>0) {
				reqUrl = url + reqPara;
			} else {
				reqUrl = url + "?" + reqPara.substring(1);
			}
		}
		window.console.log(reqUrl);
		$.ajax({
			url : reqUrl,
			success : function(result){
				$('#reqResult').val(vkbeautify.json(JSON.stringify(result), 4));
			},
			error : function(result) {
				$('#reqResult').val(vkbeautify.json(JSON.stringify(result), 4));
			}
		});
	});
	// Reset
	$("#para-reset").on("click", function(){
		$(".keyvalueeditor-value").val("");
	});
}
// 绑定Post测试相关事件
common.bindPostClickEvent = function() {
	$(".keyvalueeditor-last").on("click", function(){
		$(".keyvalueeditor-last").unbind("click").removeClass("keyvalueeditor-last");
		var idx = $(".keyvalueeditor-row").length - 1;
		$(this).append("<a tabindex='"+idx+"' class='keyvalueeditor-delete'><img class='deleteButton' src='../../res/img/delete.png'></a>");
		$("#url-keyvaleditor").append("<div class='keyvalueeditor-row keyvalueeditor-last'><input type='text' class='keyvalueeditor keyvalueeditor-key' placeholder='URL Parameter Key' name='keyvalueeditor-key' value=''>"
				+"<input type='text' class='keyvalueeditor keyvalueeditor-value' placeholder='Value' name='keyvalueeditor-value' value=''></div>");
		common.bindPostClickEvent();
	});
	$(".keyvalueeditor-delete").on("click", function(){
		$(this).unbind("click");
		$(this).parent().remove();
	});
}
//绑定Get测试相关事件
common.bindGetClickEvent = function() {
	$(".keyvalueeditor-last").on("click", function(){
		$(".keyvalueeditor-last").unbind("click").removeClass("keyvalueeditor-last");
		var idx = $(".keyvalueeditor-row").length - 1;
		$(this).append("<a tabindex='"+idx+"' class='keyvalueeditor-delete'><img class='deleteButton' src='../../res/img/delete.png'></a>");
		$("#url-keyvaleditor").append("<div class='keyvalueeditor-row keyvalueeditor-last'><input type='text' class='keyvalueeditor keyvalueeditor-key' placeholder='URL Parameter Key' name='keyvalueeditor-key' value=''>"
				+"<input type='text' class='keyvalueeditor keyvalueeditor-value' placeholder='Value' name='keyvalueeditor-value' value=''></div>");
		common.bindGetClickEvent();
	});
	$(".keyvalueeditor-delete").on("click", function(){
		$(this).unbind("click");
		$(this).parent().remove();
	});
}
