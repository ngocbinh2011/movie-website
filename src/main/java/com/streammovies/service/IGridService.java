package com.streammovies.service;

import com.streammovies.model.present.Grid;

public interface IGridService extends IGeneralService<Grid>{
    Grid getGrid(int gridId);
}
