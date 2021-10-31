package com.streammovies.security;

import com.mysql.cj.Session;
import com.streammovies.model.admin.Admin;
import com.streammovies.model.watcher.Role;
import com.streammovies.model.watcher.User;
import com.streammovies.service.IUserService;
import com.streammovies.utils.CookieUtils;
import com.streammovies.utils.RequestAction;
import com.streammovies.utils.SessionConst;
import com.streammovies.utils.SessionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class LoginSecurity implements HandlerInterceptor {

    @Autowired
    IUserService userService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        String jSessionIdClient = SessionUtils.getJSessionId(request);
        if(jSessionIdClient == null){
            response.sendRedirect("/admin/login/");
            return false;
        }

        Object object = session.getAttribute(jSessionIdClient);
        if(object == null){
            response.sendRedirect("/admin/login/");
            return false;
        } else{
            User user = (User) object;
            String path = request.getServletPath();
            if(path.startsWith("/admin")){
                if(userService.checkRole(user, Role.ADMIN)){
                    Admin admin = (Admin) object;
                    SessionUtils.save(admin, request);
                    CookieUtils.save(request, response);
                    return true;
                } else{
                    response.sendRedirect("/admin/login/");
                    return false;
                }
            } else{
                return true;
            }
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
