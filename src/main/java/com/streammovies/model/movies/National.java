package com.streammovies.model.movies;

import com.streammovies.model.admin.Admin;

import java.util.Collection;
import java.util.List;
import java.util.Set;

public class National {
    private int id;
    private String name;
    private String code;
    private Admin author;
    private List<Movie> setMovie;

    public National() {
    }

    public National(int id, String name, String code, Admin author) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.author = author;
    }

    public National(int id, String name, String code, Admin author, List<Movie> setMovie) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.author = author;
        this.setMovie = setMovie;
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

    public Admin getAuthor() {
        return author;
    }

    public void setAuthor(Admin author) {
        this.author = author;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<Movie> getSetMovie() {
        return setMovie;
    }

    public void setSetMovie(List<Movie> setMovie) {
        this.setMovie = setMovie;
    }
}
