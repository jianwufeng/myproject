package com.crm.user.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.crm.domain.crm.User;
import com.crm.service.IUserService;
import com.crm.util.excel.ExcelUtils;

@Description("user查看文档")
@Controller
@RequestMapping("user")
public class UserController {
    @Autowired
    private IUserService userService;

    @ResponseBody
    @RequestMapping(value = "getUser", method = RequestMethod.GET)
    public String getUser(HttpServletRequest request, HttpServletResponse response) {
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

}
