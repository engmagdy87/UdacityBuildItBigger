package com.udacity.gradle.builditbigger;

import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.ExecutionException;

/**
 * Created by MM on 12/6/2017.
 */
@RunWith(AndroidJUnit4.class)
public class EndpointsAsyncTaskTestUnit {
    @Test
    public void EndPointTest() throws ExecutionException, InterruptedException {
        EndpointsAsyncTaskTest endpointsAsyncTaskTest =  new EndpointsAsyncTaskTest();
        endpointsAsyncTaskTest.execute(InstrumentationRegistry.getContext());
        String joke = endpointsAsyncTaskTest.get();
        Assert.assertEquals(true,!joke.equals(""));
    }
}
