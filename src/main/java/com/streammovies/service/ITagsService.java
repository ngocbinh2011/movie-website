package com.streammovies.service;

import com.streammovies.model.movies.Tagname;
import com.streammovies.service.IGeneralService;
import com.streammovies.service.IModelService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ITagsService extends IGeneralService<Tagname>, IModelService<Tagname> {
    List<Tagname> findAllByMovieId(int id);
}
