package com.crm.shiro.filter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.web.filter.PathMatchingFilter;
import org.springframework.beans.factory.annotation.Autowired;

import com.crm.constants.BackendConstant;
import com.crm.domain.user.UserDO;
import com.crm.service.IUserService;

/**
 * 
 * <pre>
 * 
 * </pre>
 *
 * @author yuwenjie
 * @version $Id: SysUserFilter.java, v 0.1 2014年12月30日 下午8:13:43 yuwenjie Exp $
 */
public class SysUserFilter extends PathMatchingFilter {

    @Autowired
    private IUserService userService;

    @Override
    protected boolean onPreHandle(ServletRequest req, ServletResponse resp, Object mappedValue) throws Exception {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        UserDO user = (UserDO) SecurityUtils.getSubject().getPrincipal();
        if (null == user) { // 未登录
            if (request.getHeader("x-requested-with") != null && request.getHeader("x-requested-with").equalsIgnoreCase("XMLHttpRequest")) { // 如果是ajax请求响应头会有，x-requested-with
                response.setContentType("text/html;charset=utf-8");
                // response.setHeader("errorCode", ErrorCode.USER_UN_LOGIN.code.toString());
                // response.addHeader("errorMessage", ErrorCode.USER_UN_LOGIN.value);
                // response.addHeader("returnUrl", UriConstant.USER.SPACE + "/toLogin");
            } else {
                request.getSession().setAttribute("returnUrl", request.getRequestURI());
                // response.sendRedirect(UriConstant.USER.SPACE + "/toLogin");
            }
            return false;
        } else
            request.setAttribute(BackendConstant.SessionKey.USER, user);

        return true;
    }
}
