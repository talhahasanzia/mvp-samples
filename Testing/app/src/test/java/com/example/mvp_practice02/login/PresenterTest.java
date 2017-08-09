package com.example.mvp_practice02.login;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by tzia on 22-May-17.
 */


public class PresenterTest
{


    // Notice class types
    LoginActivityMVP.Model mockModel; // Abstract implementation
    LoginActivityMVP.View mockView;     // Abstract implementation
    LoginActivityPresenter presenter;  // Concrete implementation

    User user;  // Concrete Implementation


    // This will run before each test, for eg if we have 4 test method
    // it will run 4 times before each of the test.
    @Before
    public void setup()
    {

        mockModel = mock( LoginActivityMVP.Model.class );

        user = new User( "Thomas", "Hardy" );

        // when a call is made to getUser() of mockModel, return the "user" instance
        // defined above. Hence we are mocking return object or say we are mocking getUser()
        // method of mockModel class.
        when( mockModel.getUser() ).thenReturn( user );  // this statement is making user not null comment it to make user null

        // Mock view also
        mockView = mock( LoginActivityMVP.View.class );


        // Dont mock this, we need concrete implementation of presenter
        // We are trying to test real implementation of this class
        presenter = new LoginActivityPresenter( mockModel );


        // use mocked view in
        presenter.setView( mockView );

    }


    // Test #1: getCurrentUser() results in no view interactions
    @Test
    public void noInteractionWithView()
    {

        // check that no interactions are performed in the view
        // by performing this operation


        presenter.getCurrentUser();


        // see presenter implementation of getCurrentUser()
        // getCurrentUser() will have a user value != null and it will
        // interact with view since there condition is met
        // So test will fail because we want to test if there are zero interactions,
        // by making our user not null via mockModel.
        verify( mockView, times( 1 ) );  // verify that above call of getCurrentUser() results in 1 view interactions


    }


    // Test #2: Check if(user!=null) part of getCurrentUser()
    @Test
    public void loadUserWhenPresent()
    {


        // set mock behavior
        when( mockModel.getUser() ).thenReturn( user );


        presenter.getCurrentUser();  // this gets user from model and sets in views.

        // this checks if a method is called with required arguments or not
        // times parameter here asks how many times we want to invoke.
        verify( mockModel, times( 1 ) ).getUser();   // change to  times(2) and test will fail, because it will check to verify
        // this method will be called 2 times, and it did not in our current test case
        // scenario.


        // Although we are using framework elements, we are not depending on
        // android framework completely, instead we are "mocking" views in our case.
        // perform verification on view interactions.

        verify( mockView, times( 1 ) ).setFirstName( "Thomas" );          // verify that setFirstName( String ) is called once, and value is "Thomas"
        verify( mockView, times( 1 ) ).setLastName( "Hardy" );           // verify that setLastName( String ) is called once, and value is "Hardy"

        verify( mockView, never() ).showUserNotAvailable();         // Verify that showUserNotAvailable is never called,
        // since we have already provided user in above when() call.
        // In our case, this should never be called, because user is
        //  always available so if we change never() to times(1) or
        // times(N) we get test fail.


    }


    // Test #3: Check "else" part of getCurrentUser()
    @Test
    public void shouldShowErrorMessageOnUserNull()
    {
        // set mock behavior
        when( mockModel.getUser() ).thenReturn( null );  // now we deliberately set user to null


        presenter.getCurrentUser();  // this gets user from model and sets in views.

        // this checks if a method is called with required arguments or not
        // times parameter here asks how many times we want to invoke.
        verify( mockModel, times( 1 ) ).getUser();   // change to  times(2) and test will fail, because it will check to verify
        // this method will be called 2 times, and it did not in our current test case
        // scenario.


        // Although we are using framework elements, we are not depending on
        // android framework completely, instead we are "mocking" views in our case.
        // perform verification on view interactions.

        verify( mockView, never() ).setFirstName( "Thomas" );          // verify that setFirstName( String ) is never called
        verify( mockView, never() ).setLastName( "Hardy" );           // verify that setLastName( String ) is never  called

        verify( mockView, times( 1 ) ).showUserNotAvailable();         // Verify that showUserNotAvailable is  called,
        // since we have set  user as "null" in above when() call.
        // In our case, this should be called only once, because user is
        //  always null so if we change times(1) to never() we get test fail.


    }


    //Test #4: Show error message when fields are empty
    @Test
    public void shouldShowErrorMessageWhenFieldsAreEmpty()
    {
        // set mock view and its string to empty string
        when( mockView.getFirstName() ).thenReturn( "" );  // now we deliberately set user to empty string

        // lastName is not called and is null


        presenter.saveUser();

        // this checks if a method is called with required arguments or not
        // times parameter here asks how many times we want to invoke.
        verify( mockView, times( 1 ) ).getFirstName();   // change to  times(2) and test will fail, because it will check to verify
        // this method will be called 2 times, and it did not in our current test case
        // scenario. It is just invoked once.


        verify( mockView, never() ).getLastName();  // is never called since we did not mocked it

        verify( mockView, times( 1 )).showInputError();  // should show error ONCE since we deliberately set empty string.


        // set mock behavior and its string to empty string
        when( mockView.getFirstName() ).thenReturn( "Dianna" );  // now we  set user to some valid string
        when( mockView.getLastName() ).thenReturn( "" ); // now we deliberately set lastname to empty string
        // lastName is not called and is null



        // MOCKITO KEEPS COUNT OF INVOCATION INTERNALLY


        presenter.saveUser();

        // this checks if a method is called with required arguments or not
        // times parameter here asks how many times we want to invoke.
        verify( mockView, times( 2 ) ).getFirstName();   // called 2 times once before once now


        verify( mockView, times( 1 ) ).getLastName();  // is  called ONCE

        verify( mockView, times( 2 )).showInputError();  // called 2 times
                                                        // should show error since we deliberately set empty string in lastName.



    }


    // Test #5: Save a valid user case
    @Test
    public void shouldSaveValidUser()
    {
        when(mockView.getFirstName()).thenReturn("Bruce");
        when(mockView.getLastName()).thenReturn("Wayne");

        presenter.saveUser();

        // Called two more times in the saveUser call.
        verify(mockView, times(2)).getFirstName();
        verify(mockView, times(2)).getLastName();

        // Make sure the repository saved the user
        verify(mockModel, times(1)).createUser("Bruce", "Wayne");

        // Make sure that the view showed the user saved message
        verify(mockView, times(1)).showUserSaved();

    }

}
