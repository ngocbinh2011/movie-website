package com.streammovies.dao.dao;

import com.streammovies.dao.api.IServiceDAO;
import com.streammovies.model.movies.Tagname;
import org.springframework.stereotype.Repository;

@Repository
public interface ITagnameDAO extends IServiceDAO<Tagname>, IModelDAO<Tagname>, IActionDAO<Tagname> {
}
