package com.streammovies.service;

import com.streammovies.model.watcher.Role;
import com.streammovies.model.watcher.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public interface IRoleService extends IGeneralService<Role>{
    Set<Role> getListRole(int userId);
    Set<Role> getListRole(String username);
    Set<Role> getListRole(User user);
}
