package com.example.mvp_practice01;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.squareup.picasso.Picasso;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity
{

    @Inject
    Picasso picasso;


    @Inject
    MainActivityAdapter mainActivityAdapter;

    @Override
    protected void onCreate( Bundle savedInstanceState )
    {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );


        MainActivityComponent mainActivityComponent = DaggerMainActivityComponent.builder()
                .mainActivityModule( new MainActivityModule( this ) )  // pass module instance
                .applicationContextComponent( MVP_Practice01.get( this ).component() )  // pass other component instance
                .build();


         mainActivityComponent.injectMainActivity(this); // call inject
        // dependencies which is decoupled with activity

        Log.d( "D-INJECTION", "Picasso:    "+picasso.toString() );
        Log.d( "D-INJECTION", "Adapter:    "+mainActivityAdapter.toString() );
    }
}
