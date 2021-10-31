package com.streammovies.service;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IModelService<T> {
    List<T> findAll();

    List<T> findAllByMovieCode(String code);
}
