package com.example.mvp_practice02.newsfeed.view;

import com.example.mvp_practice02.newsfeed.contracts.View;
import com.example.mvp_practice02.newsfeed.presenter.NewsfeedPresenter;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 * Created by Talha Hasan Zia on 30-Apr-18.
 * <p></p><b>Description:</b><p></p> Why class was created?
 * <p></p>
 * <b>Public Methods:</b><p></p> Only listing to public methods usage.
 */
public class NewsfeedTest {

    NewsfeedPresenter newsfeedPresenter;

    @Mock
    View view;


    @Before
    public void initMocks() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void setData() throws Exception {
        newsfeedPresenter = new NewsfeedPresenter(view);
        newsfeedPresenter.getNewsfeed(4980);

        verify(view, times(1)).setData(any(String[].class)); // test if view was interacted
    }

}