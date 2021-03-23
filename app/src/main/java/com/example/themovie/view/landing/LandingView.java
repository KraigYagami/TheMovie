package com.example.themovie.view.landing;

import androidx.recyclerview.widget.RecyclerView;

import com.example.themovie.dataModelUI.Movie;

import java.util.List;

public interface LandingView {

    void setDataMovies(List<Movie> movies);

    void scrollData(RecyclerView recyclerView);

    void hideLoading();

    void showListMovies();

    void resetErrorLoadData();

    void errorLoadData(int currentPage);

}
