package com.chimemoo.onboardapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link OnboardSecondFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class OnboardSecondFragment extends Fragment {

    public OnboardSecondFragment() {
        // Required empty public constructor
    }

    public static OnboardSecondFragment newInstance() {
        OnboardSecondFragment fragment = new OnboardSecondFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_onboard_second, container, false);
    }
}