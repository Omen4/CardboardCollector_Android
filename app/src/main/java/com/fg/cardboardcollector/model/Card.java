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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Nullable
    public Integer getAtk() {
        return atk;
    }

    public void setAtk(@Nullable Integer atk) {
        this.atk = atk;
    }

    @Nullable
    public Integer getDef() {
        return def;
    }

    public void setDef(@Nullable Integer def) {
        this.def = def;
    }

    @Nullable
    public Integer getLevel() {
        return level;
    }

    public void setLevel(@Nullable Integer level) {
        this.level = level;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    @Nullable
    public String getAttribute() {
        return attribute;
    }

    public void setAttribute(@Nullable String attribute) {
        this.attribute = attribute;
    }

    @Nullable
    public String getArchetype() {
        return archetype;
    }

    public void setArchetype(@Nullable String archetype) {
        this.archetype = archetype;
    }

    public int getScale() {
        return scale;
    }

    public void setScale(int scale) {
        this.scale = scale;
    }

    public int getLinkval() {
        return linkval;
    }

    public void setLinkval(int linkval) {
        this.linkval = linkval;
    }

    @Nullable
    public String getLinkmarkers() {
        return linkmarkers;
    }

    public void setLinkmarkers(@Nullable String linkmarkers) {
        this.linkmarkers = linkmarkers;
    }

    public String getSet_name() {
        return set_name;
    }

    public void setSet_name(String set_name) {
        this.set_name = set_name;
    }

    public String getSet_code() {
        return set_code;
    }

    public void setSet_code(String set_code) {
        this.set_code = set_code;
    }

    public String getSet_rarity() {
        return set_rarity;
    }

    public void setSet_rarity(String set_rarity) {
        this.set_rarity = set_rarity;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }
}
