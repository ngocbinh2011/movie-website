package com.streammovies.model.movies;

import com.streammovies.model.admin.Admin;

public class Tagname {
    private int id;
    private String name;
    private String code;
    private Movie movie;
    private Admin author;

    public Tagname() {
    }

    public Tagname(int id, String name, String code, Movie movie, Admin author) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.movie = movie;
        this.author = author;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Admin getAuthor() {
        return author;
    }

    public void setAuthor(Admin author) {
        this.author = author;
    }
}
