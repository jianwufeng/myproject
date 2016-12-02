package com.crm.base.controller.dto;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.context.annotation.Description;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class MethodInfoItem {

    private String name;
    private String description;
    private String requestMapping;
    private String reqMethod;
    private Boolean isDeprecated;
    private List<MethodParam> methodParams;

    public MethodInfoItem(Method method, ClassInfoItem classInfoItem) {
        if (method != null) {
            this.name = method.getName(); // 方法名称
            // 判定方法是不是Deprecated的
            Deprecated deprecated = method.getAnnotation(Deprecated.class);
            this.isDeprecated = (deprecated != null) ? true : false;

            // 方法的描述
            Description description = method.getAnnotation(Description.class);
            if (description != null) {
                this.description = description.value();
            }

            // 方法的RequestMapping
            String classReqMapping = classInfoItem.getRequestMapping() == null ? "" : classInfoItem.getRequestMapping();
            if (classReqMapping != null && classReqMapping.endsWith("/")) {
                classReqMapping = classReqMapping.substring(1);
            }
            RequestMapping requestMapping = method.getAnnotation(RequestMapping.class);
            if (requestMapping != null) {
                String[] mappings = requestMapping.value();
                if (mappings.length > 0) {
                    String methodReqMapping = mappings[0];

                    if (!methodReqMapping.startsWith("/")) {
                        methodReqMapping = "/" + methodReqMapping;
                    }

                    this.requestMapping = classReqMapping + methodReqMapping;
                }
                RequestMethod[] reqMethods = requestMapping.method();
                if (reqMethods.length > 0) {
                    RequestMethod reqMethod = reqMethods[0];
                    this.reqMethod = reqMethod == null ? "GET" : reqMethod.name();
                } else {
                    this.reqMethod = "GET";
                }
            } else {
                this.requestMapping = classReqMapping;
                this.reqMethod = "GET";
            }

            // 方法参数处理
            this.methodParams = MethodParam.getParams(method);
        }
    }

    public static List<MethodInfoItem> convert2MethodInfoItem(Method[] methods, ClassInfoItem classInfoItem) {
        if (methods != null && methods.length > 0) {
            List<MethodInfoItem> items = new ArrayList<MethodInfoItem>();
            for (Method method : methods) {
                if (method.getAnnotation(RequestMapping.class) != null) {
                    items.add(new MethodInfoItem(method, classInfoItem));
                }
            }
            return items;
        }
        return Collections.emptyList();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRequestMapping() {
        return requestMapping;
    }

    public void setRequestMapping(String requestMapping) {
        this.requestMapping = requestMapping;
    }

    public String getReqMethod() {
        return reqMethod;
    }

    public void setReqMethod(String reqMethod) {
        this.reqMethod = reqMethod;
    }

    public Boolean getIsDeprecated() {
        return isDeprecated;
    }

    public void setIsDeprecated(Boolean isDeprecated) {
        this.isDeprecated = isDeprecated;
    }

    public List<MethodParam> getMethodParams() {
        return methodParams;
    }

    public void setMethodParams(List<MethodParam> methodParams) {
        this.methodParams = methodParams;
    }

}
