package com.streammovies.dao.dao;

import com.streammovies.dao.api.IServiceDAO;
import com.streammovies.model.watcher.User;

public interface IUserDAO extends IServiceDAO<User>, IActionDAO<User>{
    User findOne(int id);

    User findOne(String username);

}
