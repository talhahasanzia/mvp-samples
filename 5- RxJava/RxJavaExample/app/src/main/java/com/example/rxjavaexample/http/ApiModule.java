package com.example.rxjavaexample.http;

import android.content.Context;

import com.example.rxjavaexample.R;
import com.example.rxjavaexample.http.apimodel.TwitchAPI;
import com.example.rxjavaexample.root.ApplicationContextModule;

import java.io.IOException;

import dagger.Module;
import dagger.Provides;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

;

/**
 * Created by tzia on 24-May-17.
 */
@Module(includes = ApplicationContextModule.class)
public class ApiModule
{

    public final String BASE_URL = "https://api.twitch.tv/kraken/";

    @Provides
    public OkHttpClient provideClient( final Context context )
    {


        OkHttpClient.Builder httpClient =
                new OkHttpClient.Builder();


        httpClient.addInterceptor( new Interceptor()
        {
            @Override
            public Response intercept( Interceptor.Chain chain )
            {
                Request original = chain.request();
                HttpUrl originalHttpUrl = original.url();

                HttpUrl url = originalHttpUrl.newBuilder()
                        .addQueryParameter( "client_id", context.getString( R.string.twitch_id ) )
                        .build();

                // Request customization: add request headers
                Request.Builder requestBuilder = original.newBuilder()
                        .url( url );

                Request request = requestBuilder.build();
                try
                {
                    return chain.proceed( request );
                }
                catch ( IOException e )
                {
                    e.printStackTrace();
                    return null;
                }

            }
        } );


        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();


        interceptor.setLevel( HttpLoggingInterceptor.Level.HEADERS );
        return httpClient.addInterceptor( interceptor )
                .build();

    }

    @Provides
    public Retrofit provideRetrofit( String baseURL, OkHttpClient client )
    {
        return new Retrofit.Builder()
                .baseUrl( baseURL )
                .client( client )
                .addConverterFactory( GsonConverterFactory.create() )
                .addCallAdapterFactory( RxJava2CallAdapterFactory.create() )
                .build();
    }

    @Provides
    public TwitchAPI provideApiService(Context context)
    {
        return provideRetrofit( BASE_URL, provideClient(context) ).create( TwitchAPI.class );
    }
}
