package com.streammovies.service;


public interface IGeneralService<T> {
    boolean update(T member);

    T save(T member);

    boolean delete(int id);
}
