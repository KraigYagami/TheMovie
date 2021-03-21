package com.example.themovie.di.module;

import com.example.themovie.view.landing.LandingFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;


@Module
public abstract class FragmentModule {

    @ContributesAndroidInjector(modules = {LandingModule.class})
    abstract LandingFragment contributeLandingFragment();

}