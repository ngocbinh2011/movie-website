package com.streammovies.controller.web;

import com.streammovies.controller.util.HeaderInit;
import com.streammovies.controller.util.IModelControl;
import com.streammovies.controller.util.IRedirectRequest;
import com.streammovies.model.admin.Admin;
import com.streammovies.model.movies.Actor;
import com.streammovies.model.movies.Movie;
import com.streammovies.service.IActorService;
import com.streammovies.service.IMovieService;
import com.streammovies.utils.RequestAction;
import com.streammovies.utils.SystemConstant;
import com.streammovies.utils.View;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

@Controller
public class SearchController {

    @Autowired
    private IRedirectRequest redirect;

    @Autowired
    private HeaderInit headerInit;

    @Autowired
    private IModelControl<Movie> modelControl;

    @Autowired
    private IMovieService movieService;

    @Autowired
    private IActorService actorService;

    @RequestMapping(value = "/tim-kiem", method = RequestMethod.POST)
    public String searchModel(HttpServletRequest request, @RequestParam("research") String research){
        return RequestAction.REDIRECT + request.getServletPath() + research + SystemConstant.FIRST_PAGE;
    }

    @RequestMapping(value = "/tim-kiem/{research}/page/{page}", method = RequestMethod.GET)
    public ModelAndView searchModel(@PathVariable(value = "research") String research,
                                    @PathVariable(value = "page") int page){
        ModelAndView modelAndView = new ModelAndView(View.SEARCH);
        headerInit.setModelHeader(modelAndView);
        List<Movie> listMovie = movieService.search(research);
        String headerContent = research;
        modelControl.addModel(modelAndView, listMovie, page, headerContent);
        return modelAndView;
    }
}
