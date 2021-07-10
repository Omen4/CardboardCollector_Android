package com.fg.cardboardcollector.view.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.fg.cardboardcollector.R;
import com.fg.cardboardcollector.controller.ConnexionController;
import com.fg.cardboardcollector.view.CentralActivity;

public class LoginFragment extends Fragment {


    public LoginFragment(){}

    TextView textViewPseudo;
    TextView textViewPassword;
    Button boutonLogin;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_login, container, false);

        textViewPseudo = view.findViewById(R.id.et_pseudo);
        textViewPassword = view.findViewById(R.id.et_password);
        boutonLogin = view.findViewById(R.id.btn_login);

        boutonLogin.setOnClickListener((View v) -> {
            ConnexionController.getInstance().connexion(
                    getContext(),
                    textViewPseudo.getText().toString(),
                    textViewPassword.getText().toString(),
                    () -> startActivity(new Intent(getContext(), CentralActivity.class)),
                    (String messageErreur) -> Toast.makeText(getContext(), messageErreur, Toast.LENGTH_LONG).show()
            );
        });

        return view;
    }

}
