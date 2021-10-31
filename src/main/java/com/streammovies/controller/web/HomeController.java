package com.streammovies.controller.web;

import com.streammovies.controller.util.HeaderInit;
import com.streammovies.dao.dao.ISliderDAO;
import com.streammovies.service.ICategoryService;
import com.streammovies.service.IGridService;
import com.streammovies.service.IMovieService;
import com.streammovies.service.ISliderService;
import com.streammovies.utils.SystemConstant;
import com.streammovies.utils.View;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController{

    @Autowired
    private IMovieService movieService;

    @Autowired
    private ICategoryService categoryService;

    @Autowired
    private IGridService gridService;

    @Autowired
    private HeaderInit headerInit;

    @Autowired
    private ISliderService sliderService;

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public ModelAndView getHomeModel() {
        ModelAndView modelAndView = new ModelAndView(View.HOME);
        headerInit.setModelHeader(modelAndView);
        modelAndView.addObject("listMovieSlider", sliderService.findAll());
        modelAndView.addObject("grid1", gridService.getGrid(SystemConstant.GRID_ONE));
        modelAndView.addObject("grid2", gridService.getGrid(SystemConstant.GRID_TWO));
        modelAndView.addObject("grid3", gridService.getGrid(SystemConstant.GRID_THREE));
        modelAndView.addObject("grid4", gridService.getGrid(SystemConstant.GRID_FOUR));
        modelAndView.addObject("listMovieOfGrid1", movieService.findAllByGridId(SystemConstant.GRID_ONE));
        modelAndView.addObject("listMovieOfGrid2", movieService.findAllByGridId(SystemConstant.GRID_TWO));
        modelAndView.addObject("listMovieOfGrid3", movieService.findAllByGridId(SystemConstant.GRID_THREE));
        modelAndView.addObject("listMovieOfGrid4", movieService.findAllByGridId(SystemConstant.GRID_FOUR));
        return modelAndView;
    }
}
