package com.example.themovie.api;

import com.example.themovie.dto.DataPageMoviesDTO;

import io.reactivex.rxjava3.core.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

import static com.example.themovie.utils.Constants.GET_POPULAR_MOVIES;

public interface TheMovieApi {

    @GET(GET_POPULAR_MOVIES)
    Single<DataPageMoviesDTO> getPopularMovies(@Query("page") int pageNum);

}
