# Retrofit Example

This project contains retrofit2 library implementation of a simple GET call to Twitch API. This also follows MVP pattern and
uses dagger2 for dependency injection.

Retrofit is a REST client for Android which makes it easy to consume RESTful APIs.

## Notes
- Create API model for data mapping, usually data is in JSON form, so create classes that map JSON objects.
- To achieve above simply use [jsonschema2pojo](http://www.jsonschema2pojo.org/) tool, copy paste JSON sample response
  and generate classes. (add these classes to model)
- Create an interface that implements REST client methods, like GET with @GET annotation, in our example its "TwitchAPI" interface.
- This object will be used to call Retrofit methods.
- Create Module in dagger2 which will provide dependencies like customized OkHttp3 object, Retrofit object and finally,
  our TwitchAPI interface object.
- Inject the TwitchAPI in activity using component object.
- Use following Retrofit example to see how we made an API request:
    ```Call<Twitch> call = twitchAPI.getTopGames();

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
      
  
