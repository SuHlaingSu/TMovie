package com.sh.tmovie.data.room.database;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.sh.tmovie.data.room.dao.MoviesDAO;
import com.sh.tmovie.data.room.entity.Movies;

@Database(entities = {Movies.class}, version = 1, exportSchema = false)

public abstract class MoviesDatabase extends RoomDatabase {
    public abstract MoviesDAO moviesDAO();
}
