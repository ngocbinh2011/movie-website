package com.streammovies.service;

import com.streammovies.model.movies.Movie;
import com.streammovies.model.watcher.Role;
import com.streammovies.model.watcher.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public interface IUserService extends IGeneralService<User>{
    User findOne(int id);
    User findOne(String username);
    boolean checkLogin(String username, String password);
    boolean checkRole(User user, Role role);
    void setRole(User user, Set<Role> listRole);
}
