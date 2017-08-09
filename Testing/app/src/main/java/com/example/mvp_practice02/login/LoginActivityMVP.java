package com.example.mvp_practice02.login;

/**
 * Created by tzia on 19-May-17.
 */

public class LoginActivityMVP
{

    public interface View
    {

        String getFirstName();

        void setFirstName( String fname );

        String getLastName();

        void setLastName( String lname );


        void showUserNotAvailable();

        void showInputError();

        void showUserSaved();


    }


    public interface Presenter
    {


        void setView( LoginActivityMVP.View view );

        void loginButtonClicked();

        void getCurrentUser();

        void saveUser();

    }


    public interface Model
    {
        void createUser( String fname, String lname );

        User getUser();

    }
}
