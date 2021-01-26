package com.chimemoo.onboardapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        Thread t = new Thread(() -> {
            SharedPreferences getPrefs = PreferenceManager
                    .getDefaultSharedPreferences(getBaseContext());

            boolean isFirstStart = getPrefs.getBoolean("firstStart", true);

            if(isFirstStart){
                final Intent intent = new Intent(MainActivity.this, OnboardActivity.class);
                runOnUiThread(() -> startActivity(intent));

                SharedPreferences.Editor e = getPrefs.edit();
                e.putBoolean("firstStart", false);
                e.apply();
            }
        });

        t.start();

        setContentView(R.layout.activity_main);
    }
}