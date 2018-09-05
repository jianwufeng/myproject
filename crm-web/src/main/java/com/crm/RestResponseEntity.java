package com.crm;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.MapUtils;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;
import org.slf4j.LoggerFactory;

import com.crm.common.res.ResultEnum;
import com.crm.common.res.ResultEnumImp;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonSerialize(include = Inclusion.NON_NULL)
public class RestResponseEntity {
    private static org.slf4j.Logger   logger = LoggerFactory.getLogger(RestResponseEntity.class);

    public static Map<String, String> map    = new HashMap<String, String>();

    public static RestResponseEntity getEntityError(String errCode) {
        return new RestResponseEntity(false, errCode, MapUtils.getString(map, errCode, "服务器忙，请稍后再试！"), null);
    }

    /**
     * 接口调用成功，返回
     * 
     * @param data
     */

    private RestResponseEntity(ResultEnum result, Object data) {
        this(result.getSuccess(), result.getErrCode(), result.getMessage(), data);
    }

    private RestResponseEntity(Boolean success, String errCode, String message, Object data) {
        this.success = success;
        this.errCode = errCode;
        this.message = message;
        this.data = data;
        logger.info(toString());
    }

    /**
     * 返回成功
     * 
     * @param data
     */
    @SuppressWarnings("unchecked")
    private RestResponseEntity(Object data) {
        int size = 1;
        ResultEnum result = null;
        if (data == null) {
            result = ResultEnumImp.OK;
        } else {
            if (data.getClass().equals(ResultEnumImp.class)) {
                result = (ResultEnum) data;
            } else {
                result = ResultEnumImp.OK;
                if (data instanceof List) {
                    size = ((List<Object>) data).size();
                }
            }
        }

        this.data = data;
        this.success = result.getSuccess();
        this.errCode = result.getErrCode();
        this.message = result.getMessage();
        logger.info(toString() + ",size:" + size);
    }

    /**
     * 创建实例
     * 
     * @param data
     * @return
     */
    public static RestResponseEntity getEntity(Object data) {
        return new RestResponseEntity(data);
    }

    /**
     * 创建实例
     * 
     * @param result
     * @param data
     * @return
     */
    public static RestResponseEntity getEntity(Boolean success, String errCode, String message, Object data) {
        return new RestResponseEntity(success, errCode, message, data);
    }

    public static RestResponseEntity getEntity(ResultEnum result, Object data) {
        if (result != null) {
            return new RestResponseEntity(result, data);
        }

        return RestResponseEntity.getEntity(data);
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setStatus(Boolean success) {
        this.success = success;
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

    public String getErrCode() {
        return errCode;
    }

    public void setErrCode(String errCode) {
        this.errCode = errCode;
    }

    private Boolean success;
    private String  errCode;
    private String  message;
    private Object  data;

    public String toString() {
        String resData = null;
        if (data != null) {
            resData = data.toString().length() > 1000 ? data.toString().substring(0, 200) + "..." : data.toString();
        }

        String result = "{RestResponseObject:{success:" + success + ",errCode:" + errCode + ",message:" + message + ",data:" + resData + "}}";
        return result;
    }
}
