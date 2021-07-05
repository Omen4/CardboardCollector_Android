package com.fg.cardboardcollector.controller;

import android.content.Context;

import com.fg.cardboardcollector.model.Card;

import org.json.JSONException;
import org.json.JSONObject;

public final class CardController {

    private static CardController instance = null;

    private CardController(){}

    public static CardController getInstance(){
        if (instance == null){
            instance = new CardController();
        }
        return instance;
    }

    public interface Save{
        void onSave(String urlCard);
    }

    // TODO: 7/5/2021 Select & save only from BDD Cards
    // RequestManager.getInstance(context).addToRequestQueue(request);
    
}
