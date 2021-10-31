package com.streammovies.controller.admin;

import com.streammovies.model.admin.Admin;
import com.streammovies.model.movies.Actor;
import com.streammovies.model.movies.Category;
import com.streammovies.model.watcher.User;
import com.streammovies.service.IActorService;
import com.streammovies.service.ICategoryService;
import com.streammovies.utils.RequestAction;
import com.streammovies.utils.SessionUtils;
import com.streammovies.utils.Text;
import com.streammovies.utils.View;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@RequestMapping("/admin")
@Controller
public class AdminCategoryController {
    @Autowired
    private ICategoryService categoryService;

    @RequestMapping(value = "/categories/", method = RequestMethod.GET)
    public ModelAndView adminCategory(){
        ModelAndView modelAndView = new ModelAndView(View.ADMIN_CATEGORY);
        modelAndView.addObject("listCategory", categoryService.findAll());
        return modelAndView;
    }

    @RequestMapping(value = "/categories/add/", method = RequestMethod.POST)
    public String addCategory(@RequestParam("name") String name, HttpServletRequest request){
        Admin admin = (Admin) SessionUtils.getUserWithSession(request);
        categoryService.save(new Category(name, Text.getUrlCodeIgnoreAccents(name), admin));
        return RequestAction.REDIRECT + "/admin/categories/";
    }

}
