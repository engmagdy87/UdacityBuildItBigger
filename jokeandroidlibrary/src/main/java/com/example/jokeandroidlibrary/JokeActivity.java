package com.example.jokeandroidlibrary;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class JokeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);

        TextView jokeTextView = findViewById(R.id.tv_joke);

        String jokeBody;

        Intent intent = getIntent();
        jokeBody = intent.getStringExtra("joke");

        jokeTextView.setText(jokeBody);
    }
}
