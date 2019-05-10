package com.sh.tmovie.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.sh.tmovie.R;
import com.sh.tmovie.adapter.MovieAdapter;
import com.sh.tmovie.model.entity.Movies;
import com.sh.tmovie.utilis.Constants;
import com.sh.tmovie.webServices.ApiInterface;
import com.sh.tmovie.webServices.ServiceGenerator;


import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private final static String TAG = MainActivity.class.getSimpleName();

    private RecyclerView rvMoviesListView;
    private MovieAdapter mMovieAdapter;
    private ArrayList<Movies> moviesList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rvMoviesListView = findViewById(R.id.rv_gridView);
        rvMoviesListView.setLayoutManager(new GridLayoutManager(this, 2));

        mMovieAdapter=new MovieAdapter(getApplicationContext(), moviesList);
        rvMoviesListView.setAdapter(mMovieAdapter);
        getMoviesList();
    }

    private void getMoviesList() {
        ApiInterface apiInterface = ServiceGenerator.createService(ApiInterface.class);
        Call<ArrayList<Movies>> call = apiInterface.getMoviesList(Constants.API_KEY);
        call.enqueue(new Callback<ArrayList<Movies>>() {
            @Override
            public void onResponse(Call<ArrayList<Movies>> call, Response<ArrayList<Movies>> response) {
                if(response.isSuccessful()) {
                    Log.d(TAG, "Loading successfully, size: " + response.body());
                    for(Movies movies: response.body()){
                        moviesList.add(movies);
                    }
                    mMovieAdapter.notifyDataSetChanged();
                }else {
                    Log.d(TAG, "Fail" + response.message());
                }
            }

            @Override
            public void onFailure(Call<ArrayList<Movies>> call, Throwable t) {
                Log.d(TAG, "Fail: " + t.getMessage());

            }

        });
    }
}
