package com.streammovies.service;

import com.streammovies.model.present.MovieSlider;

import java.util.List;

public interface ISliderService extends IGeneralService<MovieSlider>{
    List<MovieSlider> findAll();
}
