package com.example.themovie.view.landing;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.navigation.Navigation;

import com.example.themovie.dataModelUI.Movie;
import com.example.themovie.databinding.FragmentLandingBinding;
import com.example.themovie.presenter.landing.LandingPresenter;
import com.example.themovie.view.landing.adapter.MoviesAdapter;

import java.util.List;

import javax.inject.Inject;

import dagger.android.support.DaggerFragment;


public class LandingFragment extends DaggerFragment implements LandingView {

    @Inject
    LandingPresenter presenter;
    private FragmentLandingBinding binding;

    private MoviesAdapter moviesAdapter;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentLandingBinding.inflate(inflater, container, false);

        presenter.getPopularMovies();

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        moviesAdapter = new MoviesAdapter(movie -> Navigation.findNavController(binding.getRoot()).navigate(
                LandingFragmentDirections.actionLandingFragmentToDetailMovieFragment(movie)
        ));

        binding.recyclerViewMovies.setAdapter(moviesAdapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void setDataMovies(List<Movie> movies) {
        moviesAdapter.setMovies(movies);
    }

    @Override
    public void hideLoading() {
        binding.imageViewLoading.setVisibility(View.GONE);
        binding.progress.setVisibility(View.GONE);
    }

    @Override
    public void showListMovies() {
        binding.recyclerViewMovies.setVisibility(View.VISIBLE);
    }
}