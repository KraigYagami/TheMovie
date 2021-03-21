package com.example.themovie.view.landing;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.example.themovie.databinding.FragmentLandingBinding;
import com.example.themovie.presenter.landing.LandingPresenter;

import javax.inject.Inject;

import dagger.android.support.DaggerFragment;


public class LandingFragment extends DaggerFragment implements LandingView {

    @Inject
    LandingPresenter presenter;
    private FragmentLandingBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentLandingBinding.inflate(inflater, container, false);


        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_LONG).show();
    }
}