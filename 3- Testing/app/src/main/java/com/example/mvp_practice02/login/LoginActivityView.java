package com.example.mvp_practice02.login;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mvp_practice02.R;
import com.example.mvp_practice02.root.App;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivityView extends AppCompatActivity implements LoginActivityMVP.View
{

    @Inject LoginActivityMVP.Presenter presenter;

    @BindView(R.id.fname) EditText firstNameText;
    @BindView(R.id.lname) EditText lastNameText;
    @BindView(R.id.login) Button loginButton;



    @Override
    protected void onCreate( Bundle savedInstanceState )
    {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );


        ButterKnife.bind( this );

        App app = ((App)getApplication());

        app.get().inject( this );




        loginButton.setOnClickListener( new View.OnClickListener()
        {
            @Override public void onClick( View view )
            {
                presenter.loginButtonClicked();
            }
        } );


    }

    @Override protected void onResume()
    {
        super.onResume();

        presenter.setView( this );


        presenter.getCurrentUser();
    }

    @Override public String getFirstName()
    {
        return firstNameText.getText().toString();
    }

    @Override public void setFirstName( String fname )
    {

        firstNameText.setText( fname );

    }

    @Override public String getLastName()
    {
        return lastNameText.getText().toString();
    }

    @Override public void setLastName( String lname )
    {

        lastNameText.setText( lname );

    }

    @Override public void showUserNotAvailable()
    {

        Toast.makeText( this, "User does not exists.", Toast.LENGTH_LONG ).show();

    }

    @Override public void showInputError()
    {

        Toast.makeText( this, "Error processing input.", Toast.LENGTH_LONG ).show();

    }

    @Override public void showUserSaved()
    {

        Toast.makeText( this, "User saved successfully.", Toast.LENGTH_LONG ).show();

    }
}
