package com.example.mvp_practice02.root;

import android.app.Application;
import android.content.Context;

import dagger.Module;
import dagger.Provides;

/**
 * Created by tzia on 19-May-17.
 */


@Module
public class ApplicationModule
{


    private final Application application;


    public ApplicationModule( Application application )
    {
        this.application = application;
    }


    @Provides
    @ApplicationScope
    public Context application()
    {

        return application;

    }
}
