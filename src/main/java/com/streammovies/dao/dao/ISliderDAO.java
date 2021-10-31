package com.streammovies.dao.dao;

import com.streammovies.dao.api.IServiceDAO;
import com.streammovies.model.present.MovieSlider;

import java.util.List;

public interface ISliderDAO extends IServiceDAO<MovieSlider>, IActionDAO<MovieSlider>{
    List<MovieSlider> findAll();
}
