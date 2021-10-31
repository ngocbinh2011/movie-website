package com.streammovies.dao.dao.impl;

import com.streammovies.dao.api.ServiceDAO;
import com.streammovies.dao.dao.IComplexityRelationDAO;
import org.springframework.stereotype.Repository;

@Repository
public class MovieGridViewDAO extends ServiceDAO implements IComplexityRelationDAO {
    @Override
    public boolean insert(int movieId, int gridId) {
        String sql = "INSERT INTO movie_gridview(movie_id, grid_view_id) VALUES(?,?)";
        return insert(sql, movieId, gridId);
    }

    @Override
    public boolean delete(int movieId, int gridId) {
        String sql = "DELETE FROM movie_gridview WHERE movie_id = ? AND grid_view_id = ?";
        return delete(sql, movieId, gridId);
    }
}
