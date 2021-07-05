package com.fg.cardboardcollector;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button boutonTest;
    TextView textTest;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private void init(){
        this.boutonTest = findViewById(R.id.boutonTest);
        this.textTest=findViewById(R.id.textTest);

    }
}