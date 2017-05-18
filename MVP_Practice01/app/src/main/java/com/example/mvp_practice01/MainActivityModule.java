package com.example.mvp_practice01;

import com.squareup.picasso.Picasso;

import dagger.Module;
import dagger.Provides;

/**
 * Created by tzia on 18-May-17.
 */

@Module(includes = ApplicationContextModule.class)
public class MainActivityModule
{

    private final MainActivity mainActivity;


    public MainActivityModule( MainActivity mainActivity )
    {
        this.mainActivity = mainActivity;
    }

    @Provides
    @MainActivityScope
    public MainActivityAdapter adapter( Picasso picasso )//  <<--This will cause error because picasso provider is
    {                                                    //      accessible at Application scope, so we need these
                                                         //      two components of different scopes to  communicate.

        return new MainActivityAdapter( mainActivity );

    }
}
