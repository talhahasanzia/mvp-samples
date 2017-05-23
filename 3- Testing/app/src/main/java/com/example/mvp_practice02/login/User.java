package com.example.mvp_practice02.login;

/**
 * Created by tzia on 19-May-17.
 */

public class User
{

    private String id;
    private String fristName;


    public User( String fristName, String lastName )
    {
        this.fristName = fristName;
        this.lastName = lastName;
    }

    public String getId()
    {
        return id;
    }

    public void setId( String id )
    {
        this.id = id;
    }

    public String getFristName()
    {
        return fristName;
    }

    public void setFristName( String fristName )
    {
        this.fristName = fristName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName( String lastName )
    {
        this.lastName = lastName;
    }

    private String lastName;

}
