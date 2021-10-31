package com.streammovies.dao.dao;

public interface IComplexityRelationDAO {
    boolean insert(int firstTableId, int secondTableId);
    boolean delete(int firstTableId, int secondTableId);
}
