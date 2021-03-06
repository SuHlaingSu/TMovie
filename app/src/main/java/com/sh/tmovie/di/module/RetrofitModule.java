package com.sh.tmovie.di.module;

import com.sh.tmovie.data.network.MoviesAPI;
import com.sh.tmovie.utilis.Constants;

import javax.inject.Inject;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class RetrofitModule {

    @Singleton
    @Provides
    public MoviesAPI getMovieApi (Retrofit retrofit)
    {
        return retrofit.create(MoviesAPI.class);
    }

    @Provides
    public HttpLoggingInterceptor provideHttpLoggingInterceptor()
    {
        return new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);
    }

    @Provides
    public OkHttpClient provideOkHttpClient(HttpLoggingInterceptor httpLoggingInterceptor)
    {
        return new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build();
    }

    @Provides
    public Retrofit provideRetrofit(OkHttpClient okHttpClient)
    {
        return new Retrofit.Builder().addCallAdapterFactory(RxJava2CallAdapterFactory.create()).addConverterFactory(GsonConverterFactory.create()).baseUrl(Constants.BASE_API_URL).client(okHttpClient).build();
    }
}
