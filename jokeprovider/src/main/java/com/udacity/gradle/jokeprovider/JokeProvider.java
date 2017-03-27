package com.udacity.gradle.jokeprovider;

/**
 * Class which provides jokes.
 */
public class JokeProvider {

    private static final String DEFAULT_JOKE =
            "Waiter, this coffee tastes like mud!\n\nIndeed sir, it was ground this morning!";

    /**
     * Returns a joke.
     * @return a joke
     */
    public String getJoke() {
        return DEFAULT_JOKE;
    }

}
