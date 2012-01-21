package com.bdenney.sotab;

import android.app.Activity;
import android.os.Bundle;

/**
 * Landing page for the application.
 * @author Brandon
 */
public class Dashboard extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
}