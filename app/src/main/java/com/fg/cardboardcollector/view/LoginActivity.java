package com.fg.cardboardcollector.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.fg.cardboardcollector.R;
import com.fg.cardboardcollector.controller.ConnexionController;
import com.fg.cardboardcollector.utils.JWTUtils;
import com.fg.cardboardcollector.view.fragment.LoginFragment;
import com.fg.cardboardcollector.view.fragment.RegisterFragment;

import java.util.ArrayList;
import java.util.Collection;

//sexy instagram login
public class LoginActivity extends AppCompatActivity {





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (JWTUtils.isTokenValide(this)) {
            startActivity(new Intent(this, CentralActivity.class));
        } else {
            setContentView(R.layout.activity_login);
            ViewPager viewPager = findViewById(R.id.viewPager);
            AuthenticationPagerAdapter pagerAdapter = new AuthenticationPagerAdapter(getSupportFragmentManager());
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