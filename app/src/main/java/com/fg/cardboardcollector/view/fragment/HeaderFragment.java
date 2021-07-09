package com.fg.cardboardcollector.view.fragment;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;

import com.fg.cardboardcollector.R;
import com.fg.cardboardcollector.controller.UtilisateurController;

public class HeaderFragment extends Fragment {

    public HeaderFragment(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_header, container, false);
        // souffler dans le ballon
        return view;
    }
}
