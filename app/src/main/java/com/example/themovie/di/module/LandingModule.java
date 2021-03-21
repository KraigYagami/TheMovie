package com.example.themovie.di.module;

import com.example.themovie.presenter.landing.LandingPresenter;
import com.example.themovie.presenter.landing.LandingPresenterImpl;
import com.example.themovie.model.landing.LandingRepository;
import com.example.themovie.model.landing.LandingRepositoryImpl;
import com.example.themovie.view.landing.LandingFragment;
import com.example.themovie.view.landing.LandingView;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;


@Module
public abstract class LandingModule {

    @Binds
    abstract LandingView provideView(LandingFragment view);

    @Provides
    static LandingPresenter providePresenter(LandingView view, LandingRepository repository) {
        return new LandingPresenterImpl(view, repository);
    }

    @Provides
    static LandingRepository provideRepository(LandingRepositoryImpl repository) {
        return repository;
    }
}

