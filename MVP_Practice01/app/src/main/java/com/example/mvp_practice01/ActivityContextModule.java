package com.example.mvp_practice01;

import android.app.Activity;
import android.content.Context;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

/**
 * Created by tzia on 18-May-17.
 */


@Module
public class ActivityContextModule
{

    private final Activity context;

    public ActivityContextModule( Activity context)
    {

        this.context=context;
    }




    @Provides  // provides a dependency
    @ApplicationScope  // has app scope, like same object shared with same instance of a builder()
    @Named("activity_context")   // has name qualifier to distinguish this "Context" dependency with any other
    public Context context()
    {

        return context;

    }
}
