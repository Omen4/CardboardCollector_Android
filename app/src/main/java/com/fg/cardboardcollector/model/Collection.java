package com.fg.cardboardcollector.model;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Collection implements Serializable {

    private Integer id;
    private String ccgName;
    private List<Card> listCard = new ArrayList<>();

    public Collection(){}

    public Collection(JSONObject jsonCollection) throws JSONException {
        id = jsonCollection.getInt("id");
        ccgName = jsonCollection.getString("ccgname");

        JSONArray jsonListCard = jsonCollection.getJSONArray("listCard");

        for(int i = 0; i< jsonListCard.length(); i++) {
            JSONObject jsonCard = jsonListCard.getJSONObject(i);
            listCard.add(new Card(jsonCard));
        }
    }
}
