package com.example.mvp_practice02.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by Talha Hasan Zia on 14-Mar-18.
 * <p></p><b>Description:</b><p></p> Why class was created?
 * <p></p>
 * <b>Public Methods:</b><p></p> Only listing to public methods usage.
 */
@RunWith(MockitoJUnitRunner.class)
public class ServiceTest {


/*    Since mockito cannot infer if the instances used in a mocked class must be mocked or not,
      we must adapt a way of writing both the code and tests that allows us to make testing possible.

      For this we have written 2 test showing that at what level which class should be mocked.*/

    @Test
    public void doLocalBusiness() throws Exception {
        // do local business test needs only service method to be mocked
        Service service=mock(Service.class);

        // mock behaviour
        when(service.doLocalBusiness()).thenReturn("Done with pipeline");

        // Test behaviour
        assertNotNull(service.doLocalBusiness());
    }


    // Now the main class (Service) doesnt need to be mocked since method we are testing has concrete implementation
    // from Worker class, mocking service class will not give us desired behaviour, so we mock underlying class instance.

    @Test
    public void doExecutiveBusiness()  throws Exception
    {
        // Normal initialization
        Service service=new Service();

        // Mock initialization
        Worker worker=mock(Worker.class);
        when(worker.sendResult()).thenReturn("Done with construction");
        service.setWorker(worker);

        // Test the call
        assertNotNull(service.doExecutiveBusiness());
    }


    @Test
    public void failExecutiveBusiness()  throws Exception
    {
        // Mock initialization to make test fail
        Service service=mock(Service.class);

        // Mock initialization
        Worker worker=mock(Worker.class);
        when(worker.sendResult()).thenReturn("Done with construction");
        service.setWorker(worker);

        // Test the call
        assertNull(service.doExecutiveBusiness());
    }



    @Test
    public void failLocalBusiness() throws Exception {
        // do local business test needs only service method to be mocked
        // but here we disabled mocking so we check the test should fail.

        Service service=new Service();

        // Test behaviour
        assertNull(service.doLocalBusiness());
    }


}