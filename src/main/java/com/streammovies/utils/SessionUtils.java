package com.streammovies.utils;

import com.streammovies.model.admin.Admin;
import com.streammovies.model.watcher.User;
import com.streammovies.utils.SessionConst;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SessionUtils {
    public static String getJSessionId(HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        if(cookies == null){
            return null;
        }
        for(Cookie cookie: cookies){
            if(cookie.getName().equals(SessionConst.JSESSIONID)){
                return cookie.getValue();
            }
        }
        return null;
    }

    public static void save(User user, HttpServletRequest request){
        HttpSession session = request.getSession();
        session.setAttribute(session.getId(), user);
    }

    public static User getUserWithSession(HttpServletRequest request){
        Cookie cookie = CookieUtils.getCookieJSessionId(request);
        String jSessionIdClient = cookie.getValue();
        Object object = request.getSession().getAttribute(jSessionIdClient);
        if(object == null){
            return null;
        }
        return (User) object;
    }



}
