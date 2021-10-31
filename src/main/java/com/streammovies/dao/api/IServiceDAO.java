package com.streammovies.dao.api;

import com.streammovies.model.mapper.IMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IServiceDAO<T> {

     List<T> query(String sql, IMapper<T> mapper, Object... member);

     boolean insert(String sql, Object... member);

     boolean update(String sql, Object... member);

     boolean delete(String sql, Object... member);
}
