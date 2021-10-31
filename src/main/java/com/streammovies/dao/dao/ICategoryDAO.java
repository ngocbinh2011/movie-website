package com.streammovies.dao.dao;

import com.streammovies.dao.api.IServiceDAO;
import com.streammovies.model.movies.Category;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICategoryDAO extends IServiceDAO<Category>, IModelDAO<Category>, IActionDAO<Category>{
    Category findOne(String categoryCode);

}
