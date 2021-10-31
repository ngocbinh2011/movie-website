package com.streammovies.dao.dao.impl;

import com.streammovies.dao.api.ServiceDAO;
import com.streammovies.dao.dao.IActorDAO;
import com.streammovies.model.admin.Admin;
import com.streammovies.model.mapper.IMapper;
import com.streammovies.model.movies.Actor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public class ActorDAO extends ServiceDAO<Actor> implements IActorDAO {

    @Autowired
    private IMapper<Actor> mapper;

    @Override
    public List<Actor> findAll() {
        String sql = "SELECT * FROM actor";
        List<Actor> result = query(sql, mapper);
        return result;
    }

    @Override
    public List<Actor> findAllByMovieCode(String movieCode) {
        String sql = "SELECT A.* FROM movie AS M\n" +
                "INNER JOIN movie_actor AS MA ON M.id = MA.movie_id AND M.code = ? \n" +
                "INNER JOIN actor AS A ON A.id = MA.actor_id";
        List<Actor> result = query(sql, mapper, movieCode);
        return result;
    }

    @Override
    public List<Actor> findAllByMovieId(int movieId) {
        String sql = "SELECT A.* FROM movie AS M\n" +
                "INNER JOIN movie_actor AS MA ON M.id = MA.movie_id AND M.id = ? \n" +
                "INNER JOIN actor AS A ON A.id = MA.actor_id";
        List<Actor> result = query(sql, mapper, movieId);
        return result;
    }

    @Override
    public Actor findOne(int actorId) {
        String sql = "SELECT * FROM actor WHERE id = ?";
        List<Actor> result = query(sql, mapper, actorId);
        return result.isEmpty()? null : result.get(0);
    }

    @Override
    public boolean update(Actor member) {
        String sql = "UPDATE actor SET name = ?, code = ? WHERE id = ?";
        return update(sql, member.getName(), member.getCode(), member.getId());
    }

    @Override
    public Actor insert(Actor member) {
        String sql = "INSERT INTO actor(name, code, author_id) VALUES(?,?,?)";
        boolean isSuccess = insert(sql, member.getName(), member.getCode(), member.getAuthor().getId());
        return isSuccess? member : null;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }


    @Override
    public Actor findOne(String actorCode) {
        String sql = "SELECT * FROM actor WHERE code = ?";
        List<Actor> result = query(sql, mapper, actorCode);
        return result.isEmpty()? null : result.get(0);
    }
}
