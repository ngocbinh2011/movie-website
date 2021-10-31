package com.streammovies.model.movies;

import com.streammovies.model.admin.Admin;
import com.streammovies.model.utils.AbstractModified;

import java.util.Date;
import java.util.List;
import java.util.Set;

public class Episode extends AbstractModified {
    private int id;
    private int episodeNumber;
    private String code;
    private Movie movie;
    private List<Link> listLink;

    public Episode() {
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEpisodeNumber() {
        return episodeNumber;
    }

    public void setEpisodeNumber(int episodeNumber) {
        this.episodeNumber = episodeNumber;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public List<Link> getListLink() {
        return listLink;
    }

    public void setListLink(List<Link> listLink) {
        this.listLink = listLink;
    }
}

