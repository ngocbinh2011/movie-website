package com.streammovies.service.impl;

import com.streammovies.dao.dao.IComplexityRelationDAO;
import com.streammovies.dao.dao.impl.MovieActorDAO;
import com.streammovies.service.IManyToManyRelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieActorService implements IManyToManyRelationService {

    @Autowired
    private MovieActorDAO movieActorDAO;

    @Override
    public boolean save(int movieId, int actorId) {
        return movieActorDAO.insert(movieId, actorId);
    }

    @Override
    public boolean delete(int movieId, int actorId) {
        return movieActorDAO.delete(movieId, actorId);
    }
}
