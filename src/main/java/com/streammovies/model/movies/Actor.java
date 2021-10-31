package com.streammovies.model.movies;

import com.streammovies.model.admin.Admin;

import java.util.List;

public class Actor {
    private int id;
    private String name;
    private String code;
    private Admin author;
    private List<Movie> listMovie;

    public Actor() {
    }

    public Actor(int id, String name, String code, Admin author) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.author = author;
    }

    public Actor(int id, String name, String code) {
        this.id = id;
        this.name = name;
        this.code = code;
    }

    public Actor(int id, String name, String code, Admin author, List<Movie> listMovie) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.author = author;
        this.listMovie = listMovie;
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

    public Admin getAuthor() {
        return author;
    }

    public void setAuthor(Admin author) {
        this.author = author;
    }

    public List<Movie> getListMovie() {
        return listMovie;
    }

    public void setListMovie(List<Movie> listMovie) {
        this.listMovie = listMovie;
    }
}
