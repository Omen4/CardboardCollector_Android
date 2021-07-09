package com.fg.cardboardcollector.model;

import androidx.annotation.Nullable;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class Card implements Serializable {

    private Integer id;
    private String cardName;
    private String type;
    private String desc;
    @Nullable
    private Integer atk;
    @Nullable
    private Integer def;
    @Nullable
    private Integer level;
    private String race;
    @Nullable
    private String attribute;
    @Nullable
    private String archetype;
    @Nullable
    private int scale;
    @Nullable
    private int linkval;
    @Nullable
    private String linkmarkers;
    private String set_name;
    private String set_code;
    private String set_rarity;
    private String image_url;


    public Card(){}

    public Card(Integer id, String cardName, String type, String desc, @Nullable Integer atk, @Nullable Integer def, @Nullable Integer level, String race, @Nullable String attribute, @Nullable String archetype, int scale, int linkval, @Nullable String linkmarkers, String set_name, String set_code, String set_rarity, String image_url) {
        this.id = id;
        this.cardName = cardName;
        this.type = type;
        this.desc = desc;
        this.atk = atk;
        this.def = def;
        this.level = level;
        this.race = race;
        this.attribute = attribute;
        this.archetype = archetype;
        this.scale = scale;
        this.linkval = linkval;
        this.linkmarkers = linkmarkers;
        this.set_name = set_name;
        this.set_code = set_code;
        this.set_rarity = set_rarity;
        this.image_url = image_url;
    }

    public static Card FromJson(JSONObject jsonCard) throws JSONException{
        return  new Card(
        jsonCard.getInt("cardid"),
        jsonCard.getString("cardname"),
        jsonCard.getString("type"),
        jsonCard.getString("desc"),
        jsonCard.getInt("atk"),
        jsonCard.getInt("def"),
        jsonCard.getInt("level"),
        jsonCard.getString("race"),
        jsonCard.getString("attribute"),
        jsonCard.getString("archetype"),
        jsonCard.getInt("scale"),
        jsonCard.getInt("linkval"),
        jsonCard.getString("linkmarkers"),
        jsonCard.getString("set_name"),
        jsonCard.getString("set_code"),
        jsonCard.getString("set_rarity"),
        jsonCard.getString("image_url")
        );
    }

}
