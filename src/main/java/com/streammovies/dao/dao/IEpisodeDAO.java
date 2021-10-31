package com.streammovies.dao.dao;

import com.streammovies.dao.api.IServiceDAO;
import com.streammovies.model.movies.Episode;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IEpisodeDAO extends IServiceDAO<Episode>, IModelDAO<Episode>, IActionDAO<Episode>{
    Episode findOne(int episodeId);
}
