package com.fg.cardboardcollector.controller;


import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.toolbox.StringRequest;
import com.fg.cardboardcollector.R;
import com.fg.cardboardcollector.model.Utilisateur;

import org.json.JSONException;
import org.json.JSONObject;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConnexionController {

    private static ConnexionController instance = null;
    Map<Integer, Utilisateur> mapUtilisateur = new HashMap<>();

    private ConnexionController() {
        super();
    }

    public static ConnexionController getInstance() {
        if(instance == null) {
            instance = new ConnexionController();
        }

        return instance;
    }

    public interface TelechargementListeUtilisateurListener {
        void onListeUtilisateurEstTelecharge(List<Utilisateur> listeUtilisateur);
    }

    public interface UtilisateurConnecteSuccessListener {
        void onUtilisateurConnecteSucces();
    }

    public interface UtilisateurConnecteErrorListener {
        void onUtilisateurConnecteError(String messageErreur);
    }

    public interface SuccesEcouteur {
        void onSuccesConnexion();
    }

    public interface ErreurEcouteur {
        void onErreurConnexion(String messageErreur);
    }

    public void connexion(
            Context context,
            String pseudo,
            String password,
            SuccesEcouteur ecouteurSucces,
            ErreurEcouteur ecouteurErreur
    ){
        StringRequest stringRequest = new StringRequest

                (Request.Method.POST,  context.getResources().getString(R.string.server_ip)+ "authentification" ,
                        token -> {
                            SharedPreferences preference = context.getSharedPreferences(
                                    context.getResources().getString(R.string.fichier_preference), 0); // 0 - for private mode
                            SharedPreferences.Editor editor = preference.edit();
                            editor.putString("token", token); // Storing string
                            editor.apply();

                            ecouteurSucces.onSuccesConnexion();
                        },
                        error -> {
                            ecouteurErreur.onErreurConnexion("Impossible de se connecter");
                        }
                ){

            @Override
            public Map<String, String> getHeaders() {

                Map<String, String> params = new HashMap<>();
                params.put("Content-Type", "application/json; charset=UTF-8");
                return params;
            }

            @Override
            public byte[] getBody() throws AuthFailureError {
                try {
                    JSONObject jsonBody = new JSONObject();
                    jsonBody.put("pseudo", pseudo);
                    jsonBody.put("password", password);

                    return jsonBody.toString().getBytes(StandardCharsets.UTF_8);

                } catch (JSONException e) {
                    e.printStackTrace();
                }

                return null;
            }
        };

        RequestManager.getInstance(context).addToRequestQueue(stringRequest);

    }

    public void deconnexion(
            Context context,
            SuccesEcouteur ecouteurSucces
    ){
        SharedPreferences preference = context.getSharedPreferences(
                context.getResources().getString(R.string.fichier_preference), 0);
        SharedPreferences.Editor editor = preference.edit();
        editor.remove("token"); // Storing string
        editor.apply();
        ecouteurSucces.onSuccesConnexion();
    }
}
