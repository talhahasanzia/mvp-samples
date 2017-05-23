package com.example.mvp_practice02.root;

import com.example.mvp_practice02.login.LoginActivityView;
import com.example.mvp_practice02.login.LoginModule;

import dagger.Component;

/**
 * Created by tzia on 19-May-17.
 */
@ApplicationScope
@Component(modules = {ApplicationModule.class, LoginModule.class})
public interface ApplicationComponent
{

    // parameter specifies where presenter will be injected
    void inject(LoginActivityView loginActivityView );

}
