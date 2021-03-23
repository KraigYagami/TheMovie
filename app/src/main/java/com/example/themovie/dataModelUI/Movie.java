package com.example.themovie.dataModelUI;


import androidx.annotation.Keep;

import java.io.Serializable;

@Keep
public class Movie implements Serializable {

    private int id;

    private String originalLanguage;

    private String title;

    private String releaseDate;

    private String overview;

    private String posterPath;

    private String backdropPath;

    private float voteAverage;

    private int voteCount;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOriginalLanguage() {
        return originalLanguage;
    }

    public void setOriginalLanguage(String originalLanguage) {
        this.originalLanguage = originalLanguage;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public String getBackdropPath() {
        return backdropPath;
    }

    public void setBackdropPath(String backdropPath) {
        this.backdropPath = backdropPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public float getVoteAverage() {
        return voteAverage;
    }

    public void setVoteAverage(float voteAverage) {
        this.voteAverage = voteAverage;
    }

    public int getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(int voteCount) {
        this.voteCount = voteCount;
    }

    public Movie() {
    }

    public Movie(int id, String originalLanguage, String title, String releaseDate, String overview, String posterPath, String backdropPath, float voteAverage, int voteCount) {
        this.id = id;
        this.originalLanguage = originalLanguage;
        this.title = title;
        this.releaseDate = releaseDate;
        this.overview = overview;
        this.posterPath = posterPath;
        this.backdropPath = backdropPath;
        this.voteAverage = voteAverage;
        this.voteCount = voteCount;
    }
}
