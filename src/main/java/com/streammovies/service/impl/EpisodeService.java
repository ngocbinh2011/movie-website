package com.streammovies.service.impl;

import com.google.protobuf.Enum;
import com.streammovies.dao.dao.IEpisodeDAO;
import com.streammovies.model.movies.Episode;
import com.streammovies.model.movies.Movie;
import com.streammovies.service.IEpisodeService;
import com.streammovies.service.IMapperORM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EpisodeService implements IEpisodeService {

    @Autowired
    private IEpisodeDAO episodeDAO;

    @Autowired
    private IMapperORM<Episode> mapperORM;

    @Override
    public boolean update(Episode member) {
        return false;
    }

    @Override
    public Episode save(Episode member) {
        if(member == null){
            return null;
        }
        String code = member.getCode();
        if(code == null || code.isEmpty()){
            code = "tap-" + member.getEpisodeNumber();
        }
        Movie movie = member.getMovie();
        if(movie == null){
            return null;
        }
        Episode episode = findOne(movie.getId(), member.getEpisodeNumber());
        if(episode != null){
            return episode;
        }
        Episode eps = episodeDAO.insert(member);
        if(eps != null){
            return findOne(movie.getId(), member.getEpisodeNumber());
        }
        return null;
    }

    @Override
    public boolean delete(int id) {
        return episodeDAO.delete(id);
    }

    @Override
    public List<Episode> findAll() {
        return episodeDAO.findAll();
    }

    @Override
    public List<Episode> findAllByMovieCode(String code) {
        return episodeDAO.findAllByMovieCode(code);
    }

    @Override
    public List<Episode> findAllByMovieId(int id) {
        return episodeDAO.findAllByMovieId(id);
    }

    @Override
    public Episode findOne(int movieId, int episodeNumber) {
        List<Episode> listEpisode = findAllByMovieId(movieId);
        for(Episode episode: listEpisode){
            if(episode.getEpisodeNumber() == episodeNumber){
                return episode;
            }
        }
        return null;
    }

    @Override
    public Episode findOne(int episodeId) {
        return episodeDAO.findOne(episodeId);
    }

}
