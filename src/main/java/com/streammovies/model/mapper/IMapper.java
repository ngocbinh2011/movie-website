package com.streammovies.model.mapper;

import org.springframework.stereotype.Component;

import java.sql.ResultSet;

@Component
public interface IMapper<T> {
    public T mapping(ResultSet resultSet);
}
