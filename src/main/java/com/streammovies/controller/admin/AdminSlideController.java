package com.streammovies.controller.admin;

import com.streammovies.model.admin.Admin;
import com.streammovies.model.movies.Movie;
import com.streammovies.model.present.MovieSlider;
import com.streammovies.service.IGridService;
import com.streammovies.service.IMovieService;
import com.streammovies.service.ISliderService;
import com.streammovies.service.impl.MovieGridViewService;
import com.streammovies.utils.RequestAction;
import com.streammovies.utils.SessionUtils;
import com.streammovies.utils.SystemConstant;
import com.streammovies.utils.View;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@RequestMapping("/admin")
@Controller
public class AdminSlideController {


    @Autowired
    private ISliderService sliderService;


    @Autowired
    private IMovieService movieService;

    @Autowired
    private MovieGridViewService movieGridViewService;

    @RequestMapping(value = "/slide-grid/", method = RequestMethod.GET)
    public ModelAndView adminSlideAndGridView() {
        ModelAndView modelAndView = new ModelAndView(View.ADMIN_HOME_WEB);

        modelAndView.addObject("listMovie", movieService.findAll());
        modelAndView.addObject("listMovieSlider", sliderService.findAll());
        modelAndView.addObject("listMovieOfGrid1", movieService.findAllByGridId(SystemConstant.GRID_ONE));
        modelAndView.addObject("listMovieOfGrid2", movieService.findAllByGridId(SystemConstant.GRID_TWO));
        modelAndView.addObject("listMovieOfGrid3", movieService.findAllByGridId(SystemConstant.GRID_THREE));
        modelAndView.addObject("listMovieOfGrid4", movieService.findAllByGridId(SystemConstant.GRID_FOUR));

        return modelAndView;
    }

    @RequestMapping(value = "/slide-grid/slide/delete/{sliderId}/", method = RequestMethod.GET)
    public String deleteMovieInSlide(@PathVariable("sliderId") int sliderId) {
        sliderService.delete(sliderId);
        return RequestAction.REDIRECT + "/admin/slide-grid/";
    }

    @RequestMapping(value = "/slide-grid/grid/delete/{gridId}/{movieId}/", method = RequestMethod.GET)
    public String deleteMovieInGrid(@PathVariable("movieId") int movieId, @PathVariable("gridId") int gridId) {
        movieGridViewService.delete(movieId, gridId);
        return RequestAction.REDIRECT + "/admin/slide-grid/";
    }

    @RequestMapping(value = "/slide-grid/grid/add-movie/{gridId}/", method = RequestMethod.POST)
    public String addMovieInGrid(@RequestParam("movieId") int movieId, @PathVariable("gridId") int gridId) {
        movieGridViewService.save(movieId, gridId);
        return RequestAction.REDIRECT + "/admin/slide-grid/";
    }

    @RequestMapping(value = "/slide-grid/slide/add-movie/", method = RequestMethod.POST)
    public String addMovieInSlide(HttpServletRequest request,  @RequestParam("movieId") String movieId,
                                  @RequestParam("imageSlide") String imageSlide) {

        Admin admin = (Admin) SessionUtils.getUserWithSession(request);

        Movie movie = new Movie();
        movie.setId(Integer.valueOf(movieId));
        MovieSlider movieSlider = new MovieSlider();
        movieSlider.setImageLinkSlider(imageSlide);
        movieSlider.setMovie(movie);
        movieSlider.setCreator(admin);

        sliderService.save(movieSlider);
        return RequestAction.REDIRECT + "/admin/slide-grid/";
    }
}
