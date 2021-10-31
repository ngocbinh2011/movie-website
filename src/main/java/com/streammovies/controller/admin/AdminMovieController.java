package com.streammovies.controller.admin;

import com.streammovies.controller.util.HeaderInit;
import com.streammovies.controller.util.IModelControl;
import com.streammovies.controller.util.IRedirectRequest;
import com.streammovies.dao.api.IConnection;
import com.streammovies.model.admin.Admin;
import com.streammovies.model.movies.*;
import com.streammovies.service.*;
import com.streammovies.service.impl.LinkService;
import com.streammovies.service.impl.MovieActorService;
import com.streammovies.service.impl.MovieCategoryService;
import com.streammovies.utils.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

@RequestMapping(value = "/admin")
@Controller
public class AdminMovieController {


    @Autowired
    private IMovieService movieService;

    @Autowired
    private IActorService actorService;

    @Autowired
    private ICategoryService categoryService;

    @Autowired
    private ITagsService tagService;

    @Autowired
    private IEpisodeService episodeService;

    @Autowired
    private ILinkService linkService;

    @Autowired
    private INationalService nationalService;

    @Autowired
    private MovieActorService movieActorService;

    @Autowired
    private MovieCategoryService movieCategoryService;

    @Autowired
    private IModelControl<Movie> modelControl; // pagging

    @Autowired
    private IRedirectRequest redirectRequest;


    @RequestMapping(value = {"/movies/"}, method = RequestMethod.GET)
    public String adminMovies(HttpServletRequest request){
        return RequestAction.REDIRECT + "page/1";
    }

    @RequestMapping(value = {"/movies/page/{page}/", "/movies/page/{page}"}, method = RequestMethod.GET)
    public ModelAndView adminMoviesPage(@PathVariable("page") int page){
        List<Movie> listMovie = movieService.findAll();
        Collections.sort(listMovie, new SortMovieByIdDESC());
        ModelAndView modelAndView = new ModelAndView(View.ADMIN_MOVIES);
        modelControl.addModel(modelAndView, listMovie, page, null);
        return modelAndView;
    }

    @RequestMapping(value = "/movies/search/", method = RequestMethod.POST)
    public ModelAndView adminSearchMovie(@RequestParam("movieName") String movieName){
        List<Movie> listMovie = movieService.findAllByName(movieName);
        ModelAndView modelAndView = new ModelAndView(View.ADMIN_MOVIES);
        modelAndView.addObject("listMovie", listMovie);
        return modelAndView;
    }

    @RequestMapping(value = "/movies/add/", method = RequestMethod.POST)
    public String adminAddMovie(HttpServletRequest request, @RequestParam("name") String name,
                                    @RequestParam("trailerLink") String tralerLink, @RequestParam("englishName") String englishName,
                                    @RequestParam("director") String director,
                                    @RequestParam("year") int yearPublish, @RequestParam("amountEpisode") int amountEpisode,
                                    @RequestParam("time") int time, @RequestParam("national") int nationalId,
                                    @RequestParam("shortContent") String shortContent, @RequestParam("mainContent") String mainContent,
                                    @RequestParam("imagePoster") String imagePoster, @RequestParam("imageLink") String imageLink,
                                    @RequestParam("imdb") double imdbScore) {
        Admin admin = (Admin) SessionUtils.getUserWithSession(request);
        Movie movie = new Movie();
        movie.setName(name);
        movie.setCode(Text.getUrlCodeIgnoreAccents(name));
        movie.setTrailerLink(tralerLink);
        movie.setDirector(director);
        movie.setEnglishName(englishName);
        movie.setMinutes(time);
        movie.setYearPublish(yearPublish);
        movie.setAmountEpisode(amountEpisode);
        movie.setShortContent(shortContent);
        movie.setMainContent(mainContent);
        movie.setImageLinkPoster(imagePoster);
        movie.setImageLinkMain(imageLink);
        movie.setImdbScore(imdbScore);
        movie.setCreator(admin);
        movie.setUpdator(admin);
        National national = new National();
        national.setId(nationalId);
        movie.setNational(national);
        movieService.save(movie);
        return RequestAction.REDIRECT + "/admin/movies/";
    }

    @RequestMapping(value = "/movies/add/", method = RequestMethod.GET)
    public ModelAndView adminAddMovie(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView(View.ADMIN_ADD_MOVIES);
        modelAndView.addObject("listNational", nationalService.findAll());
        return modelAndView;
    }

    @RequestMapping(value = "/movies/delete/{movieId}/", method = RequestMethod.GET)
    public String deleteEpisode(@PathVariable("movieId") int movieId) {
        movieService.delete(movieId);
        return RequestAction.REDIRECT + "/admin/movies/";
    }


    @RequestMapping(value = "/movies/{id}/change/", method = RequestMethod.GET)
    public ModelAndView adminMenuChangeMovie() {
        return new ModelAndView(View.ADMIN_MENU_CHANGE);
    }

    @RequestMapping(value = "/movies/{id}/change/category/", method = RequestMethod.GET)
    public ModelAndView adminChangeCategoryMovie(@PathVariable("id") int movieId) {
        ModelAndView modelAndView = new ModelAndView(View.ADMIN_CHANGE_CATEGORY);
        modelAndView.addObject("listCategory", categoryService.findAll());
        modelAndView.addObject("listCategoryOfMovie", categoryService.findAllByMovieId(movieId));
        return modelAndView;
    }

    @RequestMapping(value = "/movies/{id}/change/category/add/", method = RequestMethod.POST)
    public String addCategory(@PathVariable("id") int movieId,
                                    @RequestParam("categoryAdd") int categoryId) {
        movieCategoryService.save(movieId, categoryId);
        return RequestAction.REDIRECT + String.format("/admin/movies/%d/change/category/", movieId);
    }

    @RequestMapping(value = "/movies/{movieId}/change/category/delete/{categoryId}", method = RequestMethod.GET)
    public String deleteCategory(@PathVariable("movieId") int movieId,
                                 @PathVariable("categoryId") int categoryId) {
        movieCategoryService.delete(movieId, categoryId);
        return RequestAction.REDIRECT + String.format("/admin/movies/%d/change/category/", movieId);
    }

    @RequestMapping(value = "/movies/{id}/change/general-information/", method = RequestMethod.GET)
    public ModelAndView adminChangeGeneralInformationMovie(@PathVariable("id") int movieId) {
        ModelAndView modelAndView = new ModelAndView(View.ADMIN_MODIFY_MOVIE);
        modelAndView.addObject("movie", movieService.findOne(movieId));
        modelAndView.addObject("nationalOfMovie", nationalService.findOneByMovieId(movieId));
        modelAndView.addObject("listNational", nationalService.findAll());
        return modelAndView;
    }

    @RequestMapping(value = "/movies/{id}/change/general-information/update/", method = RequestMethod.POST)
    public String adminChangeGeneralInformationMovie(HttpServletRequest request, @RequestParam("name") String name, @RequestParam("code") String code,
                                                           @RequestParam("trailerLink") String tralerLink, @RequestParam("englishName") String englishName,
                                                           @RequestParam("director") String director,
                                                           @RequestParam("year") int yearPublish, @RequestParam("amountEpisode") int amountEpisode,
                                                           @RequestParam("time") int time, @RequestParam("national") int nationalId,
                                                           @RequestParam("shortContent") String shortContent, @RequestParam("mainContent") String mainContent,
                                                           @RequestParam("imagePoster") String imagePoster, @RequestParam("imageLink") String imageLink,
                                                           @RequestParam("imdb") double imdbScore, @PathVariable("id") int movieId) {
        Admin admin = (Admin) SessionUtils.getUserWithSession(request);
        Movie movie = new Movie();
        movie.setId(movieId);
        movie.setName(name);
        movie.setCode(code);
        movie.setTrailerLink(tralerLink);
        movie.setDirector(director);
        movie.setEnglishName(englishName);
        movie.setMinutes(time);
        movie.setYearPublish(yearPublish);
        movie.setAmountEpisode(amountEpisode);
        movie.setShortContent(shortContent);
        movie.setMainContent(mainContent);
        movie.setImageLinkPoster(imagePoster);
        movie.setImageLinkMain(imageLink);
        movie.setImdbScore(imdbScore);
        movie.setCreator(admin);
        movie.setUpdator(admin);
        National national = new National();
        national.setId(nationalId);
        movie.setNational(national);
        movieService.update(movie);
        return RequestAction.REDIRECT + String.format("/admin/movies/%d/change/general-information/", movieId);
    }



    @RequestMapping(value = "/movies/{id}/change/actor/", method = RequestMethod.GET)
    public ModelAndView adminChangeActorMovie(@PathVariable("id") int movieId) {
        ModelAndView modelAndView = new ModelAndView(View.ADMIN_CHANGE_ACTOR);
        modelAndView.addObject("listActorOfMovie", actorService.findAllByMovieId(movieId));
        return modelAndView;
    }

    @RequestMapping(value = "/movies/{id}/change/actor/add", method = RequestMethod.POST)
    public String addActorToMovie(HttpServletRequest request, @PathVariable("id") int movieId,
                                    @RequestParam("name") String actorName) {
        Admin admin = (Admin) SessionUtils.getUserWithSession(request);

        Actor actor = new Actor();
        actor.setName(actorName);
        actor.setCode(Text.getUrlCodeIgnoreAccents(actorName));
        actor.setAuthor(admin);
        Actor result = actorService.save(actor);
        if(result != null){
            movieActorService.save(movieId, result.getId());
        }
        return RequestAction.REDIRECT + "/admin/movies/{id}/change/actor/";
    }

    @RequestMapping(value = "/movies/{movieId}/change/actor/delete/{actorId}/", method = RequestMethod.GET)
    public String addActorToMovie(@PathVariable("movieId") int movieId,
                                  @PathVariable("actorId") int actorId) {
        movieActorService.delete(movieId, actorId);
        return RequestAction.REDIRECT + String.format("/admin/movies/%d/change/actor/", movieId);
    }

    @RequestMapping(value = "/movies/{id}/change/episodes/add/", method = RequestMethod.POST)
    public String addEpisode(HttpServletRequest request, @PathVariable("id") int movieId,
                                    @RequestParam("episodeNumber") int episodeNumber) {

        Admin admin = (Admin) SessionUtils.getUserWithSession(request);

        Episode episode = new Episode();
        Movie movie = new Movie();
        movie.setId(movieId);
        episode.setMovie(movie);
        episode.setEpisodeNumber(episodeNumber);
        episode.setCode(SystemConstant.EPISODE + episodeNumber);
        episode.setCreator(admin);
        episode.setUpdator(admin);
        Episode episode1 = episodeService.save(episode);
        
        // update amount episode
        if(episode1 != null){
            movieService.updateCurrentEpisode(movieId);
        }
        return RequestAction.REDIRECT + String.format("/admin/movies/%d/change/episodes/", movieId);
    }

    @RequestMapping(value = "/movies/{movieId}/change/episodes/delete/{episodeId}/", method = RequestMethod.GET)
    public String deleteEpisode(@PathVariable("movieId") int movieId,
                             @PathVariable("episodeId") int episodeId) {
        boolean isSucess = episodeService.delete(episodeId);

        // update amount episode
        if(isSucess){
            movieService.updateCurrentEpisode(movieId);
        }
        return RequestAction.REDIRECT + String.format("/admin/movies/%d/change/episodes/", movieId);
    }

    @RequestMapping(value = "/movies/{id}/change/episodes/", method = RequestMethod.GET)
    public ModelAndView adminChangeEpisodesMovie(@PathVariable("id") int movieId) {
        ModelAndView modelAndView = new ModelAndView(View.ADMIN_CHANGE_EPISODE);
        modelAndView.addObject("listEpisodeOfMovie", episodeService.findAllByMovieId(movieId));
        return modelAndView;
    }


    @RequestMapping(value = "/movies/{id}/change/episodes/update/{episodeId}/", method = RequestMethod.GET)
    public ModelAndView changeMovieLink(@PathVariable("episodeId") int episodeId) {
        ModelAndView modelAndView = new ModelAndView(View.ADMIN_CHANGE_LINK);
        modelAndView.addObject("episode", episodeService.findOne(episodeId));
        modelAndView.addObject("linkVip", linkService.findOne(episodeId, Server.VIP));
        modelAndView.addObject("linkOk", linkService.findOne(episodeId, Server.OK));
        modelAndView.addObject("linkGo", linkService.findOne(episodeId, Server.GO));
        modelAndView.addObject("linkHyx", linkService.findOne(episodeId, Server.HYX));
        return modelAndView;
    }

//    @RequestMapping(value = "/movies/{id}/change/episodes/update/{episodeId}/", method = RequestMethod.POST)
//    public ModelAndView changeMovieLink(@PathVariable("episodeId") int episodeId) {
//        ModelAndView modelAndView = new ModelAndView(View.ADMIN_CHANGE_LINK);
//        modelAndView.addObject("episode", episodeService.findOne(episodeId));
//        modelAndView.addObject("linkVip", linkService.findOne(episodeId, Server.VIP));
//        modelAndView.addObject("linkOk", linkService.findOne(episodeId, Server.OK));
//        modelAndView.addObject("linkGo", linkService.findOne(episodeId, Server.GO));
//        modelAndView.addObject("linkHyx", linkService.findOne(episodeId, Server.HYX));
//        return modelAndView;
//    }

    @RequestMapping(value = "/movies/{id}/change/episodes/update/{episodeId}/link/", method = RequestMethod.POST)
    public String changeMovieLink(HttpServletRequest request, @PathVariable("id") int movieId, @PathVariable("episodeId") int episodeId,
                                  @RequestParam("linkVip") String linkVip, @RequestParam("linkOk") String linkOk,
                                  @RequestParam("linkGo") String linkGo, @RequestParam("linkHyx") String linkHyx,
                                  @RequestParam("idLinkVip") String idLinkVip, @RequestParam("idLinkOk") String idLinkOk,
                                  @RequestParam("idLinkGo") String idLinkGo, @RequestParam("idLinkHyx") String idLinkHyx) {
        Admin admin = (Admin) SessionUtils.getUserWithSession(request);

        Movie movie = new Movie();
        movie.setId(movieId);
        Episode episode = new Episode();
        episode.setId(episodeId);

        int idVip = idLinkVip.isEmpty()? -1 : Integer.valueOf(idLinkVip);
        int idOk = idLinkOk.isEmpty()? -1 : Integer.valueOf(idLinkOk);
        int idGo = idLinkGo.isEmpty()? -1 : Integer.valueOf(idLinkGo);
        int idHyx = idLinkHyx.isEmpty()? -1 : Integer.valueOf(idLinkHyx);

        ((LinkService) linkService)
                .updateOrInsert(new Link(admin, admin, linkVip, Server.VIP, movie, episode), idVip);
        ((LinkService) linkService)
                .updateOrInsert(new Link(admin, admin, linkOk, Server.OK, movie, episode), idOk);
        ((LinkService) linkService)
                .updateOrInsert(new Link(admin, admin, linkGo, Server.GO, movie, episode), idGo);
        ((LinkService) linkService)
                .updateOrInsert(new Link(admin, admin, linkHyx, Server.HYX, movie, episode), idHyx);

        return RequestAction.REDIRECT + String.format("/admin/movies/%d/change/episodes/update/%d/", movieId, episodeId);
    }




    @RequestMapping(value = "/movies/{id}/change/keywords/", method = RequestMethod.GET)
    public ModelAndView adminChangeKeywordsAndTags(@PathVariable("id") int movieId) {
        ModelAndView modelAndView = new ModelAndView(View.ADMIN_CHANGE_KEYWORDS);
        modelAndView.addObject("listKey", tagService.findAllByMovieId(movieId));
        return modelAndView;
    }

    @RequestMapping(value = "/movies/{id}/change/keywords/add/", method = RequestMethod.POST)
    public String adminChangeKeywordsAndTags(@PathVariable("id") int movieId,
                                                   @RequestParam("keyword") String keyword,
                                                    HttpServletRequest request) {
        Admin admin = (Admin) SessionUtils.getUserWithSession(request);

        Tagname tagname = new Tagname();
        tagname.setName(keyword);
        tagname.setCode(Text.getUrlCodeIgnoreAccents(keyword));
        tagname.setAuthor(admin);
        Movie movie = new Movie();
        movie.setId(movieId);
        tagname.setMovie(movie);
        tagService.save(tagname);
        return RequestAction.REDIRECT + String.format("/admin/movies/%d/change/keywords/", movieId);
    }

    @RequestMapping(value = "/movies/{id}/change/keywords/delete/{tagId}/", method = RequestMethod.GET)
    public String adminChangeKeywordsAndTags(@PathVariable("id") int movieId,
                                                   @PathVariable("tagId") int tagId) {
        tagService.delete(tagId);
        return RequestAction.REDIRECT + String.format("/admin/movies/%d/change/keywords/", movieId);
    }


}
