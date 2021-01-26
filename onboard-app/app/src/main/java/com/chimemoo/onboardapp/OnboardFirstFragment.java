package com.chimemoo.onboardapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link OnboardFirstFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class OnboardFirstFragment extends Fragment {

    public OnboardFirstFragment() {
        // Required empty public constructor
    }

    public static OnboardFirstFragment newInstance() {
        OnboardFirstFragment fragment = new OnboardFirstFragment();
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
        return inflater.inflate(R.layout.fragment_onboard_first, container, false);
    }
}