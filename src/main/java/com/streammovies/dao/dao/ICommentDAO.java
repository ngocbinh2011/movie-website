package com.streammovies.dao.dao;

import com.streammovies.dao.api.IServiceDAO;
import com.streammovies.model.movies.Comment;

import java.util.List;

public interface ICommentDAO extends IServiceDAO<Comment>, IModelDAO<Comment>{
    List<Comment> findAll(int userId);

}
