//package com.fg.cardboardcollector.view;
//
//import androidx.annotation.NonNull;
//import androidx.appcompat.app.ActionBarDrawerToggle;
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.core.view.GravityCompat;
//import androidx.drawerlayout.widget.DrawerLayout;
//
//import android.os.Bundle;
//import android.view.MenuItem;
//import android.widget.Toolbar;
//
//import com.fg.cardboardcollector.R;
//import com.fg.cardboardcollector.view.fragment.CardDatabaseFragment;
//import com.fg.cardboardcollector.view.fragment.MyCollectionFragment;
//import com.fg.cardboardcollector.view.fragment.ProfileFragment;
//import com.google.android.material.navigation.NavigationView;
//
//public class MenuActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
//    private DrawerLayout drawer;
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
////        setContentView(R.layout.activity_menu);
////        Toolbar toolbar = findViewById(R.id.toolbar);
////        setSupportActionBar(toolbar);
////        drawer = findViewById(R.id.drawer_layout);
////        NavigationView navigationView = findViewById(R.id.nav_view);
////        navigationView.setNavigationItemSelectedListener(this);
////        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
////                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
////        drawer.addDrawerListener(toggle);
////        toggle.syncState();
//    }
//
//    private void setSupportActionBar(Toolbar toolbar) {
//    }
//
//    @Override
//    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//        switch (item.getItemId()) {
//            case R.id.nav_carddatabase:
//                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
//                        new CardDatabaseFragment()).commit();
//                break;
//            case R.id.nav_mycollection:
//                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
//                        new MyCollectionFragment()).commit();
//                break;
//            case R.id.nav_profile:
//                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
//                        new ProfileFragment()).commit();
//                break;
//        }
//        drawer.closeDrawer(GravityCompat.START);
//        return true;
//    }
//    @Override
//    public void onBackPressed() {
//        if (drawer.isDrawerOpen(GravityCompat.START)) {
//            drawer.closeDrawer(GravityCompat.START);
//        } else {
//            super.onBackPressed();
//        }
//    }
//
//}