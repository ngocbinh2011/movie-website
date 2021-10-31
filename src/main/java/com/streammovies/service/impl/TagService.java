package com.streammovies.service.impl;

import com.streammovies.dao.dao.ITagnameDAO;
import com.streammovies.model.movies.Tagname;
import com.streammovies.service.ITagsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagService implements ITagsService {
    @Autowired
    private ITagnameDAO tagnameDAO;

    @Override
    public boolean update(Tagname member) {
        return tagnameDAO.update(member);
    }

    @Override
    public Tagname save(Tagname member) {
        return tagnameDAO.insert(member);
    }

    @Override
    public boolean delete(int id) {
        return tagnameDAO.delete(id);
    }

    @Override
    public List<Tagname> findAll() {
        return tagnameDAO.findAll();
    }

    @Override
    public List<Tagname> findAllByMovieCode(String code) {
        return tagnameDAO.findAllByMovieCode(code);
    }

    @Override
    public List<Tagname> findAllByMovieId(int id) {
        return tagnameDAO.findAllByMovieId(id);
    }
}
