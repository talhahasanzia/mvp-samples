package com.example.mvp_practice01;

import android.content.Context;

import com.squareup.picasso.Picasso;

import dagger.Module;
import dagger.Provides;


/**
 * Created by tzia on 18-May-17.
 */
@Module(includes = {ApplicationContextModule.class})
public class PicassoModule
{



    @ApplicationScope
    @Provides
    public Picasso picasso(@AppContextQualifier Context context)
    {

        return new Picasso.Builder(  context)
                .build();


    }
}
