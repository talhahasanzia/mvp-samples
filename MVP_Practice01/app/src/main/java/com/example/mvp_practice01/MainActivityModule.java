package com.example.mvp_practice01;

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

   /* @Provides
    @MainActivityScope
    public MainActivityAdapter adapter( Picasso picasso )//  <<--This will cause error because picasso provider is
    {                                                    //      accessible at Application scope, so we need these
        //      two components of different scopes to  communicate.

        return new MainActivityAdapter( mainActivity );

    }*/


    // We made activity injectable by @Provides
    // we inject this in Adapter constructor by
    // changing parameter to Activity and calling
    // @Inject and a parameter.

    // This will only be possible if we have
    // access to our constructor like our user
    // defined constructor.

    // In picasso we cannot do this because we do
    // not have control to Picasso constructor.

    @Provides
    @MainActivityScope
    public MainActivity mainActivity()
    {

        return mainActivity;

    }
}
