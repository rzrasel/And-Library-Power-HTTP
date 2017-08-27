package com.rz.usagesexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.rz.powerhttp.HTTPMethod;
import com.rz.powerhttp.PowerHTTPConnection;

public class ActSplash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_splash);
        PowerHTTPConnection powerHTTPConnection = new PowerHTTPConnection();
        powerHTTPConnection.onPrepareConnection("https://www.google.com/", HTTPMethod.GET, false);
    }
}
