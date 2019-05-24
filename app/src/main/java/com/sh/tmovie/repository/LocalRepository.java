package com.sh.tmovie.repository;

import android.app.Application;

import com.sh.tmovie.model.database.MoviesDatabase;
import com.sh.tmovie.model.entity.Movies;

import java.util.List;

import io.reactivex.Flowable;

public class LocalRepository {
    private static LocalRepository instance;
    private Application application;

    public static LocalRepository getInstance(Application application) {
        if(instance == null)
        {
            instance = new LocalRepository(application);
        }
        return instance;
    }
    //Constructor
    public LocalRepository(Application application) {
        this.application = application;
    }

    public void saveMovies(List<Movies> movies)
    {
        MoviesDatabase.getInstance(application).moviesDAO().insertMovie(movies);
    }

    Flowable<List<Movies>> fetchLocalMovies()
    {
        return MoviesDatabase.getInstance(application).moviesDAO().getMovies();
    }
}
