package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.udacity.gradle.jokeprovider.JokeProvider;
import com.udacity.gradle.jokeviewer.JokeViewerActivity;

/**
 * The main activity for the Build It Bigger app.
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * Handle the clicking of the "Tell Joke" button, by retrieving the joke
     * and displaying it.
     * @param view the button that was clicked
     */
    public void tellJoke(View view) {
        // get the joke from the joke provider
        String joke = (new JokeProvider()).getJoke();
        // display the joke
        displayJoke(joke);
    }

    /**
     * Display a joke by passing it to the joke viewer activity.
     * @param joke the joke to display
     */
    private void displayJoke(String joke) {
        Intent intent = new Intent(this, JokeViewerActivity.class);
        intent.putExtra(JokeViewerActivity.KEY_JOKE, joke);
        startActivity(intent);
    }

}
