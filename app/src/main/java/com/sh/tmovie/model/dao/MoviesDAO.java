package com.sh.tmovie.model.dao;

import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.sh.tmovie.model.entity.Movies;

import java.util.List;

public interface MoviesDAO {
    @Query("SELECT * FROM Movies")
    List<Movies> getMovies();

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertMovie(Movies movie);

    @Query("DELETE FROM movies")
    abstract void deleteAllMovies();
}
