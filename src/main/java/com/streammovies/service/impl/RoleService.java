package com.streammovies.service.impl;

import com.streammovies.dao.dao.IRoleDAO;
import com.streammovies.model.watcher.Role;
import com.streammovies.model.watcher.User;
import com.streammovies.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class RoleService implements IRoleService {

    @Autowired
    private IRoleDAO roleDAO;

    @Override
    public boolean update(Role member) {
        return false;
    }

    @Override
    public Role save(Role member) {
        return null;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public Set<Role> getListRole(int userId) {
        return roleDAO.getRole(userId);
    }

    @Override
    public Set<Role> getListRole(String username) {
        return roleDAO.getRole(username);
    }

    @Override
    public Set<Role> getListRole(User user) {
        return roleDAO.getRole(user.getUsername());
    }
}
