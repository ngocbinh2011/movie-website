package com.streammovies.service.impl;

import com.streammovies.dao.dao.impl.MovieGridViewDAO;
import com.streammovies.service.IManyToManyRelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieGridViewService implements IManyToManyRelationService {

    @Autowired
    private MovieGridViewDAO movieGridViewDAO;

    @Override
    public boolean save(int movieId, int gridId) {
        return movieGridViewDAO.insert(movieId, gridId);
    }

    @Override
    public boolean delete(int movieId, int gridId) {
        return movieGridViewDAO.delete(movieId, gridId);
    }
}
