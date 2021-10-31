package com.streammovies.dao.dao.impl;

import com.streammovies.dao.api.ServiceDAO;
import com.streammovies.dao.dao.*;
import com.streammovies.model.admin.Admin;
import com.streammovies.model.mapper.EpisodeMapper;
import com.streammovies.model.mapper.IMapper;
import com.streammovies.model.movies.Episode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public class EpisodeDAO extends ServiceDAO<Episode> implements IEpisodeDAO{

    @Autowired
    private IMapper<Episode> mapper;

    @Override
    public List<Episode> findAll() {
        String sql = "SELECT * FROM episode";
        List<Episode> result = query(sql, mapper);
        return result;
    }

    @Override
    public List<Episode> findAllByMovieCode(String movieCode) {
        String sql = "SELECT E.* \n" +
                "FROM EPISODE AS E INNER JOIN MOVIE AS M ON E.MOVIE_ID = M.ID\n" +
                "WHERE M.CODE = ? ORDER BY E.ID";
        List<Episode> result = query(sql, mapper, movieCode);
        return result;
    }

    @Override
    public List<Episode> findAllByMovieId(int movieId) {
        String sql = "SELECT E.* \n" +
                "FROM EPISODE AS E INNER JOIN MOVIE AS M ON E.MOVIE_ID = M.ID\n" +
                "WHERE M.id = ?";
        List<Episode> result = query(sql, mapper, movieId);
//        System.out.println(result);
        return result;
    }

    @Override
    public boolean update(Episode member) {
        return false;
    }

    @Override
    public Episode insert(Episode member) {
        String sql = "INSERT INTO episode(episode_number, code, movie_id, create_date, author_id, " +
                "update_date, update_by) VALUES(?,?,?,CURRENT_TIMESTAMP,?,CURRENT_TIMESTAMP,?)";
        boolean isSuccess = insert(sql, member.getEpisodeNumber(), member.getCode(), member.getMovie().getId(),
                member.getCreator().getId(), member.getUpdator().getId());
        return isSuccess? member : null;
    }

    @Override
    public boolean delete(int id) {
        String sql = "DELETE FROM episode WHERE ID = ?";
        return delete(sql, id);
    }


    @Override
    public Episode findOne(int episodeId) {
        String sql = "SELECT * FROM episode WHERE ID = ?";
        List<Episode> result = query(sql, mapper, episodeId);
        if(result.isEmpty()){
            return null;
        }
        return result.get(0);
    }
}
