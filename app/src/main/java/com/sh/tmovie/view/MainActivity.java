package com.sh.tmovie.view;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.sh.tmovie.R;
import com.sh.tmovie.adapter.MovieAdapter;
import com.sh.tmovie.model.database.MoviesDatabase;
import com.sh.tmovie.model.entity.Movies;
import com.sh.tmovie.network.ConnectivityHelper;
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
                moviesList.addAll(movies);
                mMovieAdapter.notifyDataSetChanged();
            }
        });
        rvMoviesListView.setAdapter(mMovieAdapter);
    }
}
