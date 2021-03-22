package com.example.themovie.dto;

import androidx.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

public class MovieDTO {

    @Nullable
    @SerializedName("adult")
    private Boolean adult;

    @Nullable
    @SerializedName("backdrop_path")
    private String backdropPath;

    @SerializedName("id")
    private int id;

    @Nullable
    @SerializedName("original_language")
    private String originalLanguage;

    @Nullable
    @SerializedName("original_title")
    private String originalTitle;

    @Nullable
    @SerializedName("overview")
    private String overview;

    @Nullable
    @SerializedName("popularity")
    private Double popularity;

    @Nullable
    @SerializedName("poster_path")
    private String posterPath;

    @Nullable
    @SerializedName("release_date")
    private String releaseDate;

    @Nullable
    @SerializedName("title")
    private String title;

    @Nullable
    @SerializedName("vote_average")
    private Double voteAverage;

    @SerializedName("vote_count")
    private int voteCount;

    @Nullable
    public Boolean getAdult() {
        return adult;
    }

    @Nullable
    public String getBackdropPath() {
        return backdropPath;
    }

    public int getId() {
        return id;
    }

    @Nullable
    public String getOriginalLanguage() {
        return originalLanguage;
    }

    @Nullable
    public String getOriginalTitle() {
        return originalTitle;
    }

    @Nullable
    public String getOverview() {
        return overview;
    }

    @Nullable
    public Double getPopularity() {
        return popularity;
    }

    @Nullable
    public String getPosterPath() {
        return posterPath;
    }

    @Nullable
    public String getReleaseDate() {
        return releaseDate;
    }

    @Nullable
    public String getTitle() {
        return title;
    }

    @Nullable
    public Double getVoteAverage() {
        return voteAverage;
    }

    public int getVoteCount() {
        return voteCount;
    }
}
