package com.streammovies.dao.dao;

import com.streammovies.dao.api.IServiceDAO;
import com.streammovies.model.movies.National;
import org.springframework.stereotype.Repository;

@Repository
public interface INationalDAO extends IServiceDAO<National>, IModelDAO<National>, IActionDAO<National> {
    National findOneByMovieCode(String movieCode);

    National findOneByMovieId(int movieId);

    National findOne(String nationalCode);
}
