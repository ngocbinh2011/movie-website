package com.streammovies.controller.web;

import com.streammovies.utils.View;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class UserController {

    @RequestMapping(value = "/tai-khoan/{username}", method = RequestMethod.GET)
    public ModelAndView getUserModel(@PathVariable(value = "username") String username){
        return null;
    }

    @RequestMapping(value = "/user/login", method = RequestMethod.GET)
    public ModelAndView login(){
        return new ModelAndView(View.SIGN);
    }
}
