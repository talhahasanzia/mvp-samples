package com.example.mvp_practice02.login;

import com.example.mvp_practice02.login.LoginActivityMVP.Model;

/**
 * Created by tzia on 19-May-17.
 */

public class LoginActivityModel implements Model
{
    private LoginRepo loginRepo;


    public LoginActivityModel( LoginRepo loginRepo )
    {
        this.loginRepo = loginRepo;
    }

    @Override public void createUser( String fname, String lname )
    {
        User user= new User( fname, lname );

        loginRepo.saveUser( user );
    }

    @Override public User getUser()
    {
        return loginRepo.getUser();
    }
}
