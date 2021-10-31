package com.streammovies.service;

import com.streammovies.model.movies.Link;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ILinkService extends IGeneralService<Link>, IModelService<Link>{
    List<Link> findAll(String movieCode, String episodeCode);
    List<Link> findAll(int episodeId);
    Link findOne(String movieCode, String episodeCode, int serverId);
    Link findOne(int episodeId, int serverId);
}
