package com.streammovies.controller.web;

import com.streammovies.controller.util.HeaderInit;
import com.streammovies.controller.util.IModelControl;
import com.streammovies.controller.util.IRedirectRequest;
import com.streammovies.model.movies.Category;
import com.streammovies.model.movies.Movie;
import com.streammovies.model.movies.National;
import com.streammovies.service.ICategoryService;
import com.streammovies.service.IMovieService;
import com.streammovies.service.INationalService;
import com.streammovies.utils.CategoryConst;
import com.streammovies.utils.SystemConstant;
import com.streammovies.utils.View;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class CategoryController {

    @Autowired
    private IMovieService movieService;

    @Autowired
    private HeaderInit headerInit;

    @Autowired
    private ICategoryService categoryService;

    @Autowired
    private IRedirectRequest redirect;

    @Autowired
    private IModelControl<Movie> modelControl;

    @Autowired
    private INationalService nationalService;


    @RequestMapping(value = {"/the-loai/{categoryCode}"}, method = RequestMethod.GET)
    public String getCategoryModel(@PathVariable(value = "categoryCode") String categoryCode, HttpServletRequest request){
        return redirect.sendRedirect(request, SystemConstant.FIRST_PAGE);
    }

    @RequestMapping(value = {"/the-loai/{categoryCode}/page/{page}"}, method = RequestMethod.GET)
    public ModelAndView getModelPaging(@PathVariable(value = "categoryCode") String categoryCode,
                                   @PathVariable(value = "page") int page){
        ModelAndView modelAndView = new ModelAndView(View.CATEGORY);
        headerInit.setModelHeader(modelAndView);
        List<Movie> listMovie = movieService.findAllByCategory(categoryCode);
        Category category = categoryService.findOne(categoryCode);
        String headerContent = category.getName();
        modelControl.addModel(modelAndView, listMovie, page, headerContent);
        return modelAndView;
    }


    @RequestMapping(value =  "/phim-le/{year}")
    public String getFeatureMovieModel(@PathVariable(value = "year") int year, HttpServletRequest request){
        return redirect.sendRedirect(request, SystemConstant.FIRST_PAGE);
    }

    @RequestMapping(value =  "/phim-le/{year}/page/{page}")
    public ModelAndView getFeatureMovieModel(@PathVariable(value = "year") int year,
                                             @PathVariable(value = "page") int page){
        ModelAndView modelAndView = new ModelAndView(View.CATEGORY);
        headerInit.setModelHeader(modelAndView);
        List<Movie> listMovie = movieService.findAllByCategoryAndYear(CategoryConst.FEATURE_CODE, year);
        Category category = categoryService.findOne(CategoryConst.FEATURE_CODE);
        String headerContent = category.getName() + " " + year;
        modelControl.addModel(modelAndView, listMovie, page, headerContent);
        return modelAndView;
    }

    @RequestMapping(value = "/phim-bo/{nationalCode}", method = RequestMethod.GET)
    public String getSeriesMovieModel(@PathVariable(value = "nationalCode") String nationalCode, HttpServletRequest request){
        return redirect.sendRedirect(request, SystemConstant.FIRST_PAGE);
    }

    @RequestMapping(value = "/phim-bo/{nationalCode}/page/{page}", method = RequestMethod.GET)
    public ModelAndView getSeriesMovieModel(@PathVariable(value = "nationalCode") String nationalCode,
                                            @PathVariable(value = "page") int page){
        ModelAndView modelAndView = new ModelAndView(View.CATEGORY);
        headerInit.setModelHeader(modelAndView);
        List<Movie> listMovie = movieService.findAllByCategoryAndNational(CategoryConst.SERIES_CODE, nationalCode);
        National national = nationalService.findOne(nationalCode);
        String headerContent = national.getName();
        modelControl.addModel(modelAndView, listMovie, page, headerContent);
        return modelAndView;
    }
}
