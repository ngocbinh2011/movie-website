package com.streammovies.dao.dao.impl;

import com.streammovies.dao.api.ServiceDAO;
import com.streammovies.dao.dao.IRoleDAO;
import com.streammovies.model.mapper.IMapper;
import com.streammovies.model.watcher.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Repository
public class RoleDAO extends ServiceDAO<Role> implements IRoleDAO {

    @Autowired
    private IMapper<Role> mapper;

    @Override
    public Set<Role> getRole(int userId) {
        String sql = "SELECT R.* FROM role AS R INNER JOIN user on user.id = R.user_id\n" +
                "WHERE user.id = ?";
        List<Role> result = query(sql, mapper, userId);
        return new HashSet<>(result);
    }

    @Override
    public Set<Role> getRole(String username) {
        String sql = "SELECT R.* FROM role AS R INNER JOIN user on user.id = R.user_id\n" +
                "WHERE user.u_username = ?";
        List<Role> result = query(sql, mapper, username);
        return new HashSet<>(result);
    }

    @Override
    public boolean update(Role member) {
        return false;
    }

    @Override
    public Role insert(Role member) {
        return null;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }
}
