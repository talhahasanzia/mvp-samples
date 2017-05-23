package com.example.mvp_practice02.login;

/**
 * Created by tzia on 19-May-17.
 */

public interface LoginRepo
{

    User getUser();

    void saveUser( User user );

}
