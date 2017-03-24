package com.udacity.gradle.jokeviewer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;


/**
 * Activity which displays a joke.
 * The activity is passed a joke, which it stores.
 * The activity layout contains a fragment which retrieves the joke from this activity.
 */
public class JokeViewerActivity extends AppCompatActivity {

    /** Key for the extra data field which contains the joke. */
    public static final String KEY_JOKE = "KEY_JOKE";

    private String mJoke;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke_viewer);

        // Save the joke which was passed in.
        Intent intent = getIntent();
        mJoke = intent.getStringExtra(KEY_JOKE);
    }

    /**
     * Return the current joke.
     * @return the current joke.
     */
    public String getJoke() {
        return mJoke;
    }

}
