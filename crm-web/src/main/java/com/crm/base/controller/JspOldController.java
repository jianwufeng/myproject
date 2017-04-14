package com.crm.base.controller;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Description;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.crm.base.controller.dto.ClassInfoItem;
import com.crm.base.controller.dto.JsonResult;
import com.crm.base.controller.dto.MethodInfoItem;
import com.crm.util.ClassUtil;

/**
 * Web项目接口查看
 *
 */
@Description("项目接口查看")
@Controller
@RequestMapping("api")
public class JspOldController {

    @Description("应用API查看首页")
    @RequestMapping(value = "index")
    public ModelAndView apiIndex() {
        List<Class<?>> classes = ClassUtil.getClasses("com.crm", "%Controller");
        List<ClassInfoItem> classList = new ArrayList<ClassInfoItem>();
        if (CollectionUtils.isNotEmpty(classes)) {
            for (Class<?> clazz : classes) {
                classList.add(new ClassInfoItem(clazz));
            }
        }
        return new ModelAndView("index").addObject("classList", classList);
    }

    @Description("查看所有控制层累")
    @ResponseBody
    @RequestMapping(value = "controllerClasses", method = RequestMethod.GET)
    public JsonResult controllerClasses(HttpServletRequest request, HttpServletResponse response) {
        List<Class<?>> classes = ClassUtil.getClasses("com.crm", "%Controller");
        List<ClassInfoItem> classList = new ArrayList<ClassInfoItem>();
        if (CollectionUtils.isNotEmpty(classes)) {
            for (Class<?> clazz : classes) {
                classList.add(new ClassInfoItem(clazz));
            }
        }
        return JsonResult.getResult(classList);
    }

    @Description("查看指定控制器暴露的接口")
    @ResponseBody
    @RequestMapping(value = "controllerInterfaces", method = RequestMethod.GET)
    public JsonResult controllerInterfaces(HttpServletRequest request, HttpServletResponse response,
            @RequestParam(value = "className", required = true) String className) {
        List<MethodInfoItem> methodList = null;

        if (StringUtils.isNotEmpty(className)) {
            try {
                Class<?> clazz = Class.forName(className);
                ClassInfoItem classInfoItem = new ClassInfoItem(clazz);

                Method[] methods = clazz.getMethods();
                methodList = MethodInfoItem.convert2MethodInfoItem(methods, classInfoItem);

            } catch (ClassNotFoundException e) {
                return JsonResult.getResult(null);
            }
        }
        return JsonResult.getResult(methodList);
    }
}
