package com.fg.cardboardcollector.controller;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.fg.cardboardcollector.model.Utilisateur;
import com.fg.cardboardcollector.utils.JsonObjectRequestWithToken;

import org.json.JSONException;

public class UtilisateurController {

    private static UtilisateurController instance = null;

    private  UtilisateurController(){}

    //User singleton
    public static UtilisateurController getInstance(){
        if(instance == null){
            instance = new UtilisateurController();
        }
        return instance;
    }

    public interface UtilisateurConnecteListener{
        void onUtilisateurConnecteListener(Utilisateur utilisateur);
    }

    public void getInformationUtilisateurConnecte(Context context, UtilisateurConnecteListener listener){
        JsonObjectRequestWithToken request = new JsonObjectRequestWithToken(
                context,
                Request.Method.GET,
                "http://10.0.2.2:8080/" + "user/utilisateur-connecte",
                null,
                jsonUtilisateur -> {
                    try {
                        Utilisateur utilisateur  = new Utilisateur(jsonUtilisateur);
                        listener.onUtilisateurConnecteListener(utilisateur);
                        System.out.println(utilisateur);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                },
                erreur -> Log.d("MonMessage","pas ok" )
        );

        RequestManager.getInstance(context).addToRequestQueue(request);
    }
}
