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


    public Card(){super();}

    public Card(JSONObject jsonCard) throws JSONException{
        id = jsonCard.getInt("cardid");
        cardName = jsonCard.getString("cardname");
        type = jsonCard.getString("type");
        desc = jsonCard.getString("desc");
        atk = jsonCard.getInt("atk");
        def = jsonCard.getInt("def");
        level = jsonCard.getInt("level");
        race = jsonCard.getString("race");
        attribute = jsonCard.getString("attribute");
        archetype = jsonCard.getString("archetype");
        scale = jsonCard.getInt("scale");
        linkval = jsonCard.getInt("linkval");
        linkmarkers = jsonCard.getString("linkmarkers");
        set_name = jsonCard.getString("set_name");
        set_code = jsonCard.getString("set_code");
        set_rarity = jsonCard.getString("set_rarity");
        image_url = jsonCard.getString("image_url");
    }

}
