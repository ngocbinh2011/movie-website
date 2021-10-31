package com.streammovies.model.mapper;

import com.streammovies.model.movies.Category;
import com.streammovies.model.movies.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class MovieMapper implements IMapper<Movie>{

    @Override
    public Movie mapping(ResultSet resultSet) {
        Movie movie = new Movie();
        try {
            movie.setId(resultSet.getInt("id"));
            movie.setName(resultSet.getString("name"));
            movie.setCode(resultSet.getString("code"));
            movie.setTrailerLink(resultSet.getString("trailer_link"));
            movie.setDirector(resultSet.getString("director"));
            movie.setYearPublish(resultSet.getInt("year_publish"));
            movie.setAmountEpisode(resultSet.getInt("amount_episode"));
            movie.setShortContent(resultSet.getString("short_content"));
            movie.setMainContent(resultSet.getString("main_content"));
            movie.setImageLinkPoster(resultSet.getString("image_present"));
            movie.setImageLinkMain(resultSet.getString("image_link"));
            movie.setImdbScore(resultSet.getDouble("imdb_score"));
            movie.setAmountView(resultSet.getInt("view"));
            movie.setCreateDate(resultSet.getDate("create_date"));
            movie.setUpdateDate(resultSet.getDate("update_date"));
            movie.setCurrentEpisode(resultSet.getInt("current_episode"));
            movie.setEnglishName(resultSet.getString("english_name"));
            movie.setMinutes(resultSet.getInt("time"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return movie;
    }
}
