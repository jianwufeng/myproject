package com.crm.user.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.crm.domain.crm.User;
import com.crm.service.IUserService;
import com.crm.util.excel.ExcelUtils;
import com.hunteron.api.user.remote.v2.IUserRemoteService;

@Description("user查看文档")
@Controller
@RequestMapping("user")
public class UserController {
    @Autowired
    private IUserService userService;
    @Autowired
    private IUserRemoteService userRemoteService;

    @ResponseBody
    @RequestMapping(value = "getUserName", method = RequestMethod.GET)
    public String getUserName(HttpServletRequest request, HttpServletResponse response) {
        return userService.getUserName(115);
    }

    @ResponseBody
    @RequestMapping(value = "exportExcel", method = RequestMethod.GET)
    public String exportExcel(HttpServletResponse response) {
        String arr[] = {};
        List<User> userList = userService.getAll(0, 10);
        try {
            ExcelUtils.export(response, arr, userList, User.class);
        } catch (IllegalArgumentException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return "success";
    }

    @ResponseBody
    @RequestMapping(value = "getUserList", method = RequestMethod.GET)
    public List<User> getUserList(HttpServletRequest request, HttpServletResponse response) {
        return userService.selectByCondition(0, 1);
    }

    @ResponseBody
    @RequestMapping(value = "getLastLoginTime", method = RequestMethod.GET)
    public Date getLastLoginTime(HttpServletRequest request, HttpServletResponse response) {
        return userRemoteService.getLastLoginTime(103L);
    }

    @ResponseBody
    @RequestMapping(value = "importExcel", method = RequestMethod.GET)
    public String importExcel(HttpServletRequest request, HttpServletResponse response, MultipartFile excel) {
        try {
            ExcelUtils.readExcelContent(excel, User.class, 0, "导入");
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
        return "success";
    }
}
