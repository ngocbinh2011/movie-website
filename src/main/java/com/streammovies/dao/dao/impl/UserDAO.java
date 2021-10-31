package com.streammovies.dao.dao.impl;

import com.streammovies.dao.api.ServiceDAO;
import com.streammovies.dao.dao.IActionDAO;
import com.streammovies.dao.dao.IUserDAO;
import com.streammovies.model.mapper.IMapper;
import com.streammovies.model.watcher.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDAO extends ServiceDAO<User> implements IUserDAO{

    @Autowired
    private IMapper<User> mapper;

    @Override
    public User findOne(int id) {
        String sql = "SELECT * FROM user WHERE id = ?";
        List<User> result = query(sql, mapper, id);
        return result.isEmpty()? null: result.get(0);
    }

    @Override
    public User findOne(String username) {
        String sql = "SELECT * FROM user WHERE u_username = ?";
        List<User> result = query(sql, mapper, username);
        return result.isEmpty()? null: result.get(0);
    }


    @Override
    public boolean update(User member) {
        return false;
    }

    @Override
    public User insert(User member) {
        String sql = "INSERT INTO user(u_username, u_password, create_date, update_date, hours_view)\n" +
                "VALUES(?,?,CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,?)";
        boolean isSuccess = insert(sql, member.getUsername(), member.getPassword(), member.getHoursView());
        if(isSuccess){
            return findOne(member.getUsername());
        }
        return null;
    }

    @Override
    public boolean delete(int id) {
        String sql = "DELETE FROM user WHERE id = ?";
        return delete(sql, id);
    }
}
