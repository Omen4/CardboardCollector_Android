package com.fg.cardboardcollector.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.fg.cardboardcollector.R;

public class CentralActivity extends AppCompatActivity {

    private static String JSON_URL = "https://db.ygoprodeck.com/api/v7/cardinfo.php?archetype=Noble%20Knight";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_central);
    }

    private void init(){

    }
}