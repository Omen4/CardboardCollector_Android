package com.fg.cardboardcollector.view.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.fg.cardboardcollector.R;
import com.fg.cardboardcollector.controller.ConnexionController;
import com.fg.cardboardcollector.view.CentralActivity;

public class CardDatabaseFragment extends Fragment {

    public CardDatabaseFragment(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_central_carddatabase, container, false);
        return view;
    }
}
