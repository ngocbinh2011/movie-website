package com.streammovies.service.impl;

import com.streammovies.dao.dao.ILinkDAO;
import com.streammovies.model.movies.Link;
import com.streammovies.service.ILinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LinkService implements ILinkService {

    @Autowired
    private ILinkDAO linkDAO;

    @Override
    public boolean update(Link member) {
        return linkDAO.update(member);
    }

    @Override
    public Link save(Link member) {
        return linkDAO.insert(member);
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public List<Link> findAll() {
        return linkDAO.findAll();
    }

    @Override
    public List<Link> findAllByMovieCode(String code) {
        return linkDAO.findAllByMovieCode(code);
    }

    @Override
    public List<Link> findAll(String movieCode, String episodeCode) {
        return linkDAO.findAllByMovieCode(movieCode, episodeCode);
    }

    @Override
    public List<Link> findAll(int episodeId) {
        return linkDAO.findAllByEpisodeId(episodeId);
    }

    @Override
    public Link findOne(String movieCode, String episodeCode, int serverId) {
        List<Link> listLink = linkDAO.findAllByMovieCode(movieCode, episodeCode);
        for(Link link: listLink){
            if(link.getServerId() == serverId){
                return link;
            }
        }
        return null;
    }

    @Override
    public Link findOne(int episodeId, int serverId) {
        List<Link> listLink = linkDAO.findAllByEpisodeId(episodeId);
        for(Link link: listLink){
            if(link.getServerId() == serverId){
                return link;
            }
        }
        return null;
    }

    // this method choose update if record is existed in database
    // and insert if not exists
    // linkId > 0 if the record is exist and = -1 if not
    public boolean updateOrInsert(Link link, int linkId){
        if(link.getUrl() == null || link.getUrl().isEmpty()){
            return false;
        }
        if(linkId == -1){
            Link result = save(link);
            return result != null? true : false;
        } else{
            link.setId(linkId);
            return update(link);
        }
    }

}
