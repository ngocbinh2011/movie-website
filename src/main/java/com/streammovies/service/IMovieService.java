package com.streammovies.service;

import com.streammovies.model.movies.Movie;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public interface IMovieService extends IModelService<Movie>, IGeneralService<Movie>{
    Movie findOne(int id);
    Movie findOne(String movieCode);
    List<Movie> search(String research);
    List<Movie> findAllByCategory(String categoryCode);
    List<Movie> findAllByActorCode(String actorCode);
    List<Movie> findAllByNationalCode(String nationalCode);
    List<Movie> findAllByYearPublish(int year);
    List<Movie> findAllByName(String name);
    List<Movie> findAllByGridId(int gridId);
    List<Movie> getMoviePagination(int page, List<Movie> list);
    List<Movie> findAllByCategoryAndYear(String categoryCode, int year);
    List<Movie> findAllByCategoryAndNational(String categoryCode, String nationalCode);
    List<Movie> findAllOrderByIMDB();
    List<Movie> findAllOrdered(Comparator<Movie> comparator);
    List<Movie> findLimitMovieBestViewByCategory(String categoryCode, int limit);
    List<Movie> findLimitMovieStartWithName(Movie movie, int limit);
    List<Movie> findAllMovieByDirector(String directorName);
    List<Movie> mappingORM(List<Movie> list);
    Movie mappingORM(Movie movie);
    boolean updateCurrentEpisode(int id);
    boolean updateView(String movieCode);
}
