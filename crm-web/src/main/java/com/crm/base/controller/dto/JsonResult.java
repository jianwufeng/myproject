package com.crm.base.controller.dto;

import java.util.Locale;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class JsonResult {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    public final static JsonResult ERROR_RESULT = new JsonResult(false);

    private boolean success = true;
    private String errCode;
    private String message;
    private Object data;

    public static JsonResult getResult(Object data) {
        JsonResult jsonResult = new JsonResult();
        jsonResult.setData(data);
        return jsonResult;
    }

    public static JsonResult error(String errorCode, MessageSource messageSource, Object... params) {
        JsonResult jsonResult = new JsonResult();
        jsonResult.setSuccess(false);
        jsonResult.setErrCode(errorCode);
        jsonResult.setMessage(messageSource.getMessage(errorCode, params, errorCode, Locale.SIMPLIFIED_CHINESE));
        return jsonResult;
    }

    public static JsonResult errorData(String errorCode, MessageSource messageSource, Object data, Object... params) {
        JsonResult jsonResult = new JsonResult();
        jsonResult.setSuccess(false);
        jsonResult.setErrCode(errorCode);
        jsonResult.setMessage(messageSource.getMessage(errorCode, params, errorCode, Locale.SIMPLIFIED_CHINESE));
        jsonResult.setData(data);
        return jsonResult;
    }

    public JsonResult() {
        super();
    }

    public JsonResult(boolean success) {
        super();
        this.success = success;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getErrCode() {
        return errCode;
    }

    public void setErrCode(String errCode) {
        this.errCode = errCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String toJson() {
        String json = JsonUtil.toJson(this);
        if (StringUtils.isEmpty(json)) {
            logger.error("JsonResult to Json String error.");
            json = "{\"success\":false,\"errCode\":\"serialize.error\",\"message\":\"serialize.error\",\"data\":\"\"}";
        }
        return json;
    }

    public void setError(String errorCode, MessageSource messageSource, Object... params) {
        this.setSuccess(false);
        this.setErrCode(errorCode);
        this.setMessage(messageSource.getMessage(errorCode, params, errorCode, Locale.SIMPLIFIED_CHINESE));
    }
}
