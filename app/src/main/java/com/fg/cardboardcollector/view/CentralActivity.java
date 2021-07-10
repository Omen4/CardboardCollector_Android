package com.fg.cardboardcollector.view;

import android.os.AsyncTask;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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

    //private String jsonUrl = "https://db.ygoprodeck.com/api/v7/cardinfo.php";
    private String jsonUrl = "https://db.ygoprodeck.com/api/v7/cardinfo.php?archetype=Noble%20Knight";
    private RecyclerView recyclerViewCentral;
    List<Card> cardList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_central);
        cardList = new ArrayList<>();
        recyclerViewCentral = findViewById(R.id.recyclerView_central);

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
                    url = new URL(jsonUrl);
                    urlConnection = (HttpURLConnection) url.openConnection();

                    InputStream is = urlConnection.getInputStream();
                    InputStreamReader isr = new InputStreamReader(is);

                    int data = isr.read();
                    while(data != -1){
                        current +=(char) data;
                        data = isr.read();
                    }
                    return current;
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();

                }finally {
                    if(urlConnection != null) {
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

                for (int i = 0; i< jsonArray.length(); i++){
                    JSONObject subJsonObject = jsonArray.getJSONObject(i);
                    Card cardModel = new Card();
                    cardModel.setCardId(subJsonObject.getInt("id"));
                    cardModel.setCardName(subJsonObject.getString("name"));
                    cardModel.setImage_url(subJsonObject.getString("image_url"));
                    cardList.add(cardModel);
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
    }


//    private void init(){
//        setContentView(R.layout.activity_central);
//
//        recyclerViewCentral = findViewById(R.id.recyclerView_central);
//        recyclerViewCentral.setLayoutManager(new LinearLayoutManager(this));
//
//        UtilisateurController.getInstance().getUtilisateurConnecte(
//                this,
//                (utilisateur ->{
//                    recyclerViewUserCentral.setAdapter(
//                            new UserCentralAdapter()
//                    );
//                }
//        );
//    }
}
