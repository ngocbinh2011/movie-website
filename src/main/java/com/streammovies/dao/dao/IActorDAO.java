package com.streammovies.dao.dao;

import com.streammovies.dao.api.IServiceDAO;
import com.streammovies.model.movies.Actor;
import com.streammovies.model.movies.Movie;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IActorDAO extends IServiceDAO<Actor>, IModelDAO<Actor>, IActionDAO<Actor>{
    Actor findOne(String actorCode);
    Actor findOne(int actorId);
}
