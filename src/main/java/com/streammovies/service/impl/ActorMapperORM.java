package com.streammovies.service.impl;

import com.streammovies.model.movies.Actor;
import com.streammovies.service.IMapperORM;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class ActorMapperORM implements IMapperORM<Actor> {
    @Override
    public Actor mapping(Actor object) {
        return null;
    }

    @Override
    public Collection<Actor> mapping(Collection<Actor> collection) {
        return null;
    }
}
