package com.sh.tmovie.di.module;

import com.sh.tmovie.DraggerApplication;

import dagger.Module;

@Module
public class ApplicationContextModule {
    private DraggerApplication application;

    public ApplicationContextModule(DraggerApplication application) {
        this.application=application;
    }

    public DraggerApplication provideAppContext()
    {
        return application;
    }
}
