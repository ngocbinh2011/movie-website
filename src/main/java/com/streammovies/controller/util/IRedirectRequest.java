package com.streammovies.controller.util;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

public interface IRedirectRequest {
    String sendRedirect(HttpServletRequest request, String subPath);
}
