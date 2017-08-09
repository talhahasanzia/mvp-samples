package com.example.mvp_practice01;

import android.content.Context;

import com.squareup.picasso.Picasso;

import dagger.Component;

/**
 * Created by tzia on 17-May-17.
 */

@ApplicationScope // Add this to scope application, this will share objects within a scope
@Component(modules = {PicassoModule.class})  // Search for dependencies in these listed modules or components in some cases
public interface ApplicationContextComponent
{

    Picasso getPicasso();

    @AppContextQualifier Context getContext();
}
