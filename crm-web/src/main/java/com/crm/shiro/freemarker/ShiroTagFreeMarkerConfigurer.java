package com.crm.shiro.freemarker;

import java.io.IOException;

import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import freemarker.template.TemplateException;

/**
 * 
 * <pre>
 * 自定义一个ShiroTagFreeMarkerConfigurer继承Spring本身提供的FreeMarkerConfigurer,目的是在FreeMarker的Configuration中添加shiro的配置
 * </pre>
 *
 */
public class ShiroTagFreeMarkerConfigurer extends FreeMarkerConfigurer {

    @Override
    public void afterPropertiesSet() throws IOException, TemplateException {
        super.afterPropertiesSet();
        // this.getConfiguration().setSharedVariable("shiro", new ShiroTags());
    }
}