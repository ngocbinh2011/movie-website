package com.streammovies.dao.dao;

import com.streammovies.model.admin.Admin;
import org.springframework.beans.factory.annotation.Autowired;

public interface IActionDAO<T>{

    boolean update(T member);

    T insert(T member);

    boolean delete(int id);
}
