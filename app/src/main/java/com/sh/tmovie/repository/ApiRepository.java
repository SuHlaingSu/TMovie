package com.sh.tmovie.repository;

import android.content.Context;

import com.sh.tmovie.data.network.response.MoviesListResponse;
import com.sh.tmovie.data.room.entity.Movies;
import com.sh.tmovie.network.NetworkBoundResource;
import com.sh.tmovie.network.Resource;
import com.sh.tmovie.utilis.Constants;
import com.sh.tmovie.data.network.MoviesAPI;

import java.util.List;

import io.reactivex.Flowable;
import retrofit2.Response;

public class ApiRepository {
   private LocalRepository localRepository;

    public ApiRepository(LocalRepository localRepository) {
        this.localRepository = localRepository;
    }

    public Flowable<Resource<List<Movies>>> getAllMovies(Context context)
    {
        return new NetworkBoundResource<List<Movies>, MoviesListResponse>(context)
        {
            @Override
            protected void saveCallResult(MoviesListResponse request) {
                localRepository.saveMovies(request.getResults());

            }

            @Override
            protected Flowable<List<Movies>> loadFromDb() {
                return localRepository.fetchLocalMovies();

            }

            @Override
            protected Flowable<Response<MoviesListResponse>> createCall() {
                return null;// new RetrofitClient().create(Constants.BASE_API_URL,true).create(MoviesAPI.class).getMoviesList(Constants.API_KEY);

            }
        }.asFlowable();
    }
}
