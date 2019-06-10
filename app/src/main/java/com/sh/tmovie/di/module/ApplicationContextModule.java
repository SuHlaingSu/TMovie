package com.sh.tmovie.di.module;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationContextModule {
    private Application application;

    public ApplicationContextModule(Application application) {
        this.application=application;
    }

    @Provides
    @Singleton
    public Application provideAppContext()
    {
        return application;
    }
}
