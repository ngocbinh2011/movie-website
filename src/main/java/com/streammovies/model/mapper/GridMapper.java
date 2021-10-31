package com.streammovies.model.mapper;

import com.streammovies.model.present.Grid;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class GridMapper implements IMapper<Grid>{
    @Override
    public Grid mapping(ResultSet resultSet) {
        Grid grid = new Grid();
        try {
            grid.setId(resultSet.getInt("id"));
            grid.setCode(resultSet.getString("code"));
            grid.setAmountMovie(resultSet.getInt("amount_movie"));
            grid.setName(resultSet.getString("name"));
            grid.setCreateDate(resultSet.getDate("create_date"));
            grid.setUpdateDate(resultSet.getDate("update_date"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return grid;
    }
}
