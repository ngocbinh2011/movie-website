package com.streammovies.service;

import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public interface IMapperORM<T> {
    T mapping(T object);

    Collection<T> mapping(Collection<T> collection);
}
