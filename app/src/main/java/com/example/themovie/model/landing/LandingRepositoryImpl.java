package com.example.themovie.model.landing;

import javax.inject.Inject;

public class LandingRepositoryImpl implements LandingRepository {

    @Inject
    public LandingRepositoryImpl() {

    }

    @Override
    public String test() {
        return "Test";
    }
}
