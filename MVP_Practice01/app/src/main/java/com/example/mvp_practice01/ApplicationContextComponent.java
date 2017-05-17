package com.example.mvp_practice01;

import android.content.Context;

import dagger.Component;

/**
 * Created by tzia on 17-May-17.
 */


@Component(modules = ContextModule.class)
public interface ApplicationContextComponent
{

    Context getContext();
}
