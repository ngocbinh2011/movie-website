package com.streammovies.model.mapper;

import com.streammovies.model.movies.Link;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class LinkMapper implements IMapper<Link>{
    @Override
    public Link mapping(ResultSet resultSet) {
        Link link = new Link();
        try {
            link.setId(resultSet.getInt("id"));
            link.setServerId(resultSet.getInt("server"));
            link.setUrl(resultSet.getString("link"));
            link.setCreateDate(resultSet.getDate("create_date"));
            link.setUpdateDate(resultSet.getDate("update_date"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return link;
    }
}
