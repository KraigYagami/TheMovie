package com.example.themovie.model.landing;

import com.example.themovie.dto.DataPageMoviesDTO;

import io.reactivex.rxjava3.core.Single;

public interface LandingRepository {

    Single<DataPageMoviesDTO> getPopularMovies(int page);

}
