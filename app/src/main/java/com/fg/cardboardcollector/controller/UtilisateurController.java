package com.fg.cardboardcollector.controller;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.fg.cardboardcollector.R;
import com.fg.cardboardcollector.model.Utilisateur;
import com.fg.cardboardcollector.utils.JsonObjectRequestWithToken;

import org.json.JSONException;

import java.io.FileOutputStream;


public class UtilisateurController {

    private static UtilisateurController instance = null;

    private UtilisateurController() {
    }

    public static UtilisateurController getInstance() {

        if (instance == null) {
            instance = new UtilisateurController();
        }

        return instance;
    }

    public interface TelechargementUtilisateurListener {
        void onUtilisateurEstTelecharge(Utilisateur utilisateur);
    }

    public void getUtilisateurConnecte(Context context, TelechargementUtilisateurListener evenement) {

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequestWithToken(
                context,
                Request.Method.GET,
                context.getResources().getString(R.string.server_ip) + "user/utilisateur-connecte",
                null,
                jsonUtilisateur -> {

                    try {
                        Utilisateur utilisateur = Utilisateur.fromJson(jsonUtilisateur);
                        evenement.onUtilisateurEstTelecharge(utilisateur);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                },
                error -> Log.d("Erreur", error.toString())) {
        };

        RequestManager.getInstance(context).addToRequestQueue(jsonObjectRequest);
    }
}

