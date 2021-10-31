package com.streammovies.dao.dao;

import com.streammovies.dao.api.IServiceDAO;
import com.streammovies.model.movies.Link;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ILinkDAO extends IServiceDAO<Link>, IModelDAO<Link>, IActionDAO<Link>{
    List<Link> findAllByMovieCode(String movieCode, String episodeCode);

    List<Link> findAllByEpisodeId(int episodeId);

}
