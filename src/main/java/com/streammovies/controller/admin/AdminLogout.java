package com.streammovies.controller.admin;

import com.streammovies.model.admin.Admin;
import com.streammovies.utils.CookieUtils;
import com.streammovies.utils.SessionUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@RequestMapping("/admin")
@Controller
public class AdminLogout {
    @RequestMapping(value = "/logout/", method = RequestMethod.GET)
    public void adminLogout(HttpServletRequest request, HttpServletResponse response) throws IOException {
        CookieUtils.deleteCookieSessionId(request, response);
        request.getSession().invalidate(); // remove session
        response.sendRedirect("/admin/login/");
    }
}
