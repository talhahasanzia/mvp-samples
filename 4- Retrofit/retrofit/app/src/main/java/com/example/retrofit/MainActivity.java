package com.example.retrofit;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.retrofit.http.apimodel.Stream;
import com.example.retrofit.http.apimodel.Twitch;
import com.example.retrofit.http.apimodel.TwitchAPI;
import com.example.retrofit.root.App;
import com.example.retrofit.root.ApplicationContextComponent;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity
{

    @Inject TwitchAPI twitchAPI;

    private ApplicationContextComponent applicationContextComponent;
    private App app;

    @Override
    protected void onCreate( Bundle savedInstanceState )
    {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        app = App.get( this );


        applicationContextComponent = app.getComponent();


        applicationContextComponent.inject( this );


        Call<Twitch> call = twitchAPI.getTopGames();

        call.enqueue( new Callback<Twitch>()
        {
            @Override public void onResponse( Call<Twitch> call, Response<Twitch> response )
            {
                List<Stream> gameList = response.body().getStreams();


                for ( Stream game : gameList )
                {
                    Log.i( "RETRO_RESPONSE", "onResponse: " + game.getGame() );
                }
            }

            @Override public void onFailure( Call<Twitch> call, Throwable t )
            {

            }
        } );

    }
}
