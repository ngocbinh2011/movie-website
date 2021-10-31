package com.streammovies.service.impl;

import com.streammovies.dao.dao.IRoleDAO;
import com.streammovies.model.watcher.Role;
import com.streammovies.model.watcher.User;
import com.streammovies.service.IMapperORM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;

@Component
public class UserMapperORM implements IMapperORM<User> {

    @Autowired
    private IRoleDAO roleDAO;

    @Override
    public User mapping(User object) {
//        object.setListRole(new ArrayList<Role>(roleDAO.getRole(object.getUsername())));
        return object;
    }

    @Override
    public Collection<User> mapping(Collection<User> collection) {
        return null;
    }
}
