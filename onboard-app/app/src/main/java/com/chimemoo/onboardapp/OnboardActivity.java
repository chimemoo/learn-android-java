package com.chimemoo.onboardapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.graphics.Color;
import android.os.Bundle;

import com.github.appintro.AppIntro;

public class OnboardActivity extends AppIntro {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        addSlide(OnboardFirstFragment.newInstance());
        addSlide(OnboardSecondFragment.newInstance());
        addSlide(OnboardThirdFragment.newInstance());

        // Warna Next Arrow
        setNextArrowColor(Color.parseColor("#EC7495"));

        // Warna Button Skip
        setColorSkipButton(Color.BLACK);

        // Warna Button Done
        setColorDoneText(Color.BLACK);

        // Warna Background Bar
        setBarColor(Color.WHITE);

        // Warna Indicator (Selected, Unselected)
        setIndicatorColor(Color.parseColor("#EC7495"), Color.parseColor("#C3B5B5"));

        setSeparatorColor(Color.WHITE);

    }

    @Override
    protected void onSkipPressed(Fragment currentFragment) {
        super.onSkipPressed(currentFragment);
        finish();
    }

    @Override
    protected void onDonePressed(Fragment currentFragment) {
        super.onDonePressed(currentFragment);
        finish();
    }
}