package com.fg.cardboardcollector.model;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.AbstractSequentialList;
import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Utilisateur implements Serializable {

    private int id;
    private String pseudo;
    private String password;
    private List<Collection> listeCollection = new ArrayList<>();
    private List<Role> listeRole = new ArrayList<>();

    public Utilisateur(int id, String pseudo) {
        this.id = id;
        this.pseudo = pseudo;
    }


    public static Utilisateur fromJson(JSONObject jsonUtilisateur) throws JSONException {

        System.out.println(jsonUtilisateur);

        Utilisateur utilisateur = new Utilisateur(
                jsonUtilisateur.getInt("id"),
                jsonUtilisateur.getString("pseudo")
        );

        JSONArray jsonListeRole = jsonUtilisateur.getJSONArray("listeRole");
        for(int i = 0; i < jsonListeRole.length(); i++) {
            JSONObject jsonRole = jsonListeRole.getJSONObject(i);
            Role role = new Role();
            role = Role.fromJson(jsonRole);
            utilisateur.getListeRole().add(role);
        }

        JSONArray jsonListCollection = jsonUtilisateur.getJSONArray("listeCollection");
        for(int i = 0; i< jsonListCollection.length(); i++) {
            JSONObject jsonCollection = jsonListCollection.getJSONObject(i);
            utilisateur.getListeCollection().add(new Collection(jsonCollection));
        }

        //Retourner l'utilisateur
        return utilisateur;
    }
}
