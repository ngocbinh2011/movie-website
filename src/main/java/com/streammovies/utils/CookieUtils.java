package com.streammovies.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieUtils {

    public static Cookie getCookieJSessionId(HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        if(cookies != null){
            for(Cookie cookie: cookies){
                if(cookie.getName().equals(SessionConst.JSESSIONID)){
                    return cookie;
                }
            }
        }
        return null;
    }

    public static void deleteCookieSessionId(HttpServletRequest request, HttpServletResponse response){
        Cookie cookie = getCookieJSessionId(request);
        if(cookie != null){
            cookie.setMaxAge(0);
            response.addCookie(cookie);
        }
    }

    public static void save(HttpServletRequest request, HttpServletResponse response){
        Cookie cookie = getCookieJSessionId(request);
        if(cookie != null){
            cookie.setValue(request.getSession().getId());
            cookie.setMaxAge(SystemConstant.COOKIE_MAX_AGE);
            cookie.setPath("/admin");
            response.addCookie(cookie);
            return;
        }
        cookie = new Cookie(SessionConst.JSESSIONID, request.getSession().getId());
        cookie.setPath("/admin");
        cookie.setMaxAge(SystemConstant.COOKIE_MAX_AGE);
        response.addCookie(cookie);

    }
}
