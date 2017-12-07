package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.jokeandroidlibrary.JokeActivity;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {
    public String loadedJoke = null;
    Button jokeBtn;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);
        jokeBtn = root.findViewById(R.id.btn_joke);
        jokeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getJoke();
            }
        });

        return root;
    }

    public void getJoke() {
        new EndpointsAsyncTask().execute(this);
    }

    public void showJokeActivity() {
        Context context = getActivity();
        Intent intent = new Intent(context, JokeActivity.class);
        intent.putExtra("joke", loadedJoke);
        context.startActivity(intent);
    }
}
