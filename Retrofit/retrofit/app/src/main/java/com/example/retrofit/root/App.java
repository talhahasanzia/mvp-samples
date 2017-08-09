package com.example.retrofit.root;

import android.app.Application;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by tzia on 24-May-17.
 */

public class App extends Application
{


    private ApplicationContextComponent component;


    public static App get( AppCompatActivity appCompatActivity )
    {
        return (App) appCompatActivity.getApplication();

    }

    @Override public void onCreate()
    {
        super.onCreate();


        ApplicationContextModule applicationContextModule = new ApplicationContextModule( this );

        component = DaggerApplicationContextComponent.builder()
                .applicationContextModule( applicationContextModule )
                .build();

    }


    public ApplicationContextComponent getComponent()
    {

        return component;

    }
}
