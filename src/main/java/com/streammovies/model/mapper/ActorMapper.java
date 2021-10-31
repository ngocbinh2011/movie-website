package com.streammovies.model.mapper;

import com.streammovies.model.movies.Actor;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class ActorMapper implements IMapper<Actor>{
    @Override
    public Actor mapping(ResultSet resultSet) {
        Actor actor = new Actor();
        try {
            actor.setId(resultSet.getInt("id"));
            actor.setCode(resultSet.getString("code"));
            actor.setName(resultSet.getString("name"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return actor;
    }
}
