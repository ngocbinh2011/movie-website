package com.streammovies.service;

import com.streammovies.model.movies.Actor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IActorService extends IGeneralService<Actor>, IModelService<Actor>{
    Actor findOne(String actorCode);
    Actor findOne(int actorId);
    List<Actor> findAllByMovieId(int id);
}
