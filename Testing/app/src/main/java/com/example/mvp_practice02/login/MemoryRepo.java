package com.example.mvp_practice02.login;

/**
 * Created by tzia on 19-May-17.
 */

public class MemoryRepo implements LoginRepo
{
    private User user;


    @Override public User getUser()
    {
        if ( user == null )
        {


            user = new User( "Michael", "Osama" );


        }


        return user;
    }

    @Override public void saveUser( User user )
    {


        if ( user == null )
        {
            user = getUser();
        }


        this.user = user;


    }
}
