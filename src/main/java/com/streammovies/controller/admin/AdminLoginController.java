package com.streammovies.controller.admin;

import com.mysql.cj.util.StringUtils;
import com.streammovies.model.admin.Admin;
import com.streammovies.model.watcher.Role;
import com.streammovies.model.watcher.User;
import com.streammovies.service.IAdminService;
import com.streammovies.service.IUserService;
import com.streammovies.service.impl.RoleService;
import com.streammovies.utils.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.CollationKey;
import java.text.Normalizer;
import java.util.Set;
import java.util.regex.Pattern;

@PropertySource("classpath:messages.properties")
@RequestMapping("/admin")
@Controller
public class AdminLoginController {

    @Autowired
    private Environment environment;

    @Autowired
    private IUserService userService;

    @Autowired
    private IAdminService adminService;

    @Autowired
    private RoleService roleService;

    @RequestMapping(value = "/login/", method = RequestMethod.GET)
    public ModelAndView adminLoginGet(){
        return new ModelAndView(View.ADMIN_LOGIN);
    }

    @RequestMapping(value = "/login/", method = RequestMethod.POST)
    public void adminLoginPost(@RequestParam("username") String username, @RequestParam("password") String password,
                               HttpServletRequest request, HttpServletResponse response) throws IOException {
        if(!checkConventionLogin(username) || !checkConventionLogin(password)){
            response.sendRedirect("/admin/login/?message=" +  environment.getProperty("login.username_or_password_invalid"));
            return;
        }

        if(userService.checkLogin(username, password)){
            Admin admin = adminService.findOne(username);
            if(admin != null){
                admin.setListRole(roleService.getListRole(admin));
                SessionUtils.save(admin, request);
                CookieUtils.save(request, response);
                response.sendRedirect("/admin/home/");
            } else{
                response.sendRedirect("/admin/login/?message=" + environment.getProperty("login.you_are_not_admin"));
            }
        } else{
            response.sendRedirect("/admin/login/?message=" + environment.getProperty("login.username_or_password_wrong"));
        }

    }

    public boolean checkConventionLogin(String input){
        if(input == null || input.length() < SystemConstant.MIN_LENGTH){
            return false;
        }
        String regex = "[\\w]{6,}";
        return Pattern.compile(regex).matcher(input).matches();
    }

}
