package com.example.themovie.view.splash;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.themovie.R;
import com.example.themovie.databinding.FragmentSplashBinding;

public class SplashFragment extends Fragment {

    private FragmentSplashBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentSplashBinding.inflate(inflater, container, false);

        Animation fadeId = AnimationUtils.loadAnimation(getContext(), R.anim.fade_in);

        binding.textViewLogoApp.startAnimation(fadeId);

        binding.textViewPowerBy.startAnimation(fadeId);

        binding.imageViewLogoGoDigital.startAnimation(fadeId);

        fadeId.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                //Do Nothing
            }

            @Override
            public void onAnimationEnd(Animation animation) {

                Navigation.findNavController(binding.getRoot()).navigate(
                        SplashFragmentDirections.actionSplashFragmentToLandingFragment()
                );

            }

            @Override
            public void onAnimationRepeat(Animation animation) {
                //Do Nothing
            }
        });

        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}