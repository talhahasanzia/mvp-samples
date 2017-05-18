package com.example.mvp_practice01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate( Bundle savedInstanceState )
    {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );


        MainActivityComponent mainActivityComponent=DaggerMainActivityComponent.builder()
                .mainActivityModule( new MainActivityModule( this ) )  // pass module instance
                .applicationContextComponent( MVP_Application.get( this ).component() )  // pass other compoonent instance
                .build();


        MainActivityAdapter mainActivityAdapter=mainActivityComponent.mainActivityAdapter(); // we got adapter
                                                                                            // which is decoupled with activity


    }
}
