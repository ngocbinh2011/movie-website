package com.streammovies.dao.dao.impl;

import com.streammovies.dao.api.ServiceDAO;
import com.streammovies.dao.dao.IComplexityRelationDAO;
import org.springframework.stereotype.Repository;

@Repository
public class MovieActorDAO extends ServiceDAO implements IComplexityRelationDAO {
    @Override
    public boolean insert(int rootId, int manyId) {
        String sql = "INSERT INTO movie_actor(movie_id, actor_id) VALUES(?,?)";
        return insert(sql, rootId, manyId);
    }

    @Override
    public boolean delete(int movieId, int actorId) {
        String sql = "DELETE FROM movie_actor WHERE movie_id = ? AND actor_id = ?";
        return delete(sql, movieId, actorId);
    }
}
