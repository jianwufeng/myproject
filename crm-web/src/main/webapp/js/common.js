// 302错误处理（未登录用户ajax请求）
$.ajaxSetup({
	statusCode : {
		302 : function() {
			alert('登陆超时，请重新登陆');
		}
	}
});

/**
 * ajax异步调用
 * 
 * @param url
 * @param data
 * @param callback
 *            回调函数
 * @param type
 */
function asyncXhr(url, data, callback, type) {
	var _data, options = {
		url : url,
		data : data,
		type : type,
		async : true,
		success : callback
	};
	$.ajax(options);
}

/**
 * ajax异步调用
 * 
 * @param url
 * @param data
 * @param contentType
 * @param callback
 *            回调函数
 * @param type
 */
function asyncXhr2(url, data, type, contentType, callback) {
	var _data, options = {
		url : url,
		data : data,
		type : type,
		async : true,
		contentType : contentType,
		success : callback
	};
	$.ajax(options);
}

/**
 * ajax异步get调用
 */
function asyncXhrGet(url, data, callback) {
	if (arguments.length == 2) {
		callback = data;
		data=null;
	}
	asyncXhr(url, data, callback, "GET");
}

/**
 * ajax异步post调用
 */
function asyncXhrPost(url, data, callback) {
	if (arguments.length == 2) {
		callback = data;
		data=null;
	}
	asyncXhr(url, data, callback, "POST");
}

/**
 * ajax同步调用
 */
function sync(url, data, type) {
	var _data, options = {
		url : url,
		data : data,
		type : type,
		async : false,
		success : function(rs) {
			_data = rs;
		}
	};
	$.ajax(options);
	return _data;
}

/**
 * ajax同步get调用
 */
function syncGet(url, data) {
	return sync(url, data, "GET");
}

/**
 * ajax同步post调用
 */
function syncPost(url, data) {
	return sync(url, data, "POST");
}

/**
 * 比较日期大小
 */
function compareDate(data1, data2) {
	return Date.parse(data1.replace(/-/g, "/")) > Date.parse(data2.replace(/-/g, "/"));
}

/**
 * 是否空字符串
 */
function isBlank(str) {
	return !(str && $.trim(str).length > 0);
}

function changeTwoDecimal(x){
	return changeDecimal(x, 2);
}

/**
 * 转换为固定位数的小数
 * @param x
 * @returns
 */
function changeDecimal(x,num) {
	var f_x = parseFloat(x);
	if (isNaN(f_x)) {
		alert('function:changeTwoDecimal->parameter error  :'+x);
		return false;
	}
	f_x = Math.round(f_x * 100) / 100;
	var s_x = f_x.toString();
	var pos_decimal = s_x.indexOf('.');
	if (pos_decimal < 0) {
		pos_decimal = s_x.length;
		s_x += '.';
	}
	while (s_x.length <= pos_decimal + num) {
		s_x += '0';
	}
	return s_x;
}

function showMessage(message){
	showDialog("温馨提示", {width:400,height:214}, function(d){
			var $wrap = $("<div class='btnwraper'></div>");
			var contxt = "<div id='del-context'>"+message+"</div>";
			d.append(contxt).append($wrap);
		});
}

/**
 * 获取字符串字节长度，一个汉字占2个字节
 * @param str
 */
function getStrByteLen(str){
	//获得字符串实际长度，中文2，英文1
	if(isBlank(str)){
		return 0;
	}
    var realLength = 0, len = str.length, charCode = -1;
    for (var i = 0; i < len; i++) {
        charCode = str.charCodeAt(i);
        if (charCode >= 0 && charCode <= 128) realLength += 1;
        else realLength += 2;
    }
    return realLength;
}
