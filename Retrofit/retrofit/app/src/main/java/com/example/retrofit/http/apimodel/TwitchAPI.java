package com.example.retrofit.http.apimodel;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by tzia on 24-May-17.
 */

public interface TwitchAPI
{

    @GET("streams")
    Call<Twitch> getTopGames();
}
