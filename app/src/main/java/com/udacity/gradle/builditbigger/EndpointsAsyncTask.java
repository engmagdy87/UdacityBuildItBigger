package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.os.AsyncTask;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.udacity.gradle.builditbigger.backend.myApi.MyApi;

import java.io.IOException;

;

/**
 * Created by MM on 12/4/2017.
 */

class EndpointsAsyncTask extends AsyncTask<MainActivityFragment, Void, String> {
    private static MyApi myApiService = null;
    private MainActivityFragment mainActivityFragment;
    private Context context;

    @Override
    protected String doInBackground(MainActivityFragment... params) {
        if (myApiService == null) {
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(), new
                    AndroidJsonFactory(), null)
                    .setRootUrl("https://jokesudacity-188021.appspot.com/_ah/api/");


            myApiService = builder.build();
        }

        mainActivityFragment = params[0];
        context = mainActivityFragment.getActivity();

        try {
            String result = myApiService.tellJoke().execute().getData();
            return result;
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String result) {
        mainActivityFragment.loadedJoke = result;
        mainActivityFragment.showJokeActivity();
    }
}