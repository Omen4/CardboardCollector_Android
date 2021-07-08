package com.fg.cardboardcollector.controller;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;

public class RequestManager {

    private static RequestManager instance = null;
    private Context context;
    private RequestQueue requestQueue;
    private ImageLoader imageLoader;

    private RequestManager(Context context){
        this.context = context;
        this.requestQueue = getRequestQueue();
    }

    private RequestQueue getRequestQueue(){
        if(requestQueue == null){
//            instance = new RequestManager(context);
            requestQueue = Volley.newRequestQueue(context.getApplicationContext());
        }
        return requestQueue;
    }

    public static synchronized RequestManager getInstance(Context context){
        if (instance == null){
            instance = new RequestManager(context);
        }
        return instance;
    }

    //Fonc to call in every controller to add task
    public void addToRequestQueue(Request request){
        getRequestQueue().add(request);
    }
}
