package com.example.mvp_practice01;

import android.app.Application;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by tzia on 17-May-17.
 */

public class MVP_Practice01 extends Application
{

    Context context;


    private ApplicationContextComponent component;

    public static MVP_Practice01 get(AppCompatActivity appCompatActivity)
    {
        return (MVP_Practice01) appCompatActivity.getApplication();

    }


    @Override public void onCreate()
    {
        super.onCreate();

        ApplicationContextModule applicationContextModule =new ApplicationContextModule( this );

        component=DaggerApplicationContextComponent.builder()
                .applicationContextModule( applicationContextModule )
                .build();

        context=component.getContext();




    }

    public ApplicationContextComponent component()
    {

        return component;

    }

    public Context getMVP_ApplicationContext()
    {

        return context;
    }
}
