package com.streammovies.service.impl;

import com.streammovies.dao.dao.ICategoryDAO;
import com.streammovies.model.movies.Category;
import com.streammovies.service.ICategoryService;
import com.streammovies.service.IMapperORM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements ICategoryService {

    @Autowired
    private ICategoryDAO categoryDAO;

    @Autowired
    private IMapperORM<Category> mapperORM;

    @Override
    public boolean update(Category member) {
        return false;
    }

    @Override
    public Category save(Category member) {
        return categoryDAO.insert(member);
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public List<Category> findAll() {
        return (List<Category>) mapperORM.mapping(categoryDAO.findAll());
    }

    @Override
    public List<Category> findAllByMovieCode(String code) {
        return (List<Category>) mapperORM.mapping(categoryDAO.findAllByMovieCode(code));
    }

    @Override
    public Category findOne(String code) {
        return categoryDAO.findOne(code);
    }

    @Override
    public List<Category> findAllByMovieId(int id) {
        return categoryDAO.findAllByMovieId(id);
    }
}
