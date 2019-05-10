package com.sh.tmovie.webServices;

import com.sh.tmovie.model.entity.Movies;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

import retrofit2.http.Query;

/**
 * Created by SuHlaing on 26/4/19.
 */

public interface ApiInterface {

    @GET("3/movie/popular")
    Call<ArrayList<Movies>>getMoviesList(@Query("api_key") String apiKey);

}
