package com.example.mvp_practice02.login;

import android.support.annotation.Nullable;

import com.example.mvp_practice02.login.LoginActivityMVP.Presenter;

/**
 * Created by tzia on 19-May-17.
 */

public class LoginActivityPresenter implements Presenter
{
    @Nullable
    LoginActivityMVP.View view;

    LoginActivityMVP.Model model;

    public LoginActivityPresenter( LoginActivityMVP.Model model )
    {
        this.model = model;
    }

    @Override public void setView( LoginActivityMVP.View view )
    {
        this.view = view;
    }

    @Override public void loginButtonClicked()
    {


        if ( view != null )
        {

            if ( view.getFirstName().trim().equals( "" ) || view.getLastName().equals( "" ) )
            {

                view.showInputError();
            }
            else

            {


                model.createUser( view.getFirstName(), view.getLastName() );
                view.showUserSaved();
            }

        }

    }

    @Override public void getCurrentUser()
    {

        User user = model.getUser();


        if ( user == null )
        {

            if ( view != null )
            {

                view.showUserNotAvailable();

            }

        }
        else
        {
            if(view!=null)
            {

                view.setFirstName( user.getFristName() );
                view.setLastName( user.getLastName() );

            }


        }

    }
}
