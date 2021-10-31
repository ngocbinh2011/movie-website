package com.streammovies.service.impl;

import com.streammovies.dao.dao.INationalDAO;
import com.streammovies.model.movies.National;
import com.streammovies.service.INationalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NationalService implements INationalService {

    @Autowired
    private INationalDAO nationalDAO;

    @Override
    public boolean update(National member) {
        return false;
    }

    @Override
    public National save(National member) {
        return null;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public List<National> findAll() {
        return nationalDAO.findAll();
    }

    @Override
    public List<National> findAllByMovieCode(String code) {
        return nationalDAO.findAllByMovieCode(code);
    }

    @Override
    public National findOne(String nationalCode) {
        return nationalDAO.findOne(nationalCode);
    }

    @Override
    public National findOneByMovieId(int movieId) {
        return nationalDAO.findOneByMovieId(movieId);
    }
}
