package com.streammovies.model.movies;

import com.streammovies.model.admin.Admin;
import com.streammovies.model.utils.AbstractModified;

import java.util.Date;
import java.util.List;
import java.util.Objects;

// structure orm in jpa, hibernate
public class Movie extends AbstractModified {
    private int id;
    private String name;
    private String code;
    private String trailerLink;
    private String director;
    private int yearPublish;
    private int amountEpisode;
    private String shortContent;
    private String mainContent;
    private String imageLinkPoster;
    private String imageLinkMain;
    private double imdbScore;
    private int amountView;
    private int currentEpisode;
    private String englishName;
    private National national;
    private int minutes;
    private List<Episode> listEpisode;
    private List<Tagname> listTagname;
    private List<Actor> listActor;
    private List<Category> listCategory;
    private List<Comment> listComment;


    public Movie() {
    }

    public String getEnglishName() {
        return englishName;
    }

    public void setEnglishName(String englishName) {
        this.englishName = englishName;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
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

    public String getTrailerLink() {
        return trailerLink;
    }

    public void setTrailerLink(String trailerLink) {
        this.trailerLink = trailerLink;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getYearPublish() {
        return yearPublish;
    }

    public void setYearPublish(int yearPublish) {
        this.yearPublish = yearPublish;
    }

    public int getAmountEpisode() {
        return amountEpisode;
    }

    public void setAmountEpisode(int amountEpisode) {
        this.amountEpisode = amountEpisode;
    }

    public String getShortContent() {
        return shortContent;
    }

    public void setShortContent(String shortContent) {
        this.shortContent = shortContent;
    }

    public String getMainContent() {
        return mainContent;
    }

    public void setMainContent(String mainContent) {
        this.mainContent = mainContent;
    }

    public String getImageLinkPoster() {
        return imageLinkPoster;
    }

    public void setImageLinkPoster(String imageLinkPoster) {
        this.imageLinkPoster = imageLinkPoster;
    }

    public String getImageLinkMain() {
        return imageLinkMain;
    }

    public void setImageLinkMain(String imageLinkMain) {
        this.imageLinkMain = imageLinkMain;
    }

    public double getImdbScore() {
        return imdbScore;
    }

    public void setImdbScore(double imdbScore) {
        this.imdbScore = imdbScore;
    }

    public int getAmountView() {
        return amountView;
    }

    public void setAmountView(int amountView) {
        this.amountView = amountView;
    }

    public National getNational() {
        return national;
    }

    public void setNational(National national) {
        this.national = national;
    }

    public List<Episode> getListEpisode() {
        return listEpisode;
    }

    public void setListEpisode(List<Episode> listEpisode) {
        this.listEpisode = listEpisode;
    }

    public List<Tagname> getListTagname() {
        return listTagname;
    }

    public void setListTagname(List<Tagname> listTagname) {
        this.listTagname = listTagname;
    }

    public List<Actor> getListActor() {
        return listActor;
    }

    public void setListActor(List<Actor> listActor) {
        this.listActor = listActor;
    }

    public List<Category> getListCategory() {
        return listCategory;
    }

    public void setListCategory(List<Category> listCategory) {
        this.listCategory = listCategory;
    }

    public List<Comment> getListComment() {
        return listComment;
    }

    public void setListComment(List<Comment> listComment) {
        this.listComment = listComment;
    }

    public int getCurrentEpisode() {
        return currentEpisode;
    }

    public void setCurrentEpisode(int currentEpisode) {
        this.currentEpisode = currentEpisode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return id == movie.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
