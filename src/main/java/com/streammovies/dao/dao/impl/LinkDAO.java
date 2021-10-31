package com.streammovies.dao.dao.impl;

import com.streammovies.dao.api.ServiceDAO;
import com.streammovies.dao.dao.IActionDAO;
import com.streammovies.dao.dao.ILinkDAO;
import com.streammovies.model.admin.Admin;
import com.streammovies.model.mapper.IMapper;
import com.streammovies.model.mapper.LinkMapper;
import com.streammovies.model.movies.Actor;
import com.streammovies.model.movies.Link;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LinkDAO extends ServiceDAO<Link> implements ILinkDAO{

    @Autowired
    private IMapper<Link> mapper;

    @Override
    public List<Link> findAllByMovieCode(String movieCode, String episodeCode) {
        String sql = "SELECT L.* \n" +
                "FROM movie AS M INNER JOIN episode AS E \n" +
                "ON E.movie_id = M.id AND M.code = ? AND E.code = ? \n" +
                "INNER JOIN movie_link AS L ON L.episode_id = E.id";
        List<Link> result = query(sql, mapper, movieCode, episodeCode);
        return result;
    }

    @Override
    public List<Link> findAllByEpisodeId(int episodeId) {
        String sql = "SELECT * FROM movie_link WHERE episode_id = ?";
        List<Link> result = query(sql, mapper, episodeId);
        return result;
    }

    @Override
    public List<Link> findAll() {
        return null;
    }

    @Override
    public List<Link> findAllByMovieCode(String movieCode) {
        return null;
    }

    @Override
    public List<Link> findAllByMovieId(int id) {
        return null;
    }



    @Override
    public boolean update(Link member) {
        String sql = "UPDATE MOVIE_LINK SET LINK = ?, UPDATE_DATE = CURRENT_TIMESTAMP, UPDATE_BY = ? WHERE ID = ?";
        return update(sql, member.getUrl(), member.getUpdator().getId(), member.getId());
    }


    @Override
    public Link insert(Link member) {
        String sql = "INSERT INTO movie_link(link, server, episode_id, author_id, " +
                "update_date, update_by, create_date) VALUES(?,?,?,?,CURRENT_TIMESTAMP,?,CURRENT_TIMESTAMP)";
        boolean isSuccess = insert(sql, member.getUrl(), member.getServerId(), member.getEpisode().getId(),
                member.getCreator().getId(), member.getUpdator().getId());
        return isSuccess? member : null;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }


}
