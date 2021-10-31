package com.streammovies.model.watcher;

import com.streammovies.model.movies.Movie;

import java.util.Date;

public class RecordWatch {
    private int id;
    private Date nearleast;
    private Movie movie;
    private User user;

    public RecordWatch() {
    }

    public RecordWatch(int id, Date nearleast, Movie movie, User user) {
        this.id = id;
        this.nearleast = nearleast;
        this.movie = movie;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getNearleast() {
        return nearleast;
    }

    public void setNearleast(Date nearleast) {
        this.nearleast = nearleast;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
