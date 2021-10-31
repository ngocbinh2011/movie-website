package com.streammovies.controller.util;

import org.springframework.web.servlet.ModelAndView;

import java.util.List;

public interface IModelControl<T> {
    public void addModel(ModelAndView modelAndView, List<T> list, int currentPage, String headerContent);
}
