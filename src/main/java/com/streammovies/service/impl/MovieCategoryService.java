package com.streammovies.service.impl;

import com.streammovies.dao.dao.impl.MovieCategoryDAO;
import com.streammovies.service.IManyToManyRelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieCategoryService implements IManyToManyRelationService {
    @Autowired
    private MovieCategoryDAO movieCategoryDAO;

    @Override
    public boolean save(int movieId, int categoryId) {
        return movieCategoryDAO.insert(movieId, categoryId);
    }

    @Override
    public boolean delete(int movieId, int categoryId) {
        return movieCategoryDAO.delete(movieId, categoryId);
    }
}
