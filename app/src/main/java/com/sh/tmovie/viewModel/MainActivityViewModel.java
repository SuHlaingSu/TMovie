package com.sh.tmovie.viewModel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.MutableLiveData;
import android.util.Log;

import com.sh.tmovie.JsonResponse.MoviesResponse;
import com.sh.tmovie.model.entity.Movies;
import com.sh.tmovie.utilis.Constants;
import com.sh.tmovie.webServices.ApiInterface;
import com.sh.tmovie.webServices.ServiceGenerator;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivityViewModel extends AndroidViewModel {
    private final static String TAG = MainActivityViewModel.class.getSimpleName();

    private MutableLiveData<List<Movies>> live_movies = new MutableLiveData<>();

    public MainActivityViewModel(Application application) {
        super(application);
    }

    public MutableLiveData<List<Movies>> getLive_movies() {
        return live_movies;
    }

    public void getMoviesList() {
        ApiInterface apiInterface = ServiceGenerator.createService(ApiInterface.class);
        Call<MoviesResponse> call = apiInterface.getMoviesList(Constants.API_KEY);
        call.enqueue(new Callback<MoviesResponse>() {
            @Override
            public void onResponse(Call<MoviesResponse> call, Response<MoviesResponse> response) {
                if(response.isSuccessful()) {
                    live_movies.postValue(response.body().getResults());
                  /*  Log.d(TAG, "Loading successfully, size: " + response.body());
                    for(Movies movies: response.body().getResults()){
                        moviesList.add(movies);
                    }
                    mMovieAdapter.notifyDataSetChanged();*/
                }else {
                    Log.d(TAG, "Fail" + response.message());
                }
            }

            @Override
            public void onFailure(Call<MoviesResponse> call, Throwable t) {
                Log.d(TAG, "Fail: " + t.getMessage());

            }

        });
    }}
