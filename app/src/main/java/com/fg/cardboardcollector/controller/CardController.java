package com.fg.cardboardcollector.controller;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.fg.cardboardcollector.R;
import com.fg.cardboardcollector.model.Card;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    //choppe toutes les cartes dispo
    public void getCards(Context context, CardController.CardListener listener){
        JsonArrayRequest request = new JsonArrayRequest(
                Request.Method.GET,
                context.getResources().getString(R.string.server_ip) + "cards",
                null,
                (response) -> {
                    try{
                        List<Card> cardList = new ArrayList<Card>();
                        for (int i = 0; i< response.length(); i++){
                            JSONObject jsonObject =(JSONObject) response.get(i);
                            Card cardModel = new Card();
                            cardModel.setCardId(jsonObject.getInt("id"));
                            cardModel.setCardName(jsonObject.getString("name"));
                            cardModel.setImage_url(jsonObject.getString("image_url"));
                            cardList.add(cardModel);
                        }
                        listener.onCardListener(cardList);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                },
                (error) -> {
                    System.out.println(error);
                }){
                @Override
                public Map<String, String> getHeaders() throws AuthFailureError{
                    SharedPreferences preference = context.getSharedPreferences(
                            context.getResources().getString(R.string.fichier_preference), 0); // 0 - for private mode
                    String token = preference.getString("token","");
                    HashMap<String,String> params = new HashMap<>();
                    params.put("Content-Type", "application/json; charset=UTF-8");
                    params.put("Authorization", "Bearer " + token );
                    return params;
                }
        };
        RequestManager.getInstance(context).addToRequestQueue(request);
    }

    //choppe uniquement les cartes de l'utilisateur
    public void getCardsFromUser(Context context, CardController.CardListener listener){
        JsonArrayRequest request = new JsonArrayRequest(
                Request.Method.GET,
                context.getResources().getString(R.string.server_ip) + "user/mycollection/mycards",
                null,
                (response) -> {
                    try{
                        List<Card> cardList = new ArrayList<Card>();
                        for (int i = 0; i< response.length(); i++){
                            JSONObject jsonObject =(JSONObject) response.get(i);
                            Card cardModel = new Card();
                            cardModel.setCardId(jsonObject.getInt("id"));
                            cardModel.setCardName(jsonObject.getString("name"));
                            cardModel.setImage_url(jsonObject.getString("image_url"));
                            cardList.add(cardModel);
                        }
                        listener.onCardListener(cardList);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                },
                (error) -> {
                    System.out.println(error);
                }){
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError{
                SharedPreferences preference = context.getSharedPreferences(
                        context.getResources().getString(R.string.fichier_preference), 0); // 0 - for private mode
                String token = preference.getString("token","");
                HashMap<String,String> params = new HashMap<>();
                params.put("Content-Type", "application/json; charset=UTF-8");
                params.put("Authorization", "Bearer " + token );
                return params;
            }
        };
        RequestManager.getInstance(context).addToRequestQueue(request);
    }

    public void AddCardToCollection(Context context, CardController.OneCardListener listener, Card card){
        StringRequest request = new StringRequest(
                Request.Method.POST,
                context.getResources().getString(R.string.server_ip) + "card/"+ card.getCardId(),
                (response) -> {
                   listener.onOneCardListener(card);
                    Toast.makeText(context,"Carte ajoutée",Toast.LENGTH_SHORT).show();
                },
                (error) -> {
                    System.out.println("error");
                }){
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError{
                SharedPreferences preference = context.getSharedPreferences(
                        context.getResources().getString(R.string.fichier_preference), 0); // 0 - for private mode
                String token = preference.getString("token","");
                HashMap<String,String> params = new HashMap<>();
                params.put("Content-Type", "application/json; charset=UTF-8");
                params.put("Authorization", "Bearer " + token );
                return params;
            }
        };
        RequestManager.getInstance(context).addToRequestQueue(request);
    }

    public void RemoveCardToCollection(Context context, Card card){
        StringRequest request = new StringRequest(
                Request.Method.DELETE,
                context.getResources().getString(R.string.server_ip) + "card/"+ card.getCardId(),
                (response) -> {
                    Toast.makeText(context,"Carte supprimée",Toast.LENGTH_SHORT).show();
                    System.out.println("alrayt");
                },
                (error) -> {
                    System.out.println("error");
                }){
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError{
                SharedPreferences preference = context.getSharedPreferences(
                        context.getResources().getString(R.string.fichier_preference), 0); // 0 - for private mode
                String token = preference.getString("token","");
                HashMap<String,String> params = new HashMap<>();
                params.put("Content-Type", "application/json; charset=UTF-8");
                params.put("Authorization", "Bearer " + token );
                return params;
            }
        };
        RequestManager.getInstance(context).addToRequestQueue(request);
    }


    public interface CardListener{
        void onCardListener(List<Card> cardList);
    }

    public interface OneCardListener{
        void onOneCardListener(Card card);
    }

}
