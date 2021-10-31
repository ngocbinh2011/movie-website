package com.streammovies.dao.dao.impl;

import com.streammovies.dao.api.IConnection;
import com.streammovies.dao.api.MySqlConnection;
import com.streammovies.dao.api.ServiceDAO;
import com.streammovies.dao.dao.*;
import com.streammovies.model.admin.Admin;
import com.streammovies.model.mapper.IMapper;
import com.streammovies.model.mapper.MovieMapper;
import com.streammovies.model.movies.Category;
import com.streammovies.model.movies.Movie;
import com.streammovies.model.movies.National;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@Repository
public class MovieDAO extends ServiceDAO<Movie> implements IMovieDAO{

    @Autowired
    private IMapper<Movie> mapper;

    @Override
    public Movie findOne(int id) {
        String sql = "SELECT * FROM movie WHERE id = ?";
        List<Movie> result = query(sql, new MovieMapper(), id);
        return result.isEmpty()? null : result.get(0);
    }

    @Override
    public Movie findOne(String code) {
        List<Movie> result = findAllByMovieCode(code);
        return result.isEmpty()? null : result.get(0);
    }

    @Override
    public List<Movie> search(String research) {
        String sql = "SELECT * FROM movie WHERE name LIKE ?";
        List<Movie> result = query(sql, mapper, '%' + research + '%');
        return result;
    }

    @Override
    public List<Movie> findAll() {
        String sql = "SELECT * FROM movie";
        List<Movie> result = query(sql, mapper);
        return result;
    }

    @Override
    public List<Movie> findAllByMovieCode(String movieCode) {
        String sql = "SELECT * FROM movie WHERE code = ?";
        List<Movie> result = query(sql, mapper, movieCode);
        return result;
    }

    @Override
    public List<Movie> findAllByMovieId(int id) {
        return null;
    }

    @Override
    public List<Movie> findAllByCategory(String categoryCode) {
        String sql = "SELECT M.*\n" +
                "FROM category AS C INNER JOIN movie_category AS MC\n" +
                "ON MC.category_id = C.id AND C.code = ? \n" +
                "INNER JOIN movie AS M ON M.id = MC.movie_id";
        List<Movie> result = query(sql, mapper, categoryCode);
        return result;
    }

    @Override
    public List<Movie> findAllByActorCode(String actorCode) {
        String sql = "SELECT M.*\n" +
                "FROM actor AS A INNER JOIN movie_actor AS MA \n" +
                "ON MA.actor_id = A.id AND A.code = ? \n" +
                "INNER JOIN movie AS M ON M.id = MA.movie_id";
        List<Movie> result = query(sql, mapper, actorCode);
        return result;
    }

    @Override
    public List<Movie> findAllByNationalCode(String nationalCode) {
        String sql = "SELECT M.*\n" +
                "FROM movie AS M INNER JOIN national AS N ON N.id = M.national_id\n" +
                "WHERE N.code = ? ";
        List<Movie> result = query(sql, mapper, nationalCode);
        return result;
    }

    @Override
    public List<Movie> findAllByYearPublish(int year) {
        String sql = "SELECT * FROM movie AS M WHERE M.year_publish = ?";
        List<Movie> result = query(sql, mapper, year);
        return result;
    }

    @Override
    public Movie fineOnebyTagname(String tagCode) {
        String sql = "SELECT M.* " +
                "FROM movie AS M INNER JOIN movie_tag AS T ON T.movie_id = M.id\n" +
                "WHERE T.code = ?";
        List<Movie> result = query(sql, mapper, tagCode);
        return result.isEmpty()? null : result.get(0);
    }

    @Override
    public List<Movie> findAllByGridId(int gridId) {
        String sql = "SELECT * FROM movie AS M INNER JOIN movie_gridview AS G ON G.movie_id = M.id\n" +
                "WHERE G.grid_view_id = ?";
        List<Movie> result = query(sql, mapper, gridId);
        return result;
    }

    @Override
    public List<Movie> findAllInSlide() {
        return null;
    }


    // this method will return list Movie have code same all or one per and max <limit> record;
    @Override
    public List<Movie> findAllWithLikeCode(List<String> listCode, int limit) {
        return null;
    }


    // this method will return list movie have category, most viewed and max <limit> record;
    @Override
    public List<Movie> findLimitMovieBestViewByCategory(String categoryCode, int limit) {
        String sql = "SELECT M.* FROM category AS C INNER JOIN movie_category AS MC " +
                "ON MC.category_id = C.id AND C.code = ?\n" +
                "INNER JOIN movie AS M ON M.id = MC.movie_id " +
                "ORDER BY VIEW DESC LIMIT ?";
        List<Movie> result = query(sql, mapper, categoryCode, limit);
        return result;
    }

    // this method return list movie have code start with subCode;
    @Override
    public List<Movie> findLimitMovieStartWithSubName(String subName, int limit) {
        String sql = "SELECT * FROM MOVIE AS M WHERE M.name LIKE ? " +
                "UNION SELECT * FROM MOVIE AS T WHERE T.name LIKE ? LIMIT ?";
        List<Movie> result =
                query(sql, mapper, subName + '%', String.valueOf(subName.charAt(0)) + '%', limit + 1); // limit + 1 because result have current movie
        return result;
    }

    @Override
    public List<Movie> findAllMovieByName(String name) {
        String sql = "SELECT * FROM MOVIE AS M WHERE M.name LIKE ? ";
        List<Movie> result =
                query(sql, mapper, "%" + name + "%");
        return result;
    }

    @Override
    public List<Movie> findAllMovieByDirector(String directorName) {
        String sql = "SELECT * FROM MOVIE AS M WHERE director = ?";
        List<Movie> result =
                query(sql, mapper, directorName);
        return result;
    }

    @Override
    public boolean updateView(String movieCode) {
        String sql = "UPDATE MOVIE SET view = view + 1 WHERE CODE = ?";
        return update(sql, movieCode);
    }

    @Override
    public boolean updateCurrentEpisode(int id) {
        String sql = "UPDATE movie SET current_episode = " +
                "(SELECT COUNT(ID) FROM EPISODE WHERE MOVIE_ID = ?) WHERE ID = ?";
        return update(sql, id, id);
    }

    @Override
    public boolean update(Movie member) {
        String sql = "UPDATE MOVIE SET name = ?, code = ?, trailer_link = ?, director = ?, " +
                "year_publish = ?, amount_episode = ?, short_content = ?,\n" +
                "main_content = ?, image_present = ?, image_link = ?, imdb_score = ?, " +
                "national_id = ?, author_id = ?,\n" +
                "update_date = CURRENT_TIMESTAMP, update_by = ?, english_name = ?, time = ? WHERE id = ?";
        return update(sql, member.getName(), member.getCode(), member.getTrailerLink(), member.getDirector(), member.getYearPublish(),
                member.getAmountEpisode(), member.getShortContent(), member.getMainContent(), member.getImageLinkPoster(),
                member.getImageLinkMain(), member.getImdbScore(), member.getNational().getId(),
                member.getCreator().getId(), member.getUpdator().getId(),
                member.getEnglishName(), member.getMinutes(), member.getId());
    }

    @Override
    public Movie insert(Movie member) {
        String sql = "INSERT INTO MOVIE(name, code, trailer_link, director, year_publish, amount_episode, \n" +
                "short_content, main_content, image_present, image_link, imdb_score, view, \n" +
                "national_id, author_id, create_date, update_date, update_by, english_name, time) \n" +
                "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,?,?, ?)";
        Admin creator = member.getCreator();
        Admin updator = member.getUpdator();
        National national = member.getNational();
        boolean isSuccess = insert(sql, member.getName(), member.getCode(), member.getTrailerLink(), member.getDirector(), member.getYearPublish(),
                member.getAmountEpisode(), member.getShortContent(), member.getMainContent(), member.getImageLinkPoster(),
                member.getImageLinkMain(), member.getImdbScore(), member.getAmountView(), national.getId(),
                creator.getId(), updator.getId(), member.getEnglishName(), member.getMinutes());
        return isSuccess? member : null;
    }

    @Override
    public boolean delete(int id) {
        String sql = "DELETE FROM movie WHERE ID = ?";
        return delete(sql, id);
    }



}
