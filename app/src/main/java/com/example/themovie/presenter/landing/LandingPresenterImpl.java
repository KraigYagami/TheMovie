package com.example.themovie.presenter.landing;

import android.util.Log;

import com.example.themovie.data.Movie;
import com.example.themovie.model.landing.LandingRepository;
import com.example.themovie.view.landing.LandingView;

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
                .subscribe(dataPageMovie -> {
                    listMovie = dataPageMovie.getResults();
                    Log.d("DEBUG", "Funciona");
                }, throwable -> Log.e("ERROR", "error " + throwable));

    }
}
