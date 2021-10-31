package com.streammovies.controller.util;

import com.streammovies.utils.RequestAction;
import com.streammovies.utils.SystemConstant;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

@Component
public class RedirectToSubPath implements IRedirectRequest{
    @Override
    public String sendRedirect(HttpServletRequest request, String subPath) {
        return RequestAction.REDIRECT + request.getServletPath() + subPath;
    }

}
