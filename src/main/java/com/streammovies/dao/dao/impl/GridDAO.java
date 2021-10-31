package com.streammovies.dao.dao.impl;

import com.streammovies.dao.api.ServiceDAO;
import com.streammovies.dao.dao.IGridDAO;
import com.streammovies.model.mapper.IMapper;
import com.streammovies.model.present.Grid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class GridDAO extends ServiceDAO<Grid> implements IGridDAO {

    @Autowired
    private IMapper<Grid> mapper;

    @Override
    public Grid findOne(int gridId) {
        String sql = "SELECT * FROM grid_view WHERE id = ?";
        List<Grid> result = query(sql, mapper, gridId);
        return result.isEmpty()? null : result.get(0);
    }
}
