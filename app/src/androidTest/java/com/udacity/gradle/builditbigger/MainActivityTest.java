package com.udacity.gradle.builditbigger;

import android.support.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.isEmptyString;
import static org.hamcrest.Matchers.not;

/**
 * Android test class for MainActivity.
 */
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(
            MainActivity.class);

    @Test
    public void testThatClickingButtonDisplaysNonEmptyJoke() throws Exception {

        // Check that the 'Tell Joke' button is displayed
        onView(withId(R.id.btn_tell_joke))
                .check(matches(isDisplayed()));

        // Click on the button
        onView(withId(R.id.btn_tell_joke))
                .perform(click());

        // Check that the TextView containing the joke is displayed.
        onView(withId(R.id.txt_joke))
                .check(matches(isDisplayed()));

        // Check that the joke has a non-zero length.
        // Note: TextView text value is never null.
        onView(withId(R.id.txt_joke))
                .check(matches(withText(not(isEmptyString()))));

        // Check that the app was able to connect to the backend.
        // Assumption: there is no joke that contains the words "failed to connect".
        onView(withId(R.id.txt_joke))
                .check(matches(withText(not(containsString("failed to connect")))));

    }

}