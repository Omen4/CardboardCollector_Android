package com.fg.cardboardcollector.model;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class Utilisateur {

    private int id;
    private String pseudo;
    private List<Collection> listCollection = new ArrayList<>();

    public Utilisateur(JSONObject jsonUtilisateur) throws JSONException {
        id = jsonUtilisateur.getInt("id");
        pseudo = jsonUtilisateur.getString("pseudo");

        JSONArray jsonListCollection = jsonUtilisateur.getJSONArray("listeCollection");

        for(int i = 0; i< jsonListCollection.length(); i++) {
            JSONObject jsonCollection = jsonListCollection.getJSONObject(i);
            listCollection.add(new Collection(jsonCollection));
        }
    }




}
