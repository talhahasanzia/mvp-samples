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
- You can use replacement blocks and query parameters to adjust the URL. A replacement block is added to the relative URL with {}. With the help of the @Path annotation on the method parameter, the value of that parameter is bound to the specific replacement block.
  ```
  @GET("users/{name}/commits")
  Call<List<Commit>> getCommitsByName(@Path("name") String name)
  ```
- Query parameters are added with the @Query annotation on a method parameter. They are automatically added at the end of the URL.
   ```
   @GET("users")
  Call<User> getUserById(@Query("id") Integer id)
  ```
- The @Body annotation on a method parameter tells Retrofit to use the object as the request body for the call.
   ```
   @POST("users")
   Call<User> postUser(@Body User user)
  ```
- Use following Retrofit example to see how we made an API request:
    ```
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
      ```
  
  
  Here is a link to a good tutorial discussing retrofit in details. 
  
  Vogella Retrofit tutorial
  
  [GitHub Pages](https://pages.github.com/)
