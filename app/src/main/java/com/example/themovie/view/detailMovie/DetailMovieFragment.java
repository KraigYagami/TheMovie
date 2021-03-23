package com.example.themovie.view.detailMovie;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.bumptech.glide.Glide;
import com.example.themovie.dataModelUI.Movie;
import com.example.themovie.databinding.FragmentDetailMovieBinding;

import static com.example.themovie.utils.Constants.BASE_URL_IMAGE;

public class DetailMovieFragment extends Fragment {

    FragmentDetailMovieBinding binding;
    Movie movieArgs;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        assert getArguments() != null;
        movieArgs = DetailMovieFragmentArgs.fromBundle(getArguments()).getMovie();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentDetailMovieBinding.inflate(inflater, container, false);

        binding.imageButtonBack.setOnClickListener(view -> Navigation.findNavController(binding.getRoot()).popBackStack());

        setInformationMovie();

        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    private void setInformationMovie() {

        setImage(binding.imageViewPoster, movieArgs.getPosterPath());

        setImage(binding.imageViewBackPoster, movieArgs.getBackdropPath());

        binding.textViewTitle.setText(movieArgs.getTitle());

        binding.textViewDateMovie.setText(movieArgs.getReleaseDate());

        float ran = movieArgs.getVoteAverage() / 2f;

        binding.rating.setRating(ran);

        binding.textViewVote.setText(String.format("%s", ran));

        binding.textViewDataOverview.setText(movieArgs.getOverview());

    }

    private void setImage(ImageView imageView, String image) {
        Glide.with(imageView)
                .load(BASE_URL_IMAGE + image)
                .into(imageView);
    }
}