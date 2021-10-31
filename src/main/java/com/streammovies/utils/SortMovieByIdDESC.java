package com.streammovies.utils;

import com.streammovies.model.movies.Movie;

import java.util.Comparator;

public class SortMovieByIdDESC implements Comparator<Movie> {
    @Override
    public int compare(Movie o1, Movie o2) {
        if(o1.getId() == o2.getId()){
            return 0;
        }
        return o1.getId() < o2.getId()? 1 : -1;
    }
}
