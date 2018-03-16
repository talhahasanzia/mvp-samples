package com.example.mvp_practice02.samples;

import android.util.Log;

import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.junit.Assert.assertEquals;

/**
 * Created by Talha Hasan Zia on 15-Mar-18.
 * <p></p><b>Description:</b><p></p> Why class was created?
 * <p></p>
 * <b>Public Methods:</b><p></p> Only listing to public methods usage.
 */

@RunWith(Enclosed.class)
public class ParametrizedTests {


    // these tests will not work with Enclosed.class, change to Parametrized.class to run these.
    @Parameter
    public int fInput;
    @Parameter(1)
    public int fExpected;

    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {0, 0}, {1, 1}, {2, 1}, {3, 2}, {4, 3}, {5, 5}
        });
    }

    @Test
    public void testFabonacci() {
        assertEquals(fExpected, Fibonacci.compute(fInput));
    }


    /**
     * Here we can only provide 1 set of parameters.
     * A workaround is Enclosing (inner) classes as discussed here.
     * https://stackoverflow.com/questions/14082004/create-multiple-parameter-sets-in-one-parameterized-class-junit
     */


    @RunWith(Parameterized.class)
    public static class ParametrizedNumbers {

        // here you can add any other test which is not parametrized

        @Parameter
        public int fInput;
        @Parameter(1)
        public int fExpected;

        @Parameters
        public static Collection<Object[]> data() {
            return Arrays.asList(new Object[][]{
                    {0, 0}, {1, 1}, {2, 1}, {3, 2}, {4, 3}, {5, 5}
            });
        }

        @Test
        public void testFabonacci() {
            assertEquals(fExpected, Fibonacci.compute(fInput));
        }
    }

    // Another enclosing class to cater different test with different set of parameters


    @RunWith(Parameterized.class)
    public static class ParametrizedStrings {

        // here you can add any other test which is not parametrized

        @Parameter
        public String stringA;
        @Parameter(1)
        public String stringB;

        @Parameters
        public static Collection<Object[]> data() {
            return Arrays.asList(new Object[][]{
                    {"WWW", "EMP"}, {"WWQ", "Tornado"}, {"EEW", "Chaos Meteor"}, {"QWE", "Defining Blast"},
                    {"QQQ", "Cold Snap"}, {"WWE", "Alacrity"}, {"EEE", "Sunstrike"}, {"QQE", "Ice Wall"},
                    {"EEQ", "Forge Spirit"}, {"QQW", "Ghost Walk"}
            });
        }

        @Test
        public void testStringLength() {
            int minLength = 6;
            String separator = " - ";
            StringBuilder combo = new StringBuilder(stringA);
            combo.append(separator);
            combo.append(stringB);
            System.out.println("testString: " + combo.toString());
            assertThat(combo.toString(), combo.toString().length(), greaterThan(minLength));
        }
    }


    // no annotation needed simple test
    public static class OtherNonParameterizedTests {

        // here you can add any other test which is not parameterized

        @Test
        public void otherTest() {
            // test something else
        }
    }

}
