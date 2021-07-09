package com.fg.cardboardcollector.view;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.AsyncTask;
import android.os.Bundle;

import com.fg.cardboardcollector.R;
import com.fg.cardboardcollector.model.Card;
import com.fg.cardboardcollector.view.adapter.CentralAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class CentralActivity extends AppCompatActivity {

    private static String JSON_URL = "https://db.ygoprodeck.com/api/v7/cardinfo.php?archetype=Noble%20Knight";

    List<Card> cardList;
    RecyclerView recyclerViewCentral;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_central);
        cardList = new ArrayList<>();
        recyclerViewCentral= findViewById(R.id.recyclerView_central);

        //async class call
        GetData getData = new GetData();
        getData.execute();
    }

    public class GetData extends AsyncTask<String, String, String>{

        @Override
        protected String doInBackground(String... strings) {
            String current = "";
            try{
                URL url;
                HttpURLConnection urlConnection = null;
                try{
                    url = new URL(JSON_URL);
                    urlConnection = (HttpURLConnection)url.openConnection();

                    InputStream is = urlConnection.getInputStream();
                    InputStreamReader isr = new InputStreamReader(is);

                    int data = isr.read();
                    while(data != -1){
                        current += (char)data;
                        data = isr.read();
                    }
                    return current;

                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    if (urlConnection != null){
                        urlConnection.disconnect();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return current;
        }

        @Override
        protected void onPostExecute(String s) {
            try{

                JSONObject jsonObject = new JSONObject(s);
                JSONArray jsonArray = jsonObject.getJSONArray("data");
                for(int i = 0; i< jsonArray.length(); i++){
                    JSONObject jsonSubObject = jsonArray.getJSONObject(i);

                    Card card = new Card();
                    card.setId(jsonSubObject.getInt("id"));
                    card.setCardName(jsonSubObject.getString("name"));
                    card.setImage_url(jsonSubObject.getString("image_url"));
                    cardList.add(card);

                }

            } catch (JSONException e) {
                e.printStackTrace();
            }

            PutDataIntoRecyclerView(cardList);
        }

    }
    private void PutDataIntoRecyclerView(List<Card> cardList){
        CentralAdapter centralAdapter = new CentralAdapter(this, cardList);
        recyclerViewCentral.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewCentral.setAdapter(centralAdapter);
    }
}