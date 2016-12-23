package com.crm.interceptor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

@Component
public class InitData {

    public static final List<String> RESOURCE_URLS = new ArrayList<>();

    @PostConstruct
    public void init() {
        RESOURCE_URLS.addAll(Arrays.asList("/user/getUser"));
    }

}
