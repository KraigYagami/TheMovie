package com.example.themovie.presenter.landing;

import android.content.Context;

import com.example.themovie.model.landing.LandingRepository;
import com.example.themovie.view.landing.LandingView;

import javax.inject.Inject;

public class LandingPresenterImpl implements LandingPresenter {

    LandingView view;
    LandingRepository repository;

    @Inject
    public LandingPresenterImpl(LandingView view, LandingRepository repository) {
        this.view = view;
        this.repository = repository;
    }


    @Override
    public void test(Context context) {
        view.showMessage(repository.test());
    }
}
