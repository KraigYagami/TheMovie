package com.example.themovie.model.landing;

import com.example.themovie.data.DataPageMovie;

import io.reactivex.rxjava3.core.Single;

public interface LandingRepository {

    Single<DataPageMovie> getPopularMovies();

}
