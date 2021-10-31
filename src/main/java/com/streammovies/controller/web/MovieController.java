package com.streammovies.controller.web;

import com.streammovies.controller.util.HeaderInit;
import com.streammovies.controller.util.IModelControl;
import com.streammovies.controller.util.IRedirectRequest;
import com.streammovies.model.movies.Episode;
import com.streammovies.model.movies.Link;
import com.streammovies.model.movies.Movie;
import com.streammovies.model.watcher.User;
import com.streammovies.service.IEpisodeService;
import com.streammovies.service.ILinkService;
import com.streammovies.service.IMovieService;
import com.streammovies.service.IUserService;
import com.streammovies.utils.CategoryConst;
import com.streammovies.utils.RequestAction;
import com.streammovies.utils.SystemConstant;
import com.streammovies.utils.View;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class MovieController {

    @Autowired
    private IRedirectRequest redirect;

    @Autowired
    private HeaderInit headerInit;

    @Autowired
    private IModelControl<Movie> modelControl;

    @Autowired
    private IEpisodeService episodeService;

    @Autowired
    private IMovieService movieService;

    @Autowired
    private ILinkService linkService;


    @RequestMapping(value = {"/phim/{movieCode}", "/noi-dung/{movieCode}"}, method = RequestMethod.GET)
    public ModelAndView getMovieContent(@PathVariable(value = "movieCode") String movieCode){
        ModelAndView modelAndView = new ModelAndView(View.MOVIE_DETAILS);
        Movie movie = movieService.mappingORM(movieService.findOne(movieCode));
        addModelAndView(modelAndView, movie);
        return modelAndView;
    }

    @RequestMapping(value = "/xem-phim/{movieCode}/{episodeCode}/{serverId}", method = RequestMethod.GET)
    public ModelAndView watchMovie(@PathVariable(value = "movieCode") String movieCode,
                                   @PathVariable(value = "episodeCode") String episodeCode,
                                   @PathVariable(value = "serverId") int serverId){
        ModelAndView modelAndView = new ModelAndView(View.WATCH);
        Movie movie = movieService.mappingORM(movieService.findOne(movieCode));
        addModelAndView(modelAndView, movie);
        List<Episode> listEpisode = episodeService.findAllByMovieCode(movieCode);
        modelAndView.addObject("listEpisode", listEpisode);
        modelAndView.addObject("episodeCode", episodeCode);
        if(!episodeCode.equals(SystemConstant.NULL)){
            Link link = linkService.findOne(movieCode, episodeCode, serverId);
            modelAndView.addObject("link", link);
        }
        return modelAndView;
    }

    @RequestMapping(value = "/xem-phim/{movieCode}", method = RequestMethod.GET)
    public String watchMovie(@PathVariable(value = "movieCode") String movieCode, HttpServletRequest request){
        movieService.updateView(movieCode);
        List<Episode> listEpisode = episodeService.findAllByMovieCode(movieCode);
        String episodeCode = SystemConstant.NULL;
        if(!listEpisode.isEmpty()){
            episodeCode = listEpisode.get(0).getCode();
        }
        return redirect.sendRedirect(request, "/" + episodeCode + "/1");
    }

    @RequestMapping(value = "/top-phim-imdb", method = RequestMethod.GET)
    public String getMovieImdb(HttpServletRequest request){
        return redirect.sendRedirect(request, SystemConstant.FIRST_PAGE);
    }

    @RequestMapping(value = "/top-phim-imdb/page/{page}", method = RequestMethod.GET)
    public ModelAndView getMovieImdb(@PathVariable(value = "page") int page){
        ModelAndView modelAndView = new ModelAndView(View.TOP_IMDB);
        headerInit.setModelHeader(modelAndView);
        List<Movie> listMovie = movieService.findAllOrderByIMDB();
        String headerContent = null;
        modelControl.addModel(modelAndView, listMovie, page, headerContent);
        return modelAndView;
    }

    @RequestMapping(value = "/nam-san-xuat/{year}", method = RequestMethod.GET)
    public String getMovieYear(@PathVariable(value = "year") int year,
                               HttpServletRequest request){
        return redirect.sendRedirect(request, SystemConstant.FIRST_PAGE);
    }

    @RequestMapping(value = "/nam-san-xuat/{year}/page/{page}", method = RequestMethod.GET)
    public ModelAndView getMovieYear(@PathVariable(value = "year") int year,
                                     @PathVariable(value = "page") int page){
        ModelAndView modelAndView = new ModelAndView(View.REPOSITORY);
        headerInit.setModelHeader(modelAndView);
        List<Movie> listMovie = movieService.findAllByYearPublish(year);
        String headerContent = "NĂM " + year;
        modelControl.addModel(modelAndView, listMovie, page, headerContent);
        return modelAndView;
    }

    @RequestMapping(value = "/dao-dien/{name}/page/{page}", method = RequestMethod.GET)
    public ModelAndView getMovieDirector(@PathVariable("name") String name, @PathVariable("page") int page){
        ModelAndView modelAndView = new ModelAndView(View.DIRECTOR);
        headerInit.setModelHeader(modelAndView);
        List<Movie> listMovie = movieService.findAllMovieByDirector(name);
        String headerContent = name;
        modelControl.addModel(modelAndView, listMovie, page, headerContent);
        return modelAndView;
    }

    public void addModelAndView(ModelAndView modelAndView, Movie movie){
        headerInit.setModelHeader(modelAndView);
        List<Movie> listMovieFeature = movieService
                .findLimitMovieBestViewByCategory(CategoryConst.FEATURE_CODE, SystemConstant.MAX_RECORD_MOST_VIEWED);
        List<Movie> listMovieSeries = movieService
                .findLimitMovieBestViewByCategory(CategoryConst.SERIES_CODE, SystemConstant.MAX_RECORD_MOST_VIEWED);

        List<Movie> listMovieSameName = movieService
                .findLimitMovieStartWithName(movie, SystemConstant.MAX_RECORD_SAME_CODE);
        modelAndView.addObject("listFeatureBestView", listMovieFeature);
        modelAndView.addObject("listSeriesBestView", listMovieSeries);
        modelAndView.addObject("listMovieSameName", listMovieSameName);
        modelAndView.addObject("movie", movie);
        modelAndView.addObject("feature", CategoryConst.FEATURE_CODE);
        modelAndView.addObject("series", CategoryConst.SERIES_CODE);
    }



}
