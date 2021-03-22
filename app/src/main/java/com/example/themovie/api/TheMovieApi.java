package com.example.themovie.api;

import com.example.themovie.data.DataPageMovie;

import io.reactivex.rxjava3.core.Single;
import retrofit2.http.GET;

import static com.example.themovie.utils.Constants.GET_POPULAR_MOVIES;

public interface TheMovieApi {

    @GET(GET_POPULAR_MOVIES)
    Single<DataPageMovie> getPopularMovies();

}
