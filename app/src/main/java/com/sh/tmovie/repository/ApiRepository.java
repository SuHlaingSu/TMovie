package com.sh.tmovie.repository;

import android.content.Context;

import com.sh.tmovie.JsonResponse.MoviesResponse;
import com.sh.tmovie.model.entity.Movies;
import com.sh.tmovie.network.NetworkBoundResource;
import com.sh.tmovie.network.Resource;

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
        return new NetworkBoundResource<List<Movies>, MoviesResponse>(context)
        {
            @Override
            protected void saveCallResult(MoviesResponse request) {

            }

            @Override
            protected Flowable<List<Movies>> loadFromDb() {
                return null;
            }

            @Override
            protected Flowable<Response<MoviesResponse>> createCall() {
                return null;
            }
        }.asFlowable();
    }
}
