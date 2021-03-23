package com.example.themovie.model.landing;

import com.example.themovie.api.TheMovieApi;
import com.example.themovie.dto.DataPageMoviesDTO;

import javax.inject.Inject;

import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class LandingRepositoryImpl implements LandingRepository {

    private TheMovieApi theMovieApi;

    @Inject
    public LandingRepositoryImpl(TheMovieApi theMovieApi) {
        this.theMovieApi = theMovieApi;
    }

    @Override
    public Single<DataPageMoviesDTO> getPopularMovies(int page) {
        return theMovieApi.getPopularMovies(page).subscribeOn(Schedulers.io());
    }
}
