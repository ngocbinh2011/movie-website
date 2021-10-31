package com.streammovies.service;

import com.streammovies.model.movies.National;
import org.springframework.stereotype.Service;

@Service
public interface INationalService extends IGeneralService<National>, IModelService<National>{
    National findOne(String nationalCode);
    National findOneByMovieId(int movieId);
}
