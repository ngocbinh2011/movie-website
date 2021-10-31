package com.streammovies.model.mapper;

import com.streammovies.model.movies.Tagname;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class TagnameMapper implements IMapper<Tagname>{
    @Override
    public Tagname mapping(ResultSet resultSet) {
        Tagname tagname = new Tagname();
        try {
            tagname.setId(resultSet.getInt("id"));
            tagname.setCode(resultSet.getString("code"));
            tagname.setName(resultSet.getString("name"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tagname;
    }
}
