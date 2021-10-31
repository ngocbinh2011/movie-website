package com.streammovies.model.mapper;

import com.streammovies.model.movies.Comment;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class CommentMapper implements IMapper<Comment>{
    @Override
    public Comment mapping(ResultSet resultSet) {
        Comment comment = new Comment();
        try {
            comment.setId(resultSet.getInt("id"));
            comment.setContent(resultSet.getString("content"));
            comment.setCreateDate(resultSet.getDate("create_date"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return comment;
    }
}
