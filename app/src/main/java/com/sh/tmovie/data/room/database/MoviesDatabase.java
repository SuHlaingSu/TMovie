package com.sh.tmovie.data.room.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.sh.tmovie.data.room.dao.MoviesDAO;
import com.sh.tmovie.data.room.entity.Movies;

import static com.sh.tmovie.utilis.Constants.DATA_BASE_NAME;

@Database(entities = {Movies.class}, version = 1, exportSchema = false)

public abstract class MoviesDatabase extends RoomDatabase {
    public abstract MoviesDAO moviesDAO();
}
