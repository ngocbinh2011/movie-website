package com.streammovies.controller.web;

import com.streammovies.controller.util.HeaderInit;
import com.streammovies.controller.util.IModelControl;
import com.streammovies.controller.util.IRedirectRequest;
import com.streammovies.model.movies.Actor;
import com.streammovies.model.movies.Movie;
import com.streammovies.model.movies.National;
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
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class ActorController {

    @Autowired
    private IRedirectRequest redirect;

    @Autowired
    private HeaderInit headerInit;

    @Autowired
    private IMovieService movieService;

    @Autowired
    private IActorService actorService;

    @Autowired
    private IModelControl<Movie> modelControl;

    @RequestMapping(value = "/dien-vien/{actorCode}", method = RequestMethod.GET)
    public String getCategoryModel(@PathVariable(value = "actorCode") String actorCode, HttpServletRequest request){
        return redirect.sendRedirect(request, SystemConstant.FIRST_PAGE);
    }

    @RequestMapping(value = "/dien-vien/{actorCode}/page/{page}", method = RequestMethod.GET)
    public ModelAndView getCategoryModel(@PathVariable(value = "actorCode") String actorCode,
                                   @PathVariable(value = "page") int page){
        ModelAndView modelAndView = new ModelAndView(View.ACTOR);
        headerInit.setModelHeader(modelAndView);
        List<Movie> listMovie = movieService.findAllByActorCode(actorCode);
        Actor actor = actorService.findOne(actorCode);
        String headerContent = actor.getName();
        modelControl.addModel(modelAndView, listMovie, page, headerContent);
        return modelAndView;
    }

}
