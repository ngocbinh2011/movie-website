package com.streammovies.service.impl;

import com.streammovies.dao.dao.*;
import com.streammovies.model.movies.Movie;
import com.streammovies.service.IMapperORM;
import com.streammovies.service.IMovieService;
import com.streammovies.utils.CategoryConst;
import com.streammovies.utils.SystemConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.regex.Pattern;

@Service
public class MovieService implements IMovieService {

    @Autowired
    private IMovieDAO movieDAO;

    @Autowired
    private IMapperORM<Movie> mapperORM;

    @Override
    public List<Movie> findAll() {
        return movieDAO.findAll();
    }

    @Override
    public List<Movie> findAllByMovieCode(String code) {
        return movieDAO.findAllByMovieCode(code);
    }

    @Override
    public Movie findOne(int id) {
        return movieDAO.findOne(id);
    }

    @Override
    public Movie findOne(String movieCode) {
        return movieDAO.findOne(movieCode);
    }

    @Override
    public List<Movie> search(String research) {
        return movieDAO.search(research);
    }

    @Override
    public List<Movie> findAllByCategory(String categoryCode) {
        return movieDAO.findAllByCategory(categoryCode);
    }

    @Override
    public List<Movie> findAllByActorCode(String actorCode) {
        return movieDAO.findAllByActorCode(actorCode);
    }

    @Override
    public List<Movie> findAllByNationalCode(String nationalCode) {
        return movieDAO.findAllByNationalCode(nationalCode);
    }

    @Override
    public List<Movie> findAllByYearPublish(int year) {
        return movieDAO.findAllByYearPublish(year);
    }

    @Override
    public List<Movie> findAllByName(String name) {
        return movieDAO.findAllMovieByName(name);
    }

    @Override
    public List<Movie> findAllByGridId(int gridId) {
        return movieDAO.findAllByGridId(gridId);
    }

    @Override
    public List<Movie> getMoviePagination(int page, List<Movie> list) {
        int low = (page - 1) * SystemConstant.SIZE_PAGE;
        int high = page * SystemConstant.SIZE_PAGE;
        if(list == null || low >= list.size()){
            return new ArrayList<>();
        }
        if(list.isEmpty()){
            return list;
        }
        if(high > list.size()){
            high = list.size();
        }
        return list.subList(low, high);
    }

    @Override
    public List<Movie> findAllByCategoryAndYear(String categoryCode, int year) {
        List<Movie> listMovie = findAllByCategory(categoryCode);
        List<Movie> result = new ArrayList<>();
        for(Movie movie: listMovie){
            if(movie.getYearPublish() == year){
                result.add(movie);
            }
        }
        return result;
    }

    @Override
    public List<Movie> findAllByCategoryAndNational(String categoryCode, String nationalCode) {
        List<Movie> listMovieByCategory = findAllByCategory(categoryCode);
        List<Movie> listMovieByNational = findAllByNationalCode(nationalCode);
        Map<Integer, Movie> map = new LinkedHashMap<>();
        for(Movie movie: listMovieByCategory){
            map.put(movie.getId(), movie);
        }
        List<Movie> result = new ArrayList<>();
        for(Movie movie: listMovieByNational){
            if(map.containsKey(movie.getId())){
                result.add(movie);
            }
        }
        return result;
    }

    @Override
    public List<Movie> findAllOrderByIMDB() {
        return findAllOrdered(new Comparator<Movie>() {
            @Override
            public int compare(Movie o1, Movie o2) {
                if(o1.getImdbScore() == o2.getImdbScore()){
                    return 0;
                }
                return o1.getImdbScore() < o2.getImdbScore()? 1 : -1;
            }
        });
    }

    @Override
    public List<Movie> findAllOrdered(Comparator<Movie> comparator) {
        List<Movie> list = findAll();
        Collections.sort(list, comparator);
        return list;
    }

    @Override
    public List<Movie> findLimitMovieBestViewByCategory(String categoryCode, int limit) {
        return movieDAO.findLimitMovieBestViewByCategory(categoryCode, limit);
    }

    @Override
    public List<Movie> findLimitMovieStartWithName(Movie movie, int limit) {
        String subName = getSubName(movie.getName());
        List<Movie> list = movieDAO.findLimitMovieStartWithSubName(subName, limit);
        List<Movie> result = new ArrayList<>();
        for(Movie mov: list){
            if(mov.getId() != movie.getId()){
                result.add(mov);
            }
        }
        return result;
    }

    @Override
    public List<Movie> findAllMovieByDirector(String directorName) {
        return movieDAO.findAllMovieByDirector(directorName);
    }

    // get subCode from movie Code
    private String getSubName(String movieName){
        final int NUMBER_SUBSTRING = 3;// 3 is amount substring need to split
        int size = movieName.length();
        int pos = size / NUMBER_SUBSTRING;
        return movieName.substring(0, pos);
    }


    @Override
    public List<Movie> mappingORM(List<Movie> list) {
        return (List<Movie>) mapperORM.mapping(list);
    }

    @Override
    public Movie mappingORM(Movie movie) {
        return mapperORM.mapping(movie);
    }

    @Override
    public boolean updateCurrentEpisode(int id) {
        return movieDAO.updateCurrentEpisode(id);
    }

    @Override
    public boolean updateView(String movieCode) {
        return movieDAO.updateView(movieCode);
    }


    @Override
    public boolean update(Movie member) {
        return movieDAO.update(member);
    }

    @Override
    public Movie save(Movie member) {
        return movieDAO.insert(member);
    }

    @Override
    public boolean delete(int id) {
        return movieDAO.delete(id);
    }
}
