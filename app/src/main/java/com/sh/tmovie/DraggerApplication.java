package com.sh.tmovie;

import android.app.Application;

import com.sh.tmovie.di.component.RetrofitComponent;
import com.sh.tmovie.di.module.ApplicationContextModule;

public class DraggerApplication extends Application {
    RetrofitComponent component;
   static DraggerApplication application;

    public static DraggerApplication getInstance() {
        return application;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        application = this;
        //component=DaggerRetrofitComponent.builder().applicationContextModule(new ApplicationContextModule(this)).build();
    }

    public RetrofitComponent getComponent(){
        return component;
    }
}
