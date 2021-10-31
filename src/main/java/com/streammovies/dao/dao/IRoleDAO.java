package com.streammovies.dao.dao;

import com.streammovies.dao.api.IServiceDAO;
import com.streammovies.model.watcher.Role;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface IRoleDAO extends IActionDAO<Role> {
    Set<Role> getRole(int userId);
    Set<Role> getRole(String username);
}
