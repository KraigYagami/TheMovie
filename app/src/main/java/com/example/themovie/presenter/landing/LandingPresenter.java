package com.example.themovie.presenter.landing;

import com.example.themovie.dataModelUI.Movie;
import com.example.themovie.dto.MovieDTO;

import java.util.List;

public interface LandingPresenter {

    void getPopularMovies();

    List<Movie> toListMovies(List<MovieDTO> listMovieDTO);
}
