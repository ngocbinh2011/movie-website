package com.streammovies.model.mapper;

import com.streammovies.model.admin.Admin;
import com.streammovies.model.watcher.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class AdminMapper implements IMapper<Admin>{
    @Override
    public Admin mapping(ResultSet resultSet) {
        Admin admin = new Admin();
        try {
            admin.setId(resultSet.getInt("id"));
            admin.setUsername(resultSet.getString("u_username"));
            admin.setPassword(resultSet.getString("u_password"));
            admin.setDateCreate(resultSet.getDate("create_date"));
            admin.setUpdateDate(resultSet.getDate("update_date"));
            admin.setHoursView(resultSet.getInt("hours_view"));
            admin.setAddress(resultSet.getString("address"));
            admin.setName(resultSet.getString("name"));
            admin.setPhone(resultSet.getString("phone"));
            admin.setEmail(resultSet.getString("email"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return admin;
    }
}
