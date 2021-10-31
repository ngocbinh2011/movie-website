package com.streammovies.service.impl;

import com.streammovies.dao.dao.*;
import com.streammovies.model.movies.Episode;
import com.streammovies.model.movies.Link;
import com.streammovies.model.movies.Movie;
import com.streammovies.service.IMapperORM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Component
public class MovieMapperORM implements IMapperORM<Movie> {

    @Autowired
    private IActorDAO actorDAO;

    @Autowired
    private IAdminDAO adminDAO;

    @Autowired
    private ICategoryDAO categoryDAO;

    @Autowired
    private IEpisodeDAO episodeDAO;

    @Autowired
    private ILinkDAO linkDAO;

    @Autowired
    private INationalDAO nationalDAO;

    @Autowired
    private ITagnameDAO tagnameDAO;

    @Override
    public Movie mapping(Movie object) {
        int movieId = object.getId();
        object.setNational(nationalDAO.findOneByMovieId(movieId));
        object.setListTagname(tagnameDAO.findAllByMovieId(movieId));
        object.setListCategory(categoryDAO.findAllByMovieId(movieId));
        object.setListActor(actorDAO.findAllByMovieId(movieId));
        return object;
    }

    @Override
    public Collection<Movie> mapping(Collection<Movie> collection) {
        for(Movie movie: collection){
            movie = mapping(movie);
        }
        return collection;
    }
}
