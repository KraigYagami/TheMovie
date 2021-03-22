package com.example.themovie.presenter.landing;

import android.util.Log;

import com.example.themovie.dataModelUI.Movie;
import com.example.themovie.dto.MovieDTO;
import com.example.themovie.model.landing.LandingRepository;
import com.example.themovie.view.landing.LandingView;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;

public class LandingPresenterImpl implements LandingPresenter {

    LandingView view;
    LandingRepository repository;

    List<Movie> listMovie;

    @Inject
    public LandingPresenterImpl(LandingView view, LandingRepository repository) {
        this.view = view;
        this.repository = repository;
    }

    @Override
    public void getPopularMovies() {

        repository.getPopularMovies()
                .observeOn(AndroidSchedulers.mainThread())
                .map(dataPageMoviesDTO -> toListMovies(dataPageMoviesDTO.getResults()))
                .subscribe(dataPageMovie -> {
                    listMovie = dataPageMovie;
                    view.setDataMovies(listMovie);
                }, throwable -> Log.e("ERROR", "error " + throwable));

    }

    @Override
    public List<Movie> toListMovies(List<MovieDTO> listMovieDTO) {
        List<Movie> movies = new ArrayList<>();

        for (MovieDTO movieDTO : listMovieDTO) {
            movies.add(
                new Movie(
                        movieDTO.getId(),
                        movieDTO.getOriginalLanguage(),
                        movieDTO.getTitle(),
                        movieDTO.getReleaseDate(),
                        movieDTO.getOverview(),
                        movieDTO.getPosterPath(),
                        movieDTO.getVoteAverage(),
                        movieDTO.getVoteCount()
                )
            );
        }

        return movies;
    }
}
