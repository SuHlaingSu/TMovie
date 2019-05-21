package com.sh.tmovie.model.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.sh.tmovie.model.dao.MoviesDAO;
import com.sh.tmovie.model.entity.Movies;

import static com.sh.tmovie.utilis.Constants.DATA_BASE_NAME;

@Database(entities = {Movies.class}, version = 1, exportSchema = false)

public abstract class MoviesDatabase extends RoomDatabase {
    private static MoviesDatabase instance;
    public static MoviesDatabase getInstance(Context context) {

            if (instance == null) {
                instance = Room.databaseBuilder(context.getApplicationContext(),
                        MoviesDatabase.class, DATA_BASE_NAME)
                        .allowMainThreadQueries()
                        .build();

            }
            return instance;

    }

    public abstract MoviesDAO moviesDAO();
}
