package com.example.mvp_practice02.newsfeed.interactor;

import com.example.mvp_practice02.newsfeed.contracts.Interactor;
import com.example.mvp_practice02.newsfeed.contracts.InteractorOut;

/**
 * Created by Talha Hasan Zia on 30-Apr-18.
 * <p></p><b>Description:</b><p></p> Why class was created?
 * <p></p>
 * <b>Public Methods:</b><p></p> Only listing to public methods usage.
 */
public class NewsfeedInteractor implements Interactor {

    private InteractorOut newsfeedPresenter;
    public NewsfeedInteractor(InteractorOut newsfeedPresenter) {
        this.newsfeedPresenter=newsfeedPresenter;
    }

    @Override
    public void fetchNewsfeed(int userId) {
        // fetch newsfeed
        double random=  Math.random()*3+1; // some dummy operation

       if(random%2==0)
       {
           newsfeedPresenter.onFailureNewsfeed("Failed to fetch data.");
       }
       else
       {
           String[] newsfeed={"Sample post happy", "Sample post sad", "Sample status update", "Sample share"};
           newsfeedPresenter.onSuccessNewsfeed(newsfeed);
       }
    }
}
