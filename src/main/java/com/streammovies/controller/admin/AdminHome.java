package com.streammovies.controller.admin;

import com.streammovies.model.admin.Admin;
import com.streammovies.model.watcher.User;
import com.streammovies.utils.SessionUtils;
import com.streammovies.utils.View;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RequestMapping("/admin")
@Controller
public class AdminHome {
    @RequestMapping(value = "/home/", method = RequestMethod.GET)
    public ModelAndView adminHome(HttpServletRequest request){
        ModelAndView modelAndView = new ModelAndView(View.ADMIN_HOME);
        Admin admin = (Admin) SessionUtils.getUserWithSession(request);
        modelAndView.addObject("adminName", admin.getName());
        return modelAndView;
    }
}
