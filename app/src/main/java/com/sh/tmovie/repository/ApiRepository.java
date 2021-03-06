package com.sh.tmovie.repository;

import android.content.Context;

import com.sh.tmovie.DraggerApplication;
import com.sh.tmovie.data.network.response.MoviesListResponse;
import com.sh.tmovie.data.room.dao.MoviesDAO;
import com.sh.tmovie.data.room.entity.Movies;
import com.sh.tmovie.di.component.RetrofitComponent;
import com.sh.tmovie.network.NetworkBoundResource;
import com.sh.tmovie.network.Resource;
import com.sh.tmovie.utilis.Constants;
import com.sh.tmovie.data.network.MoviesAPI;
import com.sh.tmovie.viewModel.MainActivityViewModel;

import java.util.List;

import io.reactivex.Flowable;
import retrofit2.Response;

public class ApiRepository {
   //private LocalRepository localRepository;
   MoviesAPI moviesAPI;
   MoviesDAO moviesDAO;

    public ApiRepository(MoviesAPI moviesAPI, MoviesDAO moviesDAO) {
        this.moviesAPI = moviesAPI;
        this.moviesDAO = moviesDAO;
    }

    public Flowable<Resource<List<Movies>>> getAllMovies(Context context)
    {
        return new NetworkBoundResource<List<Movies>, MoviesListResponse>(context)
        {
            @Override
            protected void saveCallResult(MoviesListResponse request) {
                moviesDAO.insertMovie(request.getResults());

            }

            @Override
            protected Flowable<List<Movies>> loadFromDb() {
                return moviesDAO.getMovies();

            }

            @Override
            protected Flowable<Response<MoviesListResponse>> createCall() {
                return moviesAPI.getMoviesList(Constants.API_KEY);// new RetrofitClient().create(Constants.BASE_API_URL,true).create(MoviesAPI.class).getMoviesList(Constants.API_KEY);

            }
        }.asFlowable();
    }

    public Flowable<Resource<List<Movies>>> getAllMoviesWithPage(Context context)
    {
        return new NetworkBoundResource<List<Movies>, MoviesListResponse>(context)
        {
            @Override
            protected void saveCallResult(MoviesListResponse request) {
                moviesDAO.insertMovie(request.getResults());

            }

            @Override
            protected Flowable<List<Movies>> loadFromDb() {
                return moviesDAO.getMovies();

            }

            @Override
            protected Flowable<Response<MoviesListResponse>> createCall() {
                return moviesAPI.getMoviesListWithPaging(Constants.API_KEY,40);// new RetrofitClient().create(Constants.BASE_API_URL,true).create(MoviesAPI.class).getMoviesList(Constants.API_KEY);

            }
        }.asFlowable();
    }
}
