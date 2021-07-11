package com.fg.cardboardcollector.view;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.fg.cardboardcollector.R;
import com.fg.cardboardcollector.view.fragment.CardDatabaseFragment;
import com.fg.cardboardcollector.view.fragment.MyCollectionFragment;

import java.util.ArrayList;

public class CentralActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_central);
        ViewPager viewPager = findViewById(R.id.viewPagerCentral);
        CentralActivity.AuthenticationPagerAdapter pagerAdapter = new CentralActivity.AuthenticationPagerAdapter(getSupportFragmentManager());
        pagerAdapter.addFragmet(new CardDatabaseFragment());
        pagerAdapter.addFragmet(new MyCollectionFragment());
        viewPager.setAdapter(pagerAdapter);
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


