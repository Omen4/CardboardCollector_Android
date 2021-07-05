package com.fg.cardboardcollector.controller;


import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class ConnexionController {

    private static ConnexionController instance = null;
    private ConnexionController(){}

    //Connexion Singleton
    public static ConnexionController getInstance(){
        if(instance == null){
            instance = new ConnexionController();
        }
        return instance;
    }

    public interface SuccessLoginListener{
        void onSuccessLoginListener();
    }

    public void connexion(Context context, String pseudo, String password, SuccessLoginListener listener){

        StringRequest stringRequest = new StringRequest(
                Request.Method.POST,
                "http://10.0.2.2:8080/"+"authentification",
                token ->{
                    SharedPreferences sharedPreferences = context.getSharedPreferences("MesPreferences", Context.MODE_PRIVATE);

                },
                erreur ->{
                    Toast.makeText(context,"Erreur de connexion",Toast.LENGTH_LONG).show();

                }
        ){
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("Content-Type","applications/json; charset=UTF-8");
                return params;
            }

            @Override
            public byte[] getBody() throws AuthFailureError{
                try {
                    JSONObject jsonUtilisateur = new JSONObject();
                    jsonUtilisateur.put("pseudo", pseudo);
                    jsonUtilisateur.put("password", password);
                    return jsonUtilisateur.toString().getBytes(StandardCharsets.UTF_8);
                }catch (JSONException jsonException){
                    jsonException.printStackTrace();
                }
                return null;
            }
        };
//        TODO RequestManager.get pour associer à la request queue
    }
}
