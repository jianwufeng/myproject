package com.crm.base.controller.dto;

import org.springframework.context.annotation.Description;
import org.springframework.web.bind.annotation.RequestMapping;

public class ClassInfoItem {

    private String name;
    private String simpleName;
    private String description;
    private String requestMapping;

    public ClassInfoItem(Class<?> clazz) {
        if (clazz != null) {
            this.name = clazz.getName();
            this.simpleName = clazz.getSimpleName();
            // 类的描述
            Description description = clazz.getAnnotation(Description.class);
            if (description != null) {
                this.description = description.value();
            }
            // 类的RequestMapping
            RequestMapping requestMapping = clazz.getAnnotation(RequestMapping.class);
            if (requestMapping != null) {
                String[] mappings = requestMapping.value();
                if (mappings.length > 0) {
                    this.requestMapping = mappings[0];
                }
            }
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSimpleName() {
        return simpleName;
    }

    public void setSimpleName(String simpleName) {
        this.simpleName = simpleName;
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

}
