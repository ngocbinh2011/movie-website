package com.streammovies.dao.dao;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IModelDAO<T> {
    List<T> findAll();

    List<T> findAllByMovieCode(String movieCode);

    List<T> findAllByMovieId(int movieId);

}
