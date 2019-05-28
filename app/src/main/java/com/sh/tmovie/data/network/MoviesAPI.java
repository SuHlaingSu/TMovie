package com.sh.tmovie.data.network;

import com.sh.tmovie.data.network.response.MoviesListResponse;

import io.reactivex.Flowable;
import retrofit2.Response;
import retrofit2.http.GET;

import retrofit2.http.Query;

/**
 * Created by SuHlaing on 26/4/19.
 */

public interface MoviesAPI {

    @GET("3/movie/popular")
    Flowable<Response<MoviesListResponse>> getMoviesList(@Query("api_key") String apiKey);

}
