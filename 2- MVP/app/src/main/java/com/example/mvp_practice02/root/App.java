package com.example.mvp_practice02.root;

import android.app.Application;

/**
 * Created by tzia on 19-May-17.
 */

public class App extends Application
{

    ApplicationComponent component;

    @Override public void onCreate()
    {
        super.onCreate();

        component = DaggerApplicationComponent
                .builder()
                .applicationModule( new ApplicationModule( this ) )
                .build();
    }


    public ApplicationComponent get()
    {


        return component;


    }
}
