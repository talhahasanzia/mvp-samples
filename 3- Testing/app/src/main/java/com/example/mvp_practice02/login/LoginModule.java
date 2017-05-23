package com.example.mvp_practice02.login;

import dagger.Module;
import dagger.Provides;

/**
 * Created by tzia on 19-May-17.
 */

@Module
public class LoginModule
{


    @Provides
    public LoginActivityMVP.Presenter presenter(LoginActivityMVP.Model model)
    {


        return new LoginActivityPresenter(model);

    }


    @Provides
    public LoginActivityMVP.Model model(LoginRepo loginRepo)
    {


        return new LoginActivityModel( loginRepo );

    }



    @Provides
    public LoginRepo loginRepo()
    {


        return new MemoryRepo();

    }




}
