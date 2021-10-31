package com.streammovies.service;

import com.streammovies.model.movies.Episode;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IEpisodeService extends IGeneralService<Episode>, IModelService<Episode>{
    List<Episode> findAllByMovieId(int id);
    Episode findOne(int movieId, int episodeNumber);
    Episode findOne(int episodeId);
}
