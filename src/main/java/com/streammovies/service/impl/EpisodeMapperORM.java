package com.streammovies.service.impl;

import com.streammovies.dao.dao.IAdminDAO;
import com.streammovies.dao.dao.ILinkDAO;
import com.streammovies.model.movies.Episode;
import com.streammovies.service.IMapperORM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class EpisodeMapperORM implements IMapperORM<Episode> {

    @Autowired
    private IAdminDAO adminDAO;


    @Override
    public Episode mapping(Episode object) {
//        object.setUpdator(adminDAO.findUpdatorByEpisodeId(object.getId()));
//        object.setCreator(adminDAO.findCreatorByEpisodeId(object.getId()));
        return object;
    }

    @Override
    public Collection<Episode> mapping(Collection<Episode> collection) {
//        for(Episode episode: collection){
//            episode = mapping(episode);
//        }
        return collection;
    }
}
