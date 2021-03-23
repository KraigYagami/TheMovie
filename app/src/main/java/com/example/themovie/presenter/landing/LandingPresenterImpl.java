package com.example.themovie.presenter.landing;

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

    List<Movie> listMovie = new ArrayList<>();

    int currentPage = 1;

    @Inject
    public LandingPresenterImpl(LandingView view, LandingRepository repository) {
        this.view = view;
        this.repository = repository;
    }

    @Override
    public void getPopularMovies() {

        repository.getPopularMovies(currentPage)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(dataPageMovie -> {
                    currentPage = dataPageMovie.getPage();
                    listMovie.addAll(toListMovies(dataPageMovie.getResults()));
                    view.setDataMovies(listMovie);
                    view.hideLoading();
                    view.showListMovies();
                    view.resetErrorLoadData();
                }, throwable -> view.errorLoadData(currentPage));

    }

    @Override
    public void onLoadNextPage() {
        currentPage++;
        getPopularMovies();
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
                            movieDTO.getBackdropPath(),
                            movieDTO.getVoteAverage(),
                            movieDTO.getVoteCount()
                    )
            );
        }

        return movies;
    }
}
