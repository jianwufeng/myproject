package com.crm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.crm.domain.ho.LoginSource;
import com.crm.service.IUserService;
import com.ho.service.ILoginSourceService;

@Controller
@RequestMapping("loginSource")
public class LoginSourceController {

    @Autowired
    private ILoginSourceService loginSourceService;

    @Autowired
    private IUserService userservice;

    @ResponseBody
    @RequestMapping(value = "getName", method = RequestMethod.GET)
    public String getName(@RequestParam(value = "id", required = true) long id) {
        LoginSource loginSource = loginSourceService.getLoginSource(id);
        Long userId = loginSource.getUserId();
        return userservice.getUserName(userId.intValue());
    }
}
