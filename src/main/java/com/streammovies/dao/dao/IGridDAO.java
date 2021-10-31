package com.streammovies.dao.dao;

import com.streammovies.dao.api.IServiceDAO;
import com.streammovies.model.present.Grid;
import org.springframework.stereotype.Repository;

@Repository
public interface IGridDAO extends IServiceDAO<Grid> {
    Grid findOne(int gridId);
}
