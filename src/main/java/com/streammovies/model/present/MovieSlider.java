package com.streammovies.model.present;

import com.streammovies.model.movies.Movie;
import com.streammovies.model.utils.AbstractModified;

public class MovieSlider extends AbstractModified {
    private int id;
    private Movie movie;
    private String imageLinkSlider;
    private int order;

    public MovieSlider() {
    }

    public int getOrder() {
        return order;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public String getImageLinkSlider() {
        return imageLinkSlider;
    }

    public void setImageLinkSlider(String imageLinkSlider) {
        this.imageLinkSlider = imageLinkSlider;
    }
}
