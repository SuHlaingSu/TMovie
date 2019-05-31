package com.sh.tmovie.view;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.sh.tmovie.R;
import com.sh.tmovie.adapter.MovieAdapter;
import com.sh.tmovie.data.room.entity.Movies;
import com.sh.tmovie.viewModel.MainActivityViewModel;


import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private final static String TAG = MainActivity.class.getSimpleName();

    private RecyclerView rvMoviesListView;
    private MovieAdapter mMovieAdapter;
    private ArrayList<Movies> moviesList = new ArrayList<>();
    MainActivityViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rvMoviesListView = findViewById(R.id.rv_gridView);
        viewModel = ViewModelProviders.of(this).get(MainActivityViewModel.class);
        viewModel.getMoviesList(this);
        rvMoviesListView.setLayoutManager(new GridLayoutManager(this, 2));
        mMovieAdapter = new MovieAdapter(getApplicationContext(), moviesList);
        viewModel.getLive_movies().observe(this, new Observer<List<Movies>>() {
            @Override
            public void onChanged(@Nullable List<Movies> movies) {
                viewModel.getLive_movies().removeObserver(this);
                moviesList.addAll(movies);
                mMovieAdapter.notifyDataSetChanged();
            }
        });
        rvMoviesListView.setAdapter(mMovieAdapter);
    }
}
