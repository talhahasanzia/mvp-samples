package com.example.rxjavaexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.example.rxjavaexample.http.apimodel.Stream;
import com.example.rxjavaexample.http.apimodel.Twitch;
import com.example.rxjavaexample.http.apimodel.TwitchAPI;
import com.example.rxjavaexample.root.App;
import com.example.rxjavaexample.root.ApplicationContextComponent;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity
{
	
	
	@BindView(R.id.text_view)
	TextView textView;
	
	
	@Inject
	TwitchAPI twitchAPI;
	
	private ApplicationContextComponent applicationContextComponent;
	private App app;
	
	@Override
	protected void onCreate( Bundle savedInstanceState )
	{
		super.onCreate( savedInstanceState );
		setContentView( R.layout.activity_main );
		
		
		ButterKnife.bind( this );
		
		app = App.get( this );
		
		
		applicationContextComponent = app.getComponent();
		
		
		applicationContextComponent.inject( this );
		
		// Retrofit2
		 Call<Twitch> call = twitchAPI.getTopGames();
		
		call.enqueue( new Callback<Twitch>()
		{
			@Override
			public void onResponse( Call<Twitch> call, Response<Twitch> response )
			{
				List<Stream> gameList = response.body().getStreams();
				
				
				for ( Stream game : gameList )
				{
					Log.i( "RETRO_RESPONSE", "onResponse: " + game.getGame() );
				}
			}
			
			@Override
			public void onFailure( Call<Twitch> call, Throwable t )
			{
				
			}
		} );
		
		// RxJava
		
		/*Observable<String> sampleStringObservable = Observable.fromCallable( new Callable<String>()
		{
			@Override
			public String call() throws Exception
			{
				
				Thread.sleep( 5000 );
				return "Hello from callable sample observable string!";
			}
		} );
		
		sampleStringObservable.observeOn( AndroidSchedulers.mainThread() )
				.subscribeOn( Schedulers.io() )
				.subscribe( new Observer<String>()
				{
					@Override
					public void onCompleted()
					{
						
					}
					
					@Override
					public void onError( @NonNull Throwable e )
					{
						
					}
					
					@Override
					public void onNext( @NonNull String s )
					{
						
						
						textView.setText( s + " On Next" );
						
					}
				} )
		;*/
		
		
		twitchAPI.getTopGamesObservable().flatMap(new Func1<Twitch, Observable<Stream>>() {
			@Override
			public Observable<Stream> call(Twitch twitch) {
				
				return Observable.from(twitch.getStreams());
			}
		}).flatMap(new Func1<Stream, Observable<String>>() {
			@Override
			public Observable<String> call(Stream top) {
				
				return Observable.just(top.getGame());
				
			}
		}).subscribeOn( Schedulers.io()).observeOn( AndroidSchedulers.mainThread()).subscribe( new Observer<String>() {
			@Override
			public void onCompleted() {
				
			}
			
			@Override
			public void onError(Throwable e) {
				
			}
			
			@Override
			public void onNext(String s) {
				
				System.out.println("From rx java: " + s);
			}
		});
		
	}
}
