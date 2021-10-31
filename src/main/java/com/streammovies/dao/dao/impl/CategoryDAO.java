package com.streammovies.dao.dao.impl;

import com.streammovies.dao.api.IServiceDAO;
import com.streammovies.dao.api.ServiceDAO;
import com.streammovies.dao.dao.IActionDAO;
import com.streammovies.dao.dao.ICategoryDAO;
import com.streammovies.model.admin.Admin;
import com.streammovies.model.mapper.CategoryMapper;
import com.streammovies.model.mapper.IMapper;
import com.streammovies.model.movies.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CategoryDAO extends ServiceDAO<Category> implements ICategoryDAO{

    @Autowired
    private IMapper<Category> mapper;

    @Override
    public List<Category> findAll() {
        String sql = "SELECT * FROM category";
        List<Category> result = query(sql, mapper);
        return result;
    }

    @Override
    public List<Category> findAllByMovieCode(String movieCode) {
        String sql = "SELECT c.*  FROM category as c " +
                "INNER JOIN movie_category AS MC ON MC.category_id = c.id\n" +
                "INNER JOIN movie AS M ON M.ID = MC.movie_id WHERE M.code = ?";
        List<Category> result = query(sql, mapper, movieCode);
        return result;
    }

    @Override
    public List<Category> findAllByMovieId(int movieId) {
        String sql = "SELECT c.*  FROM category as c " +
                "INNER JOIN movie_category AS MC ON MC.category_id = c.id\n" +
                "INNER JOIN movie AS M ON M.ID = MC.movie_id WHERE M.id = ?";
        List<Category> result = query(sql, mapper, movieId);
        return result;
    }




    @Override
    public boolean update(Category member) {
        return false;
    }

    @Override
    public Category insert(Category member) {
        String sql = "INSERT INTO category(name, code, update_by) VALUES(?,?,?)";
        boolean isSuccess = insert(sql, member.getName(), member.getCode(), member.getUpdateBy().getId());
        return isSuccess? member : null;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public Category findOne(String categoryCode) {
        String sql = "SELECT * FROM category WHERE code = ?";
        List<Category> result = query(sql, mapper, categoryCode);
        return result.isEmpty()? null : result.get(0);
    }
}
