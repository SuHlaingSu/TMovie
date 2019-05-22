package com.sh.tmovie.model.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.sh.tmovie.model.entity.Movies;

import java.util.List;

import io.reactivex.Flowable;

@Dao
public interface MoviesDAO {
    @Query("SELECT * FROM Movies")
   Flowable<List<Movies>> getMovies();

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertMovie(Movies movie);

    @Query("DELETE FROM movies")
    abstract void deleteAllMovies();

    @Update (onConflict = OnConflictStrategy.REPLACE)
    void updateMovie(Movies movies);
}
