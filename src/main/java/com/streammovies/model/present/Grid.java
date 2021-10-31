package com.streammovies.model.present;

import com.streammovies.model.admin.Admin;
import com.streammovies.model.movies.Category;
import com.streammovies.model.movies.Movie;
import com.streammovies.model.utils.AbstractModified;

import java.util.Date;
import java.util.List;

public class Grid extends AbstractModified {
    private int id;
    private String name;
    private String code;
    private int amountMovie;
    private Category category;
    private List<Movie> listMovie;


    public Grid() {
    }

    public Grid(int id, String name, String code, Admin author, Date createDate, Date updateDate, Admin updateBy) {
        super(author, createDate, updateDate, updateBy);
        this.id = id;
        this.name = name;
        this.code = code;
    }

    public int getAmountMovie() {
        return amountMovie;
    }

    public void setAmountMovie(int amountMovie) {
        this.amountMovie = amountMovie;
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Movie> getListMovie() {
        return listMovie;
    }

    public void setListMovie(List<Movie> listMovie) {
        this.listMovie = listMovie;
    }
}
