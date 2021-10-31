package com.streammovies.model.movies;

import com.streammovies.model.admin.Admin;
import com.streammovies.model.utils.AbstractModified;

import java.util.Date;

public class Link extends AbstractModified {
    private int id;
    private String url;
    private int serverId;
    private Movie movie;
    private Episode episode;

    public Link() {
    }

    public Link(Admin creator, Admin updator, int id, String url, int serverId, Movie movie, Episode episode) {
        super(creator, updator);
        this.id = id;
        this.url = url;
        this.serverId = serverId;
        this.movie = movie;
        this.episode = episode;
    }

    public Link(String url, int serverId, Movie movie, Episode episode) {
        this.url = url;
        this.serverId = serverId;
        this.movie = movie;
        this.episode = episode;
    }

    public Link(Admin creator, Admin updator, String url, int serverId, Movie movie, Episode episode) {
        super(creator, updator);
        this.url = url;
        this.serverId = serverId;
        this.movie = movie;
        this.episode = episode;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getServerId() {
        return serverId;
    }

    public void setServerId(int serverId) {
        this.serverId = serverId;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Episode getEpisode() {
        return episode;
    }

    public void setEpisode(Episode episode) {
        this.episode = episode;
    }

    @Override
    public String toString() {
        return url;
    }
}
