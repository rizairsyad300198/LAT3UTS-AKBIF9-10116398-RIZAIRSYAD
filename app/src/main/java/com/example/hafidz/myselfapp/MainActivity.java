package com.example.hafidz.myselfapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.hafidz.myselfapp.Home.InterestFragment;
import com.example.hafidz.myselfapp.Home.ProfilFragment;
import com.example.hafidz.myselfapp.Profil.ProfileFragment;
import com.example.hafidz.myselfapp.utils.Tools;

public class MainActivity extends AppCompatActivity {

    private ActionBar actionBar;
    private Toolbar toolbar;
    private BottomNavigationView navigation;
    private DrawerLayout drawer;
    private View navigation_header;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initToolbar();
        initNavigationMenu();
        initComponent();
        replace_fragment(new ProfilFragment());
    }

    private void initToolbar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setBackgroundColor(getResources().getColor(R.color.pink_600));
        setSupportActionBar(toolbar);
        actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeButtonEnabled(true);
        actionBar.setTitle("Home");
        Tools.setSystemBarColor(this, R.color.pink_700);
    }

    private void initNavigationMenu() {
        final NavigationView nav_view = (NavigationView) findViewById(R.id.nav_view);
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close) {
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }
        };
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        nav_view.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(final MenuItem item) {
                onItemNavigationClicked(item);
                return true;
            }
        });

        // navigation header
        navigation_header = nav_view.getHeaderView(0);
    }

    public boolean onItemNavigationClicked( MenuItem item) {
        item.setChecked(true);
        drawer.closeDrawers();

        switch(item.getItemId()){
            case R.id.home:
                return true;
            case R.id.daily_activity:
                intent = new Intent(this, DailyActivity.class);
                startActivity(intent);
                return true;
            case R.id.gallery:
                intent = new Intent(this, GalleryActivity.class);
                startActivity(intent);
                return true;
            case R.id.music_video:
                intent = new Intent(this, MusicVideoActivity.class);
                startActivity(intent);
                return true;
            case R.id.profile:
                intent = new Intent(this, ProfilActivity.class);
                startActivity(intent);
                return true;
        }
        return true;
    }

    public void replace_fragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.framelayout, fragment);
        transaction.commit();
    }

    private void initComponent() {

        navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.profile:
                        navigation.setBackgroundColor(getResources().getColor(R.color.pink_800));
                        replace_fragment(new ProfilFragment());
                        return true;
                    case R.id.interest:
                        navigation.setBackgroundColor(getResources().getColor(R.color.pink_800));
                        replace_fragment(new InterestFragment());
                        return true;
                }
                return false;
            }
        });
    }
}

