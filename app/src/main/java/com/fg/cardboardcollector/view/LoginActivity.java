package com.fg.cardboardcollector.view;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.fg.cardboardcollector.R;
import com.fg.cardboardcollector.controller.ConnexionController;
import com.fg.cardboardcollector.utils.JWTUtils;

public class LoginActivity extends AppCompatActivity {

    TextView textViewLogin;
    TextView textViewPassword;
    Button boutonConnexion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (JWTUtils.isTokenValide(this)) {
            startActivity(new Intent(this, CentralActivity.class));
        } else {

            setContentView(R.layout.activity_login);

            textViewLogin = findViewById(R.id.login);
            textViewPassword = findViewById(R.id.password);
            boutonConnexion = findViewById(R.id.button_connexion);

            boutonConnexion.setOnClickListener((View v) -> {
                ConnexionController.getInstance().connexion(
                        this,
                        textViewLogin.getText().toString(),
                        textViewPassword.getText().toString(),
                        () -> startActivity(new Intent(this, CentralActivity.class)),
                        (String messageErreur) -> Toast.makeText(this, messageErreur, Toast.LENGTH_LONG).show()
                );
            });

        }
    }
}
