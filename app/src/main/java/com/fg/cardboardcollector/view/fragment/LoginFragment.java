package com.fg.cardboardcollector.view.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fg.cardboardcollector.R;

public class LoginFragment extends Fragment {


    public LoginFragment(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // souffler dans le ballon
        return inflater.inflate(R.layout.fragment_login, container, false);
    }

}