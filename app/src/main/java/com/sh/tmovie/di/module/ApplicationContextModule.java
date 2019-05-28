package com.sh.tmovie.di.module;

import com.sh.tmovie.DraggerApplication;

import dagger.Module;

@Module
public class ApplicationContextModule {
    public DraggerApplication draggerApplication;

    public ApplicationContextModule(DraggerApplication draggerApplication) {
        this.draggerApplication=draggerApplication;
    }

    public DraggerApplication provideDraggerApplication()
    {
        return draggerApplication;
    }
}
