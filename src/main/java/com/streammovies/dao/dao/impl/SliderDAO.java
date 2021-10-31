package com.streammovies.dao.dao.impl;

import com.streammovies.dao.api.ServiceDAO;
import com.streammovies.dao.dao.ISliderDAO;
import com.streammovies.model.mapper.IMapper;
import com.streammovies.model.present.MovieSlider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.swing.*;
import java.util.List;

@Repository
public class SliderDAO extends ServiceDAO<MovieSlider> implements ISliderDAO {

    @Autowired
    private IMapper<MovieSlider> mapper;

    @Override
    public boolean update(MovieSlider member) {
        return false;
    }

    @Override
    public MovieSlider insert(MovieSlider member) {
        String sql = "INSERT INTO SLIDER(UPDATE_DATE, UPDATE_BY, IMAGE_SLIDER, MOVIE_ID) " +
                "VALUES(CURRENT_TIMESTAMP,?,?,?)";
        boolean isSuccess = insert(sql, member.getCreator().getId(), member.getImageLinkSlider(), member.getMovie().getId());
        return isSuccess? member : null;
    }

    @Override
    public boolean delete(int id) {
        String sql = "DELETE FROM slider WHERE id = ?";
        return delete(sql, id);
    }

    @Override
    public List<MovieSlider> findAll() {
        String sql = "SELECT M.id, M.name, M.code, M.short_content, M.main_content, S.id, S.image_slider, S.order, S.update_date, S.update_by\n" +
                "FROM movie AS M INNER JOIN slider AS S ON S.movie_id = M.id";
        List<MovieSlider> result = query(sql, mapper);
        return result;
    }
}
