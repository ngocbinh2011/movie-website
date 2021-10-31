package com.streammovies.service.impl;

import com.streammovies.dao.dao.IActorDAO;
import com.streammovies.model.movies.Actor;
import com.streammovies.service.IActorService;
import com.streammovies.service.IMapperORM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActorService implements IActorService {

    @Autowired
    private IActorDAO actorDAO;

    @Autowired
    private IMapperORM<Actor> mapperORM;

    @Override
    public boolean update(Actor member) {
        return actorDAO.update(member);
    }

    @Override
    public Actor save(Actor member) {
        if(member == null){
            return null;
        }
        String name = member.getName();
        if(name == null || name.isEmpty()){
            return null;
        }
        if(member.getCode() == null || member.getCode().isEmpty()){
            if(name != null){
                member.setCode(getCodeFromActorName(member.getName()));
            }
        }
        String actorCode = member.getCode();
        Actor actor = actorDAO.findOne(actorCode);
        if(actor != null){
            return actor;
        }
        Actor result = actorDAO.insert(member);
        if(result != null){
            return actorDAO.findOne(actorCode);
        }
        return null;
    }

    private String getCodeFromActorName(String actorName){
        String currentName = actorName.trim().toLowerCase();
        currentName = currentName.replaceAll("[\\s]+", "-");
        return currentName;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public List<Actor> findAll() {
        return actorDAO.findAll();
    }

    @Override
    public List<Actor> findAllByMovieCode(String code) {
        return actorDAO.findAllByMovieCode(code);
    }

    @Override
    public Actor findOne(String actorCode) {
        return actorDAO.findOne(actorCode);
    }

    @Override
    public Actor findOne(int actorId) {
        return actorDAO.findOne(actorId);
    }

    @Override
    public List<Actor> findAllByMovieId(int id) {
        return actorDAO.findAllByMovieId(id);
    }
}
