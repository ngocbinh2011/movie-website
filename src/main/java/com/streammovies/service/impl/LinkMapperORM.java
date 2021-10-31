package com.streammovies.service.impl;

import com.streammovies.dao.dao.IAdminDAO;
import com.streammovies.model.movies.Episode;
import com.streammovies.model.movies.Link;
import com.streammovies.service.IMapperORM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Component
public class LinkMapperORM implements IMapperORM<Link> {

    @Autowired
    private IAdminDAO adminDAO;

    @Override
    public Link mapping(Link object) {
//        object.setUpdator(adminDAO.findUpdatorByLinkId(object.getId()));
//        object.setCreator(adminDAO.findCreatorByLinkId(object.getId()));
        return null;
    }

    @Override
    public Collection<Link> mapping(Collection<Link> collection) {
//        for(Link link: collection){
//            link = mapping(link);
//        }
        return collection;
    }
}
