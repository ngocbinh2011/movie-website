package com.streammovies.service.impl;

import com.streammovies.dao.dao.IGridDAO;
import com.streammovies.model.present.Grid;
import com.streammovies.service.IGridService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GridService implements IGridService {

    @Autowired
    private IGridDAO gridDAO;

    @Override
    public boolean update(Grid member) {
        return false;
    }

    @Override
    public Grid save(Grid member) {
        return null;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }



    @Override
    public Grid getGrid(int gridId) {
        return gridDAO.findOne(gridId);
    }
}
