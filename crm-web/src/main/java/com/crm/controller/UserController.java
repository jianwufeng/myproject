package com.crm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.crm.service.IUserService;

@Controller
@RequestMapping("user")
public class UserController {
    @Autowired
    private IUserService userService;

    @ResponseBody
    @RequestMapping(value = "test", method = RequestMethod.GET)
    public String getUser() {
        return userService.getUserName(115);
    }
}
