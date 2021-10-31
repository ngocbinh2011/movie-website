package com.streammovies.dao.dao.impl;

import com.streammovies.dao.api.ServiceDAO;
import com.streammovies.dao.dao.ITagnameDAO;
import com.streammovies.model.admin.Admin;
import com.streammovies.model.mapper.IMapper;
import com.streammovies.model.movies.Tagname;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TagnameDAO extends ServiceDAO<Tagname> implements ITagnameDAO {

    @Autowired
    private IMapper<Tagname> mapper;

    @Override
    public List<Tagname> findAll() {
        return null;
    }

    @Override
    public List<Tagname> findAllByMovieCode(String movieCode) {
        String sql = "SELECT T.* FROM movie_tag AS T\n" +
                "INNER JOIN movie AS M ON M.id = T.movie_id WHERE M.code = ?";
        List<Tagname> result = query(sql, mapper, movieCode);
        return result;
    }

    @Override
    public List<Tagname> findAllByMovieId(int movieId) {
        String sql = "SELECT T.* FROM movie_tag AS T\n" +
                "INNER JOIN movie AS M ON M.id = T.movie_id WHERE M.id = ?";
        List<Tagname> result = query(sql, mapper, movieId);
        return result;
    }



    @Override
    public boolean update(Tagname member) {
        return false;
    }

    @Override
    public Tagname insert(Tagname member) {
        String sql = "INSERT INTO movie_tag(NAME, CODE, MOVIE_ID, AUTHOR_ID) VALUES(?,?,?,?)";
        boolean isSuccess = insert(sql, member.getName(), member.getCode(),
                member.getMovie().getId(), member.getAuthor().getId());
        return isSuccess? member : null;
    }

    @Override
    public boolean delete(int id) {
        String sql = "DELETE FROM movie_tag WHERE id = ?";
        return delete(sql, id);
    }
}
