package com.example.themovie.view.landing;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.themovie.R;
import com.example.themovie.dataModelUI.Movie;
import com.example.themovie.databinding.FragmentLandingBinding;
import com.example.themovie.presenter.landing.LandingPresenter;
import com.example.themovie.utils.Constants;
import com.example.themovie.view.landing.adapter.MoviesAdapter;

import java.util.List;
import java.util.Objects;

import javax.inject.Inject;

import dagger.android.support.DaggerFragment;


public class LandingFragment extends DaggerFragment implements LandingView {

    @Inject
    LandingPresenter presenter;
    private FragmentLandingBinding binding;

    private MoviesAdapter moviesAdapter;

    private boolean isStop = false;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentLandingBinding.inflate(inflater, container, false);

        presenter.getPopularMovies();

        binding.materialButtonReloadBottom.setOnClickListener(view -> {
            binding.materialButtonReloadBottom.setVisibility(View.INVISIBLE);
            binding.progressBottom.setVisibility(View.VISIBLE);
            presenter.getPopularMovies();
        });

        binding.materialButtonReload.setOnClickListener(view -> {
            binding.materialButtonReload.setVisibility(View.GONE);
            binding.progress.setVisibility(View.VISIBLE);
            presenter.getPopularMovies();
        });

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        moviesAdapter = new MoviesAdapter(movie -> Navigation.findNavController(binding.getRoot()).navigate(
                LandingFragmentDirections.actionLandingFragmentToDetailMovieFragment(movie)
        ));

        binding.recyclerViewMovies.setAdapter(moviesAdapter);

        scrollData(binding.recyclerViewMovies);
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
    public void scrollData(RecyclerView recyclerView) {
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                int visibleItemCount = Objects.requireNonNull(recyclerView.getLayoutManager()).getChildCount();
                int totalItemCount = recyclerView.getLayoutManager().getItemCount();
                int firstVisibleItemPosition = ((LinearLayoutManager) recyclerView.getLayoutManager()).findFirstVisibleItemPosition();

                if ((visibleItemCount + firstVisibleItemPosition) >= totalItemCount - Constants.PAGINATION_MARGIN
                        && firstVisibleItemPosition >= 0
                        && totalItemCount >= Constants.PAGE_SIZE
                        && !isStop) {
                    presenter.onLoadNextPage();
                }
            }
        });
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

    @Override
    public void resetErrorLoadData() {
        isStop = false;
        setImage(binding.imageViewLoading, R.drawable.ic_popcorn);
        binding.materialButtonReload.setVisibility(View.GONE);
        binding.materialButtonReloadBottom.setVisibility(View.GONE);
        binding.progressBottom.setVisibility(View.GONE);
    }

    @Override
    public void errorLoadData(int currentPage) {
        isStop = true;
        Toast.makeText(requireContext(), requireContext().getText(R.string.text_error_data), Toast.LENGTH_LONG).show();

        binding.progress.setVisibility(View.GONE);

        if (binding.recyclerViewMovies.getVisibility() == View.VISIBLE) {
            binding.materialButtonReloadBottom.setVisibility(View.VISIBLE);
        } else {
            binding.materialButtonReload.setVisibility(View.VISIBLE);
        }

        setImage(binding.imageViewLoading, R.drawable.ic_no_connection);
    }

    private void setImage(ImageView imageView, int image) {
        Glide.with(imageView)
                .load(ContextCompat.getDrawable(requireContext(), image))
                .into(imageView);
    }

}