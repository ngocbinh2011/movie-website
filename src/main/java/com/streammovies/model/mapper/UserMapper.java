package com.streammovies.model.mapper;

import com.streammovies.model.watcher.User;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class UserMapper implements IMapper<User>{
    @Override
    public User mapping(ResultSet resultSet) {
        User user = new User();
        try {
            user.setId(resultSet.getInt("id"));
            user.setUsername(resultSet.getString("u_username"));
            user.setPassword(resultSet.getString("u_password"));
            user.setDateCreate(resultSet.getDate("create_date"));
            user.setUpdateDate(resultSet.getDate("update_date"));
            user.setHoursView(resultSet.getInt("hours_view"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
}
