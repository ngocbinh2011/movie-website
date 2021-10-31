package com.streammovies.service.impl;

import com.streammovies.dao.dao.impl.UserDAO;
import com.streammovies.model.watcher.Role;
import com.streammovies.model.watcher.User;
import com.streammovies.security.ICryptorPassword;
import com.streammovies.service.IMapperORM;
import com.streammovies.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private IMapperORM<User> mapperORM;

    @Autowired
    private ICryptorPassword cryptor;

    @Override
    public boolean update(User member) {
        return false;
    }

    @Override
    public User save(User member) {
        return mapperORM.mapping(userDAO.insert(member));
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public User findOne(int id) {
        return userDAO.findOne(id);
    }

    @Override
    public User findOne(String username) {
        return userDAO.findOne(username);
    }



    @Override
    public boolean checkLogin(String username, String password) {
        if(username == null || password == null){
            return false;
        }
        User user = userDAO.findOne(username);
        if(user == null){
            return false;
        }
        return cryptor.verifyPassword(password, user.getPassword());
    }

    @Override
    public boolean checkRole(User user, Role role) {
        Set<Role> listRole = user.getListRole();
        for(Role element: listRole){
            if(role.equals(element)){
                return true;
            }
        }
        return false;
    }

    @Override
    public void setRole(User user, Set<Role> listRole) {
        user.setListRole(listRole);
    }
}
