package com.example.mvp_practice02.powermock;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.times;
import static org.powermock.api.mockito.PowerMockito.mock;
import static org.powermock.api.mockito.PowerMockito.mockStatic;
import static org.powermock.api.mockito.PowerMockito.spy;
import static org.powermock.api.mockito.PowerMockito.verifyPrivate;
import static org.powermock.api.mockito.PowerMockito.verifyStatic;


/**
 * Created by Talha Hasan Zia on 19-Mar-18.
 * <p></p><b>Description:</b><p></p> Why class was created?
 * <p></p>
 * <b>Public Methods:</b><p></p> Only listing to public methods usage.
 */


@RunWith(PowerMockRunner.class)
@PrepareForTest({Sample.class, Helper.class})
public class SampleTest {


    private Sample sample;

    @Before
    public void setUp() {
        sample = mock(Sample.class);
    }

    @Test
    public void testLevel0() throws Exception {

        sample.setLevel(0);

        sample.showData();

        Mockito.verify(sample, times(1)).showData();

    }


    @Test
    public void testLevel1() throws Exception {

        Sample sample = spy(new Sample());

        sample.setLevel(1);

        sample.showData();

        Mockito.verify(sample, times(1)).showData();

        verifyPrivate(sample, times(1)).invoke("trashTalk", anyInt());

    }


    @Test
    public void testStaticMethod() {
        String mockVoid="Some other type";
        String mockType0="Dont Get Back!";
        String mockTypeAny="Some other type";

        mockStatic(Helper.class);

        // mock methods
        given(Helper.help()).willReturn(mockVoid);
        given(Helper.help(anyInt())).willReturn(mockTypeAny);
        given(Helper.help(0)).willReturn(mockType0);



        // assert
        assertEquals(mockVoid, Helper.help());
        assertEquals(mockTypeAny, Helper.help(2));
        assertEquals(mockType0, Helper.help(0));

        assertNotEquals(mockVoid, Helper.help(0));


        // verify calls
        verifyStatic();
    }


}
