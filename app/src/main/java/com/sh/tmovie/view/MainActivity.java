package com.sh.tmovie.view;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.sh.tmovie.JsonResponse.MoviesResponse;
import com.sh.tmovie.R;
import com.sh.tmovie.adapter.MovieAdapter;
import com.sh.tmovie.model.entity.Movies;
import com.sh.tmovie.utilis.Constants;
import com.sh.tmovie.viewModel.MainActivityViewModel;
import com.sh.tmovie.webServices.ApiInterface;
import com.sh.tmovie.webServices.ServiceGenerator;


import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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
        viewModel = ViewModelProviders.of(this).get(MainActivityViewModel.class);
        viewModel.getMoviesList();
        rvMoviesListView = findViewById(R.id.rv_gridView);

        rvMoviesListView.setLayoutManager(new GridLayoutManager(this, 2));

        mMovieAdapter = new MovieAdapter(getApplicationContext(), moviesList);

        viewModel.getLive_movies().observe(this, new Observer<List<Movies>>() {
            @Override
            public void onChanged(List<Movies> movies) {
               moviesList.addAll(movies);
               mMovieAdapter.notifyDataSetChanged();

            }
        });
        rvMoviesListView.setAdapter(mMovieAdapter);
    }
}
