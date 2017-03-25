package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.util.Pair;
import android.os.AsyncTask;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;

import com.udacity.gradle.builditbigger.backend.myApi.MyApi;
import com.udacity.gradle.jokeviewer.JokeViewerActivity;

import java.io.IOException;

/**
 * Background task which retrieves and returns a joke from the backend.
 */
class EndpointsAsyncTask extends AsyncTask<Pair<Context, String>, Void, String> {
    private static MyApi myApiService = null;
    private Context context;

    @Override
    protected String doInBackground(Pair<Context, String>... params) {
        if(myApiService == null) {  // Only do this once
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    // options for running against local devappserver
                    // - 10.0.2.2 is localhost's IP address in Android emulator
                    // - turn off compression when running against local devappserver
                    //TODO: test on emulator!
                    //.setRootUrl("http://10.0.2.2:8080/_ah/api/")
                    .setRootUrl("http://192.168.123.16:8080/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    });
            // end options for devappserver

            myApiService = builder.build();
        }

        context = params[0].first;
        String name = params[0].second;

        try {
            //return myApiService.sayHi(name).execute().getData();
            return myApiService.joke().execute().getData();
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String result) {
        displayJoke(context, result);
    }

    /**
     * Display a joke by passing it to the joke viewer activity.
     * @param context the current context
     * @param joke the joke to display
     */
    private void displayJoke(Context context, String joke) {
        if (context != null && joke != null && !joke.isEmpty()) {
            //Toast.makeText(context, result, Toast.LENGTH_LONG).show();
            Intent intent = new Intent(context, JokeViewerActivity.class);
            intent.putExtra(JokeViewerActivity.KEY_JOKE, joke);
            context.startActivity(intent);
        }
    }

}