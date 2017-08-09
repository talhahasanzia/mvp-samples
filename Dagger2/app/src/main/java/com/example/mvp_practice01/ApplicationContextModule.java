package com.example.mvp_practice01;

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
    @ApplicationScope  // has app scope, like same object shared with same instance of a builder()
    @AppContextQualifier // Custom qualifier
    // has name qualifier to distinguish this "Context" dependency with any other
    public Context context()
    {

        return context;

    }
}
