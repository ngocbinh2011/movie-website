package com.streammovies.model.movies;

import com.streammovies.model.admin.Admin;

import java.util.List;

public class Category {
    private int id;
    private String name;
    private String code;
    private Admin updateBy;
    private List<Movie> listMovie;

    public Category() {
    }

    public Category(int id, String name, String code) {
        this.id = id;
        this.name = name;
        this.code = code;
    }

    public Category(int id, String name, String code, Admin updateBy) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.updateBy = updateBy;
    }

    public Category(int id, String name, String code, Admin updateBy, List<Movie> listMovie) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.updateBy = updateBy;
        this.listMovie = listMovie;
    }

    public Category(String name, String code, Admin updateBy) {
        this.name = name;
        this.code = code;
        this.updateBy = updateBy;
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Admin getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(Admin updateBy) {
        this.updateBy = updateBy;
    }

    public List<Movie> getListMovie() {
        return listMovie;
    }

    public void setListMovie(List<Movie> listMovie) {
        this.listMovie = listMovie;
    }
}
