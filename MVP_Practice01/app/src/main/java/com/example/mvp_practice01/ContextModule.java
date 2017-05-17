package com.example.mvp_practice01;

import android.content.Context;

import dagger.Module;
import dagger.Provides;

/**
 * Created by tzia on 17-May-17.
 */


@Module
public class ContextModule
{


    private Context context;

    public ContextModule( Context context )
    {

        this.context = context;
    }

    @Provides
    public Context context()
    {

        return context;

    }
}
