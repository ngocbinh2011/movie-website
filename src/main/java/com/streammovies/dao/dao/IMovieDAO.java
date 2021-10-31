package com.streammovies.dao.dao;

import com.streammovies.dao.api.IServiceDAO;
import com.streammovies.model.movies.Category;
import com.streammovies.model.movies.Movie;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IMovieDAO extends IServiceDAO<Movie>, IModelDAO<Movie>, IActionDAO<Movie>{
    Movie findOne(int id);
    Movie findOne(String movieCode);
    List<Movie> search(String research);
    List<Movie> findAllByCategory(String categoryCode);
    List<Movie> findAllByActorCode(String actorCode);
    List<Movie> findAllByNationalCode(String nationalCode);
    List<Movie> findAllByYearPublish(int year);
    Movie fineOnebyTagname(String tagCode);
    List<Movie> findAllByGridId(int gridId);
    List<Movie> findAllInSlide();
    List<Movie> findAllWithLikeCode(List<String> listCode, int limit);
    List<Movie> findLimitMovieBestViewByCategory(String categoryCode, int limit);
    List<Movie> findLimitMovieStartWithSubName(String subName, int limit);
    List<Movie> findAllMovieByName(String name);
    List<Movie> findAllMovieByDirector(String directorName);
    boolean updateView(String movieCode);
    boolean updateCurrentEpisode(int id);
}
