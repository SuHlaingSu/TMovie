package com.sh.tmovie.viewModel;

import android.annotation.SuppressLint;
import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import android.content.Context;
import android.util.Log;

import com.sh.tmovie.DraggerApplication;
import com.sh.tmovie.data.network.MoviesAPI;
import com.sh.tmovie.data.room.dao.MoviesDAO;
import com.sh.tmovie.data.room.entity.Movies;
import com.sh.tmovie.network.Resource;
import com.sh.tmovie.repository.ApiRepository;
import com.sh.tmovie.repository.LocalRepository;
import com.sh.tmovie.utilis.Constants;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MainActivityViewModel extends AndroidViewModel {
    @Inject
    public MoviesAPI movieApi;
    @Inject
    public MoviesDAO moviesDAO;
    private Disposable disposable = new CompositeDisposable();

    private final static String TAG = MainActivityViewModel.class.getSimpleName();
    private ApiRepository apiRepository;

     MutableLiveData<List<Movies>> live_movies = new MutableLiveData<>();

     public MutableLiveData<List<Movies>> getLive_movies() {
        return live_movies;
    }

    public MainActivityViewModel(Application application) {
        super(application);
        DraggerApplication.getInstance().getComponent().inject(this);
        if (movieApi == null) {
            Log.d(TAG, "MainActivityViewModel: MOVIE API IS NULL");
        } else {
            Log.d(TAG, "MainActivityViewModel: MOVIE API IS NOT NULL");
        }
        LocalRepository localSource = LocalRepository.getInstance(application);
        apiRepository = new ApiRepository(localSource);
    }

//    public void getFromAPI() {
//        disposable = movieApi.getMoviesList(Constants.API_KEY)
//                .subscribeOn(Schedulers.io())
//                .observeOn(Schedulers.computation())
//                .map(popularResponseResponse -> popularResponseResponse.body().getResults())
//                .onErrorReturn(throwable -> null)
//                .subscribe(movies -> liveData.postValue(movies));
//
//    }
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
