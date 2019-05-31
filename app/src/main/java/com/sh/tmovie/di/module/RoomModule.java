package com.sh.tmovie.di.module;

import android.app.Application;
import androidx.room.Room;

import com.sh.tmovie.data.room.dao.MoviesDAO;
import com.sh.tmovie.data.room.database.MoviesDatabase;
import com.sh.tmovie.utilis.Constants;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class RoomModule {
    @Provides
    public MoviesDatabase provideMoviesDatabase(Application application)
    {
        return Room.databaseBuilder(application,MoviesDatabase.class, Constants.DATA_BASE_NAME).fallbackToDestructiveMigration().build();
    }

    @Provides
    @Singleton
    public MoviesDAO provideMovieDAO (MoviesDatabase moviesDatabase)
    {
        return moviesDatabase.moviesDAO();
    }
}
