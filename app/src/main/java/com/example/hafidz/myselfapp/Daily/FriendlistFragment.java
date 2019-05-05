package com.example.hafidz.myselfapp.Daily;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.hafidz.myselfapp.Adapter.FriendlistAdapter;
import com.example.hafidz.myselfapp.Item.DailyItem;
import com.example.hafidz.myselfapp.Item.FriendlistItem;
import com.example.hafidz.myselfapp.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FriendlistFragment extends Fragment {

    private View view;
    private List<FriendlistItem> friendlistItems = null;

    @BindView(R.id.recyclerView) RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_friendlist, container, false);
        ButterKnife.bind(this, view);

        loadDataFriendlist();

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        FriendlistAdapter FriendlistDataAdapter = new FriendlistAdapter(getContext(), friendlistItems);
        recyclerView.setAdapter(FriendlistDataAdapter);

        return view;
    }

    public void loadDataFriendlist() {
        friendlistItems = new ArrayList<FriendlistItem>();
        friendlistItems.add(new FriendlistItem("Hafidz Muhammad Sopian", "Teman Sekampung", R.drawable.img_hafidz));
        friendlistItems.add(new FriendlistItem("Anzar Paksi Akasa Dwara Asta", "Teman Sekampung", R.drawable.img_ajay));
        friendlistItems.add(new FriendlistItem("Afrizal M", "Teman Sekampung", R.drawable.img_afrizal));
        friendlistItems.add(new FriendlistItem("Zepri Yanto", "Teman Sekampung", R.drawable.img_zepri));
        friendlistItems.add(new FriendlistItem("Akbar Fachrulrozi", "Teman Sekampung", R.drawable.img_abay));
    }

}
