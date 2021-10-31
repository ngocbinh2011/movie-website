package com.streammovies.model.mapper;

import com.streammovies.model.movies.Episode;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class EpisodeMapper implements IMapper<Episode>{
    @Override
    public Episode mapping(ResultSet resultSet) {
        Episode episode = new Episode();
        try {
            episode.setId(resultSet.getInt("id"));
            episode.setCode(resultSet.getString("code"));
            episode.setEpisodeNumber(resultSet.getInt("episode_number"));
            episode.setCreateDate(resultSet.getDate("create_date"));
            episode.setUpdateDate(resultSet.getDate("update_date"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return episode;
    }
}
