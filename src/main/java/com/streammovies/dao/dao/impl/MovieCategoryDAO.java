package com.streammovies.dao.dao.impl;

import com.streammovies.dao.api.ServiceDAO;
import com.streammovies.dao.dao.IComplexityRelationDAO;
import org.springframework.stereotype.Repository;

@Repository
public class MovieCategoryDAO extends ServiceDAO implements IComplexityRelationDAO {

    @Override
    public boolean insert(int rootId, int manyId) {
        String sql = "INSERT INTO movie_category(movie_id, category_id) VALUES(?,?)";
        return insert(sql, rootId, manyId);
    }

    @Override
    public boolean delete(int movieId, int categoryId) {
        String sql = "DELETE FROM movie_category WHERE movie_id = ? AND category_id = ?";
        return delete(sql, movieId, categoryId);
    }
}