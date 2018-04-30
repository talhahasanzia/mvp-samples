package com.example.mvp_practice02.newsfeed.presenter;

import com.example.mvp_practice02.newsfeed.contracts.Interactor;
import com.example.mvp_practice02.newsfeed.contracts.InteractorOut;
import com.example.mvp_practice02.newsfeed.contracts.Presenter;
import com.example.mvp_practice02.newsfeed.contracts.View;
import com.example.mvp_practice02.newsfeed.interactor.NewsfeedInteractor;

/**
 * Created by Talha Hasan Zia on 30-Apr-18.
 * <p></p><b>Description:</b><p></p> Why class was created?
 * <p></p>
 * <b>Public Methods:</b><p></p> Only listing to public methods usage.
 */
public class NewsfeedPresenter implements Presenter, InteractorOut {

    private View view;
    private Interactor interactor;

    public NewsfeedPresenter(View view) {
        this.view = view;
        interactor=new NewsfeedInteractor(this);
    }

    @Override
    public void getNewsfeed(int userId) {
        interactor.fetchNewsfeed(userId);
    }

    @Override
    public void onSuccessNewsfeed(String[] newsfeed) {
        view.setData(newsfeed);
    }

    @Override
    public void onFailureNewsfeed(String message) {
        view.showError(message);
    }
}
