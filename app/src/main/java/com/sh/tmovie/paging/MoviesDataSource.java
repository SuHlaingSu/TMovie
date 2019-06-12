package com.sh.tmovie.paging;

import android.annotation.SuppressLint;
import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.paging.PageKeyedDataSource;

import com.sh.tmovie.data.network.MoviesAPI;
import com.sh.tmovie.data.room.dao.MoviesDAO;
import com.sh.tmovie.data.room.entity.Movies;
import com.sh.tmovie.network.Resource;
import com.sh.tmovie.repository.ApiRepository;

import java.util.List;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public class MoviesDataSource extends PageKeyedDataSource<Long, Movies> {
    private ApiRepository moviesRepository;
    Application application;

    private Disposable disposable = new CompositeDisposable();
    MutableLiveData<List<Movies>> live_movies = new MutableLiveData<>();

    public MutableLiveData<List<Movies>> getLive_movies() {
        return live_movies;
    }

    @SuppressLint("CheckResult")
    @Override
    public void loadInitial(@NonNull LoadInitialParams<Long> params, @NonNull LoadInitialCallback<Long,Movies> callback) {
        moviesRepository.getAllMoviesWithPage(application).subscribe((Resource<List<Movies>> resource) -> {
            if (resource.data != null) {
                Log.d("MOVIE REPOSITORY","GET DATA "+resource.data.size());
                live_movies.postValue(resource.data);
            }
            if (resource.status == Resource.Status.LOADING) {
                Log.d("MOVIE REPOSITORY", "LOADING");
            } else if (resource.status == Resource.Status.SUCCESS) {
                Log.d("MOVIE REPOSITORY", "SUCCESS");
            } else if (resource.status == Resource.Status.ERROR) {
                Log.d("MOVIE REPOSITORY", "ERROR");
            }

        });    }

    @Override
    public void loadBefore(@NonNull LoadParams<Long> params, @NonNull LoadCallback<Long,Movies> callback) {

    }

    @SuppressLint("CheckResult")
    @Override
    public void loadAfter(@NonNull LoadParams<Long> params, @NonNull LoadCallback<Long,Movies> callback) {
        moviesRepository.getAllMoviesWithPage(application).subscribe((Resource<List<Movies>> resource) -> {
            if (resource.data != null) {
                Log.d("MOVIE REPOSITORY","GET DATA "+resource.data.size());
                live_movies.postValue(resource.data);
            }
            if (resource.status == Resource.Status.LOADING) {
                Log.d("MOVIE REPOSITORY", "LOADING");
            } else if (resource.status == Resource.Status.SUCCESS) {
                Log.d("MOVIE REPOSITORY", "SUCCESS");
            } else if (resource.status == Resource.Status.ERROR) {
                Log.d("MOVIE REPOSITORY", "ERROR");
            }

        });
    }
}
