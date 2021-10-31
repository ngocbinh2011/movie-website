package com.streammovies.controller.web;

import com.streammovies.controller.util.HeaderInit;
import com.streammovies.controller.util.IModelControl;
import com.streammovies.controller.util.IRedirectRequest;
import com.streammovies.model.movies.Movie;
import com.streammovies.model.movies.National;
import com.streammovies.service.IMovieService;
import com.streammovies.service.INationalService;
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
public class NationController {

    @Autowired
    private IMovieService movieService;

    @Autowired
    private INationalService nationalService;

    @Autowired
    private HeaderInit headerInit;

    @Autowired
    private IRedirectRequest redirect;

    @Autowired
    private IModelControl<Movie> modelControl;

    @RequestMapping(value = "/quoc-gia/{nationalCode}", method = RequestMethod.GET)
    public String getNationalModel(@PathVariable(value = "nationalCode") String nationalCode, HttpServletRequest request){
        return redirect.sendRedirect(request, SystemConstant.FIRST_PAGE);
    }

    @RequestMapping(value = "/quoc-gia/{nationalCode}/page/{page}", method = RequestMethod.GET)
    public ModelAndView getNationalModel(@PathVariable(value = "nationalCode") String nationalCode,
                                         @PathVariable(value = "page") int page){
        ModelAndView modelAndView = new ModelAndView(View.NATIONAL);
        headerInit.setModelHeader(modelAndView);
        National national = nationalService.findOne(nationalCode);
        String headerContent = national.getName();
        List<Movie> listMovie = movieService.findAllByNationalCode(nationalCode);
        modelControl.addModel(modelAndView, listMovie, page, headerContent);
        return modelAndView;
    }
}
