package com.sh.tmovie.di.component;

import com.sh.tmovie.data.room.dao.MoviesDAO;
import com.sh.tmovie.di.module.ApplicationContextModule;
import com.sh.tmovie.di.module.RetrofitModule;
import com.sh.tmovie.di.module.RoomModule;
import com.sh.tmovie.viewModel.MainActivityViewModel;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ApplicationContextModule.class,RetrofitModule.class,RoomModule.class})
public interface RetrofitComponent {
    void inject(MainActivityViewModel mainActivityViewModel);
    MoviesDAO moviesDAO();
}
