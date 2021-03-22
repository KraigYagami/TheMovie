package com.example.themovie.view.landing.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.themovie.dataModelUI.Movie;
import com.example.themovie.databinding.FragmentMovieItemBinding;

import java.util.ArrayList;
import java.util.List;

import static com.example.themovie.utils.Constants.BASE_URL_IMAGE;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MovieViewHolder> {

    private List<Movie> movies = new ArrayList<>();
    private MovieClickListener clickListener;

    public MoviesAdapter(MovieClickListener clickListener) {
        this.clickListener = clickListener;
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        FragmentMovieItemBinding binding = FragmentMovieItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new MovieViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        Movie movie = movies.get(position);
        holder.binds(movie, clickListener);
    }

    @Override
    public int getItemCount() {
        return movies == null ? 0 : movies.size();
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
        notifyDataSetChanged();
    }

    public static class MovieViewHolder extends RecyclerView.ViewHolder {
        private FragmentMovieItemBinding binding;

        public MovieViewHolder(FragmentMovieItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public final void binds(Movie movie, MovieClickListener clickListener) {
            Glide.with(binding.imageViewMovie)
                    .load(BASE_URL_IMAGE + movie.getPosterPath())
                    .into(binding.imageViewMovie);

            binding.imageViewMovie.setOnClickListener(view -> clickListener.onClick(movie));
        }
    }

    public interface MovieClickListener {
        void onClick(Movie movie);
    }

}
