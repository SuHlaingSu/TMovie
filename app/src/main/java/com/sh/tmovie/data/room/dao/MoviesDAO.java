package com.sh.tmovie.data.room.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.sh.tmovie.data.room.entity.Movies;

import java.util.List;

import io.reactivex.Flowable;

@Dao
public interface MoviesDAO {
    @Query("SELECT * FROM Movies")
   Flowable<List<Movies>> getMovies();

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertMovie(List<Movies> movie);

    @Query("DELETE FROM movies")
    void deleteAllMovies();

    @Update (onConflict = OnConflictStrategy.REPLACE)
    void updateMovie(Movies movies);
}
