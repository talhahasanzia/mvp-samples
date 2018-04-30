package com.example.mvp_practice02.newsfeed.view;

import android.support.annotation.VisibleForTesting;

import com.example.mvp_practice02.newsfeed.contracts.Presenter;
import com.example.mvp_practice02.newsfeed.contracts.View;
import com.example.mvp_practice02.newsfeed.presenter.NewsfeedPresenter;

/**
 * Created by Talha Hasan Zia on 30-Apr-18.
 * <p></p><b>Description:</b><p></p> Why class was created?
 * <p></p>
 * <b>Public Methods:</b><p></p> Only listing to public methods usage.
 */
public class NewsfeedView implements View {


    private Presenter newsfeedPresenter;

    public NewsfeedView() {
        newsfeedPresenter=new NewsfeedPresenter(this);
        fetchNewsfeed(499);
    }


    private void fetchNewsfeed(int userID){
        newsfeedPresenter.getNewsfeed(userID);
    }

    @Override
    public void setData(String[] newsfeed) {
    }

    @Override
    public void showError(String message) {

    }
}
