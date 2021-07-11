package com.fg.cardboardcollector.view;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.fg.cardboardcollector.R;
import com.fg.cardboardcollector.model.Card;
import com.fg.cardboardcollector.utils.JWTUtils;
import com.fg.cardboardcollector.view.adapter.CentralAdapter;
import com.fg.cardboardcollector.view.fragment.LoginFragment;
import com.fg.cardboardcollector.view.fragment.RegisterFragment;

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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (JWTUtils.isTokenValide(this)) {
            startActivity(new Intent(this, CentralActivity.class));
        } else {
            setContentView(R.layout.activity_central);
            ViewPager viewPager = findViewById(R.id.viewPager);
            CentralActivity.AuthenticationPagerAdapter pagerAdapter = new CentralActivity.AuthenticationPagerAdapter(getSupportFragmentManager());
            pagerAdapter.addFragmet(new LoginFragment());
            pagerAdapter.addFragmet(new RegisterFragment());
            viewPager.setAdapter(pagerAdapter);

        }
    }


    class AuthenticationPagerAdapter extends FragmentPagerAdapter {

        private ArrayList<Fragment> fragmentList = new ArrayList<>();

        public AuthenticationPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int i) {
            return fragmentList.get(i);
        }

        @Override
        public int getCount() {
            return fragmentList.size();
        }

        void addFragmet(Fragment fragment) {
            fragmentList.add(fragment);
        }
    }

}
//
//            try{
//                JSONObject jsonObject = new JSONObject(s);
//                JSONArray jsonArray = jsonObject.getJSONArray("data");
//
//                for (int i = 0; i< jsonArray.length(); i++){
//                    JSONObject subJsonObject = jsonArray.getJSONObject(i);
//                    Card cardModel = new Card();
//                    cardModel.setCardId(subJsonObject.getInt("id"));
//                    cardModel.setCardName(subJsonObject.getString("name"));
//                    cardModel.setImage_url(subJsonObject.getString("image_url"));
//
//                    cardList.add(cardModel);
//                }
//            } catch (JSONException e) {
//                e.printStackTrace();
//            }
//
//            PutDataIntoRecyclerView(cardList);
//        }

