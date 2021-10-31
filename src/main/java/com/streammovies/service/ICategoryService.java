package com.streammovies.service;

import com.streammovies.model.movies.Category;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ICategoryService extends IGeneralService<Category>, IModelService<Category>{
    Category findOne(String code);
    List<Category> findAllByMovieId(int id);
}
