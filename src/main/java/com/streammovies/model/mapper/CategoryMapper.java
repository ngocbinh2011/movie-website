package com.streammovies.model.mapper;

import com.streammovies.model.movies.Category;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class CategoryMapper implements IMapper<Category>{
    @Override
    public Category mapping(ResultSet resultSet) {
        Category category = new Category();
        try {
            category.setId(resultSet.getInt("id"));
            category.setCode(resultSet.getString("code"));
            category.setName(resultSet.getString("name"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return category;
    }
}
