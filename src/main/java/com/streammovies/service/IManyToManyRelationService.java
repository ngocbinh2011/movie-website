package com.streammovies.service;

public interface IManyToManyRelationService {
    boolean save(int firstEntityId, int secondEntityId);
    boolean delete(int firstEntityId, int secondEntityId);
}
