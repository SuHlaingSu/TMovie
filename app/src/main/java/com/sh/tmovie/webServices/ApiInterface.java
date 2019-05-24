package com.sh.tmovie.webServices;

import com.sh.tmovie.JsonResponse.MoviesResponse;

import io.reactivex.Flowable;
import retrofit2.Response;
import retrofit2.http.GET;

import retrofit2.http.Query;

/**
 * Created by SuHlaing on 26/4/19.
 */

public interface ApiInterface {

    @GET("3/movie/popular")
    Flowable<Response<MoviesResponse>> getMoviesList(@Query("api_key") String apiKey);

}
