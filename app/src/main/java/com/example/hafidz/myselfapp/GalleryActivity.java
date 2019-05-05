package com.example.hafidz.myselfapp;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.hafidz.myselfapp.Adapter.FriendlistAdapter;
import com.example.hafidz.myselfapp.Adapter.GalleryAdapter;
import com.example.hafidz.myselfapp.Item.FriendlistItem;
import com.example.hafidz.myselfapp.Item.GalleryItem;
import com.example.hafidz.myselfapp.utils.Tools;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GalleryActivity extends AppCompatActivity {

    private List<GalleryItem> galleryitems = null;
    @BindView(R.id.recyclerView) RecyclerView recyclerView;
    private ActionBar actionBar;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);
        ButterKnife.bind(this);

        initToolbar();
        loadDataGallery();

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        GalleryAdapter GalleryDataAdapter = new GalleryAdapter(getApplicationContext(), galleryitems);
        recyclerView.setAdapter(GalleryDataAdapter);
    }

    private void initToolbar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setBackgroundColor(getResources().getColor(R.color.pink_600));
        setSupportActionBar(toolbar);
        actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeButtonEnabled(true);
        actionBar.setTitle("Gallery");
        Tools.setSystemBarColor(this, R.color.pink_700);
    }

    public void loadDataGallery() {
        galleryitems = new ArrayList<GalleryItem>();
        galleryitems.add(new GalleryItem("Labuan Bajo", "8 Mei 2017", R.drawable.img_labuanbajo));
        galleryitems.add(new GalleryItem("Cikuray", "28 Juni 2017", R.drawable.img_cikuray));
        galleryitems.add(new GalleryItem("Rinjani", "23 Januari 2018", R.drawable.img_rinjani));
        galleryitems.add(new GalleryItem("Merbabu", "25 April 2018", R.drawable.img_merbabu));
        galleryitems.add(new GalleryItem("Danau Segara Anak", "27 November 2018", R.drawable.img_danau));
        galleryitems.add(new GalleryItem("Ranukumbolo", "17 Februari 2019", R.drawable.img_ranukumbolo));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        } else {
            Toast.makeText(getApplicationContext(), item.getTitle(), Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }
}
