package com.crm.base.controller.dto;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ValueConstants;

public class MethodParam {

    private String value;
    private Boolean required;
    private String type;
    private String defaultValue;
    private String remark;

    public static List<MethodParam> getParams(Method method) {
        if (method != null) {
            List<MethodParam> paramList = new ArrayList<MethodParam>();
            Class<?>[] types = method.getParameterTypes();
            Annotation[][] annotations = method.getParameterAnnotations();
            int i = 0;
            for (Class<?> type : types) {
                Annotation[] annotation = annotations[i];
                if (annotation != null && annotation.length > 0) {
                    MethodParam methodParam = new MethodParam();
                    RequestParam reqParam = (RequestParam) annotation[0];
                    if (reqParam != null) {
                        methodParam.setValue(reqParam.value());
                        if (!ValueConstants.DEFAULT_NONE.equals(reqParam.defaultValue())) {
                            methodParam.setDefaultValue(reqParam.defaultValue());
                        }
                        methodParam.setRequired(reqParam.required());
                    }
                    methodParam.setType(type.getSimpleName());
                    paramList.add(methodParam);
                }
                i++;
            }
            return paramList;
        }
        return Collections.emptyList();
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Boolean getRequired() {
        return required;
    }

    public void setRequired(Boolean required) {
        this.required = required;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

}
