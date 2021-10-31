package com.streammovies.model.mapper;

import com.streammovies.model.movies.National;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class NationalMapper implements IMapper<National>{
    @Override
    public National mapping(ResultSet resultSet) {
        National national = new National();
        try {
            national.setId(resultSet.getInt("id"));
            national.setName(resultSet.getString("name"));
            national.setCode(resultSet.getString("code"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return national;
    }
}
