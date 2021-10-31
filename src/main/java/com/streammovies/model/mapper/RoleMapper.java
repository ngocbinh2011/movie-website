package com.streammovies.model.mapper;

import com.streammovies.model.watcher.Role;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class RoleMapper implements IMapper<Role>{


    @Override
    public Role mapping(ResultSet resultSet) {
        Role role = Role.USER;
        try {
            role = Role.valueOf(resultSet.getString("name"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return role;

    }
}
