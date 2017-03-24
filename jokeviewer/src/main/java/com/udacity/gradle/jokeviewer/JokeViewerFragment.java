package com.udacity.gradle.jokeviewer;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import static com.udacity.gradle.jokeviewer.R.id.txtJoke;


/**
 * Fragment which displays a joke.
 */
public class JokeViewerFragment extends Fragment {

    // The field which displays the joke.
    private TextView mTxtJoke;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_joke_viewer, container, false);

        // Initialise the fragment view references.
        mTxtJoke = (TextView) view.findViewById(txtJoke);

        return view;
    }

    /**
     * Called when the fragment is visible to the user and actively running.
     * This is generally tied to {@link Activity#onResume() Activity.onResume}
     * of the containing Activity's lifecycle.
     */
    @Override
    public void onResume() {
        super.onResume();

        // display the current joke in the fragment
        mTxtJoke.setText(getJoke());
    }

    /**
     * Return the current joke, as stored in the activity.
     * @return the current joke.
     */
    private String getJoke() {
        Activity activity = getActivity();
        if (activity != null && activity instanceof JokeViewerActivity) {
            return ((JokeViewerActivity) activity).getJoke();
        }
        return null;
    }

}
