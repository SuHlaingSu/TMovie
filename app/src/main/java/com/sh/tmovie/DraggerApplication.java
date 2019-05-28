package com.sh.tmovie;

import android.app.Application;

import com.sh.tmovie.di.component.RetrofitComponent;

public class DraggerApplication extends Application {


   static DraggerApplication draggerApplication;

    public static DraggerApplication getInstance() {
        return draggerApplication;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        draggerApplication = this;
    }
}
