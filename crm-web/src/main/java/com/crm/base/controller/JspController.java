package com.crm.base.controller;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

//import com.crm.base.controller.dto.ClassInfoItem;
//import com.crm.base.controller.dto.MethodInfoItem;
//import com.crm.base.controller.dto.MethodParam;
//import com.crm.util.ClassUtil;
import com.hunteron.api.interfaces.bean.AppInterfaceBean;
import com.hunteron.api.interfaces.bean.AppInterfaceView;
import com.hunteron.api.interfaces.bean.Platform;
import com.hunteron.api.interfaces.bean.ReqMethod;
import com.hunteron.api.interfaces.exception.InterfaceException;
import com.hunteron.api.interfaces.remote.IInterfaceRemoteService;
import com.hunteron.core.model.ClassInfoItem;
import com.hunteron.core.model.MethodInfoItem;
import com.hunteron.core.model.MethodParam;
import com.hunteron.core.util.CollectionUtils;
import com.hunteron.core.util.JsonUtil;
import com.hunteron.core.util.StringUtils;
import com.hunteron.core.utils.ClassUtil;
import com.hunteron.core.web.response.JsonResult;
import com.hunteron.interfaces.model.AppInterface;
import com.hunteron.interfaces.model.AppInterfacePara;

/**
 * CRM项目接口查看
 *
 */
@Description("CRM项目接口查看")
@Controller
@RequestMapping("crm/api")
public class JspController {

    Logger logger = LoggerFactory.getLogger(JspController.class);

    @Autowired
    private IInterfaceRemoteService interfaceRemoteService;

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

    @Description("登录测试接口")
    @RequestMapping(value = "auth")
    public ModelAndView thirdpartyAuth(HttpServletRequest request, HttpServletResponse response,
            @RequestParam(value = "code", required = false, defaultValue = "Sorry!") String code,
            @RequestParam(value = "state", required = false, defaultValue = "Sorry!") String state) {
        return new ModelAndView("login").addObject("code", code + "****state=" + state);
    }

    @ResponseBody
    @Description("查看所有控制层类")
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

    @ResponseBody
    @Description("查看指定控制器暴露的接口")
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

                if (CollectionUtils.isNotEmpty(methodList)) {
                    List<AppInterfaceView> interfaceList = interfaceRemoteService.getAppInterfaceInfosList(Platform.CRM_WEB, className);
                    this.combineInterfaceInfo(interfaceList, methodList);
                }

            } catch (ClassNotFoundException e) {
                return JsonResult.getResult(null);
            }
        }
        return JsonResult.getResult(methodList);
    }

    private void combineInterfaceInfo(List<AppInterfaceView> interfaceList, List<MethodInfoItem> methodList) {
        if (CollectionUtils.isNotEmpty(interfaceList) && CollectionUtils.isNotEmpty(methodList)) {
            for (AppInterfaceView interfaceView : interfaceList) {
                AppInterface appInterface = interfaceView.getAppInterface();
                List<AppInterfacePara> interfaceParas = interfaceView.getInterfaceParaList();

                MethodInfoItem method = this.getMethodByReqUrl(methodList, appInterface.getReqUrl());
                if (method != null) {
                    method.setReqResult(appInterface.getReqResult());
                    List<MethodParam> methodParams = method.getMethodParams();
                    if (CollectionUtils.isNotEmpty(methodParams)) {
                        for (MethodParam param : methodParams) {
                            AppInterfacePara para = this.getInterfaceParaByParaName(interfaceParas, param.getValue());
                            if (para != null) {
                                param.setRemark(para.getRemark());
                            }
                        }
                    }
                }
            }
        }
    }

    private AppInterfacePara getInterfaceParaByParaName(List<AppInterfacePara> interfaceParas, String paraName) {
        AppInterfacePara para = null;
        if (StringUtils.isNotEmpty(paraName) && CollectionUtils.isNotEmpty(interfaceParas)) {
            for (AppInterfacePara item : interfaceParas) {
                if (paraName.equals(item.getParaName())) {
                    para = item;
                    break;
                }
            }
        }
        return para;
    }

    private MethodInfoItem getMethodByReqUrl(List<MethodInfoItem> methodList, String reqUrl) {
        MethodInfoItem method = null;
        if (StringUtils.isNotEmpty(reqUrl) && CollectionUtils.isNotEmpty(methodList)) {
            for (MethodInfoItem item : methodList) {
                if (reqUrl.equals(item.getRequestMapping())) {
                    method = item;
                    break;
                }
            }
        }
        return method;
    }

    @ResponseBody
    @Description("保存接口信息")
    @RequestMapping(value = "saveAppInterface", method = RequestMethod.POST)
    public JsonResult saveAppInterface(HttpServletRequest request, HttpServletResponse response,
            @RequestParam(value = "modalName", required = true) String modalName, @RequestParam(value = "controller", required = true) String controller,
            @RequestParam(value = "description", required = true) String description, @RequestParam(value = "reqUrl", required = true) String reqUrl,
            @RequestParam(value = "reqMethod", required = false, defaultValue = "0") int reqMethod,
            @RequestParam(value = "isDeprecated", required = false, defaultValue = "0") int isDeprecated,
            @RequestParam(value = "reqResult", required = false) String reqResult,
            @RequestParam(value = "sortNo", required = false, defaultValue = "0") Integer sortNo,
            @RequestParam(value = "interfaceParas", required = false) String interfaceParas) throws InterfaceException {

        ReqMethod method = ReqMethod.valueOf(reqMethod);
        if (method == null) {
            throw new InterfaceException(InterfaceException.ILLEGAL_OPERATION);
        }

        AppInterfaceBean interfaceModal = new AppInterfaceBean();
        interfaceModal.setPlatform(Platform.CRM_WEB);
        interfaceModal.setModalName(modalName);
        interfaceModal.setController(controller);
        interfaceModal.setDescription(description);
        interfaceModal.setReqUrl(reqUrl);
        interfaceModal.setReqMethod(method);
        interfaceModal.setIsDeprecated(isDeprecated);
        try {
            interfaceModal.setReqResult(URLDecoder.decode(reqResult, "UTF-8"));
        } catch (UnsupportedEncodingException e1) {
            interfaceModal.setReqResult(reqResult);
        }
        interfaceModal.setSortNo(sortNo);

        List<AppInterfacePara> interfaceParaList = JsonUtil.toList(interfaceParas, List.class, AppInterfacePara.class);
        // 转义解码
        if (CollectionUtils.isNotEmpty(interfaceParaList)) {
            for (AppInterfacePara para : interfaceParaList) {
                try {
                    para.setDefaultValue(URLDecoder.decode(para.getDefaultValue(), "UTF-8"));
                    para.setRemark(URLDecoder.decode(para.getRemark(), "UTF-8"));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
        }
        interfaceModal.setInterfaceParas(interfaceParaList);

        long interfaceId = interfaceRemoteService.saveAppInterface(interfaceModal);
        logger.info("interfaceId is {}", interfaceId);

        return JsonResult.getResult(true);
    }

}
