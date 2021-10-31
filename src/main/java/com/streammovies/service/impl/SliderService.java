package com.streammovies.service.impl;

import com.streammovies.dao.dao.ICategoryDAO;
import com.streammovies.dao.dao.ISliderDAO;
import com.streammovies.model.movies.Movie;
import com.streammovies.model.present.MovieSlider;
import com.streammovies.service.ISliderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SliderService implements ISliderService {

    @Autowired
    private ISliderDAO sliderDAO;

    @Autowired
    private ICategoryDAO categoryDAO;

    @Override
    public boolean update(MovieSlider member) {
        return false;
    }

    @Override
    public MovieSlider save(MovieSlider member) {
        return sliderDAO.insert(member);
    }

    @Override
    public boolean delete(int id) {
        return sliderDAO.delete(id);
    }

    @Override
    public List<MovieSlider> findAll() {
        List<MovieSlider> result = sliderDAO.findAll();
        if(result == null){
            return null;
        }
        return result;
    }
}
