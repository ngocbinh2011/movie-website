package com.streammovies.dao.dao.impl;

import com.streammovies.dao.api.IServiceDAO;
import com.streammovies.dao.api.ServiceDAO;
import com.streammovies.dao.dao.IActionDAO;
import com.streammovies.dao.dao.IAdminDAO;
import com.streammovies.dao.dao.INationalDAO;
import com.streammovies.model.admin.Admin;
import com.streammovies.model.mapper.IMapper;
import com.streammovies.model.mapper.NationalMapper;
import com.streammovies.model.movies.Actor;
import com.streammovies.model.movies.National;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class NationalDAO extends ServiceDAO<National> implements INationalDAO{

    @Autowired
    private IMapper<National> mapper;

    @Override
    public List<National> findAll() {
        String sql = "SELECT * FROM national";
        List<National> result = query(sql, mapper);
        return result;
    }

    @Override
    public List<National> findAllByMovieCode(String movieCode) {
        String sql = "SELECT N.* FROM national AS N\n" +
                "INNER JOIN movie AS M ON M.national_id = N.id\n" +
                "WHERE M.code = ?";
        List<National> result = query(sql, mapper, movieCode);
        return result;
    }

    @Override
    public List<National> findAllByMovieId(int movieId) {
        String sql = "SELECT N.* FROM national AS N\n" +
                "INNER JOIN movie AS M ON M.national_id = N.id\n" +
                "WHERE M.id = ?";
        List<National> result = query(sql, mapper, movieId);
        return result;
    }



    @Override
    public National findOneByMovieCode(String movieCode) {
        List<National> result = findAllByMovieCode(movieCode);
        return result.isEmpty()? null : result.get(0);
    }

    @Override
    public National findOneByMovieId(int movieId) {
        List<National> result = findAllByMovieId(movieId);
        return result.isEmpty()? null : result.get(0);
    }

    @Override
    public National findOne(String nationalCode) {
        String sql = "SELECT * FROM national WHERE code = ?";
        List<National> result = query(sql, mapper, nationalCode);
        return result.isEmpty()? null : result.get(0);
    }

    @Override
    public boolean update(National member) {
        return false;
    }

    @Override
    public National insert(National member) {
        String sql = "INSERT INTO national(name, code, author_id) VALUES(?, ?, ?)";
        boolean isSuccess = insert(sql, member.getName(), member.getCode(), member.getAuthor().getId());
        return isSuccess? member : null;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

}
