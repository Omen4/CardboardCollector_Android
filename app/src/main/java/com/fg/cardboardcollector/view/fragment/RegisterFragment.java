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


public class RegisterFragment extends Fragment {

    public RegisterFragment(){}

    TextView textViewRegisterLogin;
    TextView textViewRegisterPassword;
    TextView textViewReRegisterPassword;
    Button boutonRegister;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_register, container, false);

        textViewRegisterLogin = view.findViewById(R.id.et_login);
        textViewRegisterPassword = view.findViewById(R.id.et_registerpassword);
        textViewReRegisterPassword = view.findViewById(R.id.et_registerrepassword);
        boutonRegister = view.findViewById(R.id.btn_register);

        boutonRegister.setOnClickListener((View v) -> {
            if(textViewRegisterPassword == textViewReRegisterPassword){
                ConnexionController.getInstance().connexion(
                        getContext(),
                        textViewRegisterLogin.getText().toString(),
                        textViewRegisterPassword.getText().toString(),
                        () -> startActivity(new Intent(getContext(), CentralActivity.class)),
                        (String messageErreur) -> Toast.makeText(getContext(), messageErreur, Toast.LENGTH_LONG).show()
                );
            }
        });

        return view;
    }

}