package com.example.rxjavaexample.root;

import android.content.Context;

import dagger.Module;
import dagger.Provides;

/**
 * Created by tzia on 17-May-17.
 */


@Module
public class ApplicationContextModule
{


    private final Context context;


    public ApplicationContextModule( Context context )
    {

        this.context = context;
    }


    @Provides  // provides a dependency
    public Context context()
    {

        return context;

    }
}
