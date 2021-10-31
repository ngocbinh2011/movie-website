package com.streammovies.service;

import com.streammovies.model.admin.Admin;
import org.springframework.stereotype.Service;

@Service
public interface IAdminService extends IGeneralService<Admin>{
    Admin findOne(String username);
}
