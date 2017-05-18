package com.example.mvp_practice01;

import dagger.Component;

/**
 * Created by tzia on 18-May-17.
 * Component for MainActivity
 */
@MainActivityScope                                 // use other component for picasso dependencies
@Component(modules = {MainActivityModule.class}, dependencies = {ApplicationContextComponent.class})
public interface MainActivityComponent
{


    MainActivityAdapter mainActivityAdapter();

}
