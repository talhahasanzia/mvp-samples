package com.example.mvp_practice01;

import android.content.Context;

import com.squareup.picasso.Picasso;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;


/**
 * Created by tzia on 18-May-17.
 */
@Module(includes = {ContextModule.class})
public class PicassoModule
{


    @Provides
    @ApplicationScope
    public Picasso picasso(@Named("app_context") Context context)
    {

        return new Picasso.Builder(  context)
                .build();


    }
}
