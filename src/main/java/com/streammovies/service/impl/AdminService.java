package com.streammovies.service.impl;

import com.streammovies.dao.dao.IAdminDAO;
import com.streammovies.model.admin.Admin;
import com.streammovies.service.IActorService;
import com.streammovies.service.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService implements IAdminService {

    @Autowired
    private IAdminDAO adminDAO;


    @Override
    public boolean update(Admin member) {
        return false;
    }

    @Override
    public Admin save(Admin member) {
        return null;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public Admin findOne(String username) {
        return adminDAO.findOne(username);
    }
}
