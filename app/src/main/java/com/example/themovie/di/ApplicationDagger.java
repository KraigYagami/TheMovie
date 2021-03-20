package com.example.themovie.di;


import dagger.android.AndroidInjector;
import dagger.android.support.DaggerApplication;

public class ApplicationDagger extends DaggerApplication {

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        return DaggerApplicationComponent.builder().application(this).build();
    }
}
