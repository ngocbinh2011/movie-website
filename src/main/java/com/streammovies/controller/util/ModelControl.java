package com.streammovies.controller.util;

import com.streammovies.model.movies.Movie;
import com.streammovies.service.IMovieService;
import com.streammovies.utils.SystemConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
public class ModelControl implements IModelControl<Movie>{

    @Autowired
    IMovieService movieService;

    @Override
    public void addModel(ModelAndView modelAndView, List<Movie> list, int currentPage, String headerContent) {
        int maxSize = list.size();
        int maxPage = (maxSize / SystemConstant.SIZE_PAGE) + (maxSize % SystemConstant.SIZE_PAGE != 0? 1 : 0);
        modelAndView.addObject("listMovie", getListMovieInCurrentPage(list, currentPage));
        modelAndView.addObject("currentPage", currentPage);
        modelAndView.addObject("maxPage", maxPage);
        modelAndView.addObject("headerContent", headerContent);
    }

    private List<Movie> getListMovieInCurrentPage(List<Movie> list, int page){
        return movieService.getMoviePagination(page, list);
    }
}
