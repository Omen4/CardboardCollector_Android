package com.fg.cardboardcollector.model;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class Role implements Serializable {
    private Integer id;
    private String denomination;

    public Role (){}

    public Role(Integer id, String nom) {
        this.id = id;
        this.denomination = nom;
    }

    public static Role fromJson(JSONObject jsonRole) throws JSONException {
        return new Role(
                jsonRole.getInt("id"),
                jsonRole.getString("denomination")
        );
    }
}
