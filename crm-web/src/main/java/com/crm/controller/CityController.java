package com.crm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.crm.domain.CityDO;
import com.crm.service.CityService;

@Controller
@RequestMapping("city")
public class CityController {
    @Autowired
    private CityService cityService;

    @RequestMapping("test")
    public ModelAndView test() {
        ModelAndView modelAndView = new ModelAndView();
        CityDO cityDO = cityService.selectById(1L);

        modelAndView.setViewName("aaa");
        return modelAndView;
    }
}