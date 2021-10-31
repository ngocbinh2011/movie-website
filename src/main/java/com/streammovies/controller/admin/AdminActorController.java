package com.streammovies.controller.admin;

import com.streammovies.model.movies.Actor;
import com.streammovies.service.IActorService;
import com.streammovies.utils.RequestAction;
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
public class AdminActorController {
    @Autowired
    private IActorService actorService;

    @RequestMapping(value = "/actor/", method = RequestMethod.GET)
    public ModelAndView adminActor(){
        ModelAndView modelAndView = new ModelAndView(View.ADMIN_ACTOR);
        modelAndView.addObject("listActor", actorService.findAll());
        return modelAndView;
    }

    @RequestMapping(value = "/actor/change/{actorId}/", method = RequestMethod.GET)
    public ModelAndView adminChangeActorGet(@PathVariable("actorId") int actorId){
        ModelAndView modelAndView = new ModelAndView(View.ADMIN_ACTOR_UPDATE);
        modelAndView.addObject("actor", actorService.findOne(actorId));
        return modelAndView;
    }

    @RequestMapping(value = "/actor/change/{actorId}/", method = RequestMethod.POST)
    public String adminChangeActorPost(@PathVariable("actorId") int actorId,
                                             @RequestParam("name") String name, @RequestParam("code") String code){
        Actor actor = new Actor(actorId, name, code);
        actorService.update(actor);
        return RequestAction.REDIRECT + String.format("/admin/actor/change/%d/", actorId);
    }

}
