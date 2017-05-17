package com.example.mvp_practice01;

import android.app.Application;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by tzia on 17-May-17.
 */

public class MVP_Application extends Application
{

    public static MVP_Application get(AppCompatActivity appCompatActivity)
    {
        return (MVP_Application) appCompatActivity.getApplication();

    }


    @Override public void onCreate()
    {
        super.onCreate();

        ContextModule contextModule=new ContextModule( this );

        ApplicationContextComponent component=DaggerApplicationContextComponent.builder()
                .contextModule(contextModule)
                .build();




    }
}
