package com.streammovies.model.mapper;

import com.streammovies.model.movies.Movie;
import com.streammovies.model.present.MovieSlider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class MovieSliderMapper implements IMapper<MovieSlider>{

    @Override
    public MovieSlider mapping(ResultSet resultSet) {
        MovieSlider movieSlider = new MovieSlider();
        Movie movie = new Movie();
        try {
            movie.setId(resultSet.getInt("M.id"));
            movie.setName(resultSet.getString("name"));
            movie.setCode(resultSet.getString("code"));
            movie.setShortContent(resultSet.getString("short_content"));
            movie.setMainContent(resultSet.getString("main_content"));
            movieSlider.setMovie(movie);
            movieSlider.setId(resultSet.getInt("S.id"));
            movieSlider.setImageLinkSlider(resultSet.getString("image_slider"));
            movieSlider.setUpdateDate(resultSet.getDate("update_date"));
            movieSlider.setOrder(resultSet.getInt("order"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return movieSlider;
    }
}
