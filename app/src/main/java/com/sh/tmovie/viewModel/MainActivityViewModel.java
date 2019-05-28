package com.sh.tmovie.viewModel;

import android.annotation.SuppressLint;
import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.MutableLiveData;
import android.content.Context;
import android.util.Log;

import com.sh.tmovie.DraggerApplication;
import com.sh.tmovie.data.room.entity.Movies;
import com.sh.tmovie.network.Resource;
import com.sh.tmovie.repository.ApiRepository;
import com.sh.tmovie.repository.LocalRepository;
import java.util.List;

import javax.inject.Inject;

public class MainActivityViewModel extends AndroidViewModel {
    @Inject
    private final static String TAG = MainActivityViewModel.class.getSimpleName();
    private ApiRepository apiRepository;

     MutableLiveData<List<Movies>> live_movies = new MutableLiveData<>();

    public MainActivityViewModel(Application application) {
        super(application);
        LocalRepository localSource = LocalRepository.getInstance(application);
        apiRepository = new ApiRepository(localSource);
    }

    public MutableLiveData<List<Movies>> getLive_movies() {
        return live_movies;
    }

    @SuppressLint("CheckResult")
    public void getMoviesList(Context context) {
        apiRepository.getAllMovies(context).subscribe((Resource<List<Movies>> resource) -> {
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
