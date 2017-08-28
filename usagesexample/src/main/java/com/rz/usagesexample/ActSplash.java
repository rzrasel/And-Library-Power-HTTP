package com.rz.usagesexample;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.rz.logger.LogWriter;
import com.rz.powerhttp.HTTPMethod;
import com.rz.powerhttp.OnFeedHTTPEventListenerHandler;
import com.rz.powerhttp.PowerFeedHTTPAsyncTask;
import com.rz.powerhttp.PowerHTTPConnection;

import java.util.HashMap;

public class ActSplash extends AppCompatActivity {
    private PowerHTTPConnection powerHTTPConnection;
    private PowerFeedHTTPAsyncTask powerFeedHTTPAsyncTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_splash);
        //powerHTTPConnection = new PowerHTTPConnection();
        /**/
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                //new FeedAsyncTask().execute();
            }
        });
        //powerFeedHTTPAsyncTask = new PowerFeedHTTPAsyncTask();
        powerFeedHTTPAsyncTask = new PowerFeedHTTPAsyncTask(new OnFeedHTTPEventListenerHandler() {
            @Override
            public void onPreExecute() {
            }

            @Override
            public Object doInBackground(Object... argURLParams) {
                return "Hi I am returned";
            }

            @Override
            public void onPostExecute(Object argResult) {
                LogWriter.Log("onPostExecute" + argResult + "");
            }

            @Override
            public void onProgressUpdate(Integer... argProgressValue) {
            }

            @Override
            public void onCancelled() {
            }
        });
        /*powerFeedHTTPAsyncTask.onExecute(this, "http://www.prothom-alo.com/");*/
        HashMap<String, String> urlHeaders = new HashMap<String, String>();
        HashMap<String, String> urlRequestParameters = new HashMap<String, String>();
        urlHeaders.put("head1", "headeValue1");
        urlHeaders.put("head2", "headeValue2");
        urlRequestParameters.put("param1", "paramValue1");
        urlRequestParameters.put("param2", "paramValue2");
        powerFeedHTTPAsyncTask
                .setHTTPMethod(HTTPMethod.POST)
                .setUrlHeader(urlHeaders)
                .setURLParameters(urlRequestParameters)
                .onExecute(this, "http://jagoron24.com/");
    }

    public class FeedAsyncTask extends AsyncTask<Void, Void, Void> {
        @Override
        protected Void doInBackground(Void... argParams) {
            powerHTTPConnection
                    .onPrepareConnection("http://jagoron24.com/", HTTPMethod.GET, false)
                    .onRunConnection();
            return null;
        }
    }
}