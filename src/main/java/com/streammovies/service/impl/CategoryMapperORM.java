package com.streammovies.service.impl;

import com.streammovies.dao.dao.IAdminDAO;
import com.streammovies.model.movies.Category;
import com.streammovies.model.movies.Movie;
import com.streammovies.service.IMapperORM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class CategoryMapperORM implements IMapperORM<Category> {

    @Autowired
    private IAdminDAO adminDAO;

    @Override
    public Category mapping(Category object) {
//        object.setUpdateBy(adminDAO.findUpdatorByMovieId(object.getId()));
        return object;
    }

    @Override
    public Collection<Category> mapping(Collection<Category> collection) {
//        for(Category category: collection){
//            category = mapping(category);
//        }
        return collection;
    }
}
