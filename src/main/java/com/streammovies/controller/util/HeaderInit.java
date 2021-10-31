package com.streammovies.controller.util;

import com.streammovies.service.ICategoryService;
import com.streammovies.service.INationalService;
import com.streammovies.utils.HeaderConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

@Component
public class HeaderInit {

    @Autowired
    INationalService nationalService;

    @Autowired
    ICategoryService categoryService;

    public void setModelHeader(ModelAndView modelAndView){
        modelAndView.addObject("headerNational", nationalService.findAll());
        modelAndView.addObject("headerCategory", categoryService.findAll());
        modelAndView.addObject("headerListYear", HeaderConstant.LIST_YEAR);
    }
}
