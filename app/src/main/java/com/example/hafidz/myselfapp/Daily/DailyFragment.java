package com.example.hafidz.myselfapp.Daily;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hafidz.myselfapp.Adapter.DailyAdapter;
import com.example.hafidz.myselfapp.R;
import com.example.hafidz.myselfapp.Item.DailyItem;

import java.util.ArrayList;
import java.util.List;


import butterknife.BindView;
import butterknife.ButterKnife;

public class DailyFragment extends Fragment {

    private View view;
    private List<DailyItem> DailyItem = null;

    @BindView(R.id.recyclerView) RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_daily, container, false);
        ButterKnife.bind(this, view);

        loadDataDaily();

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        DailyAdapter DailyDataAdapter = new DailyAdapter(getContext(), DailyItem);
        recyclerView.setAdapter(DailyDataAdapter);

        return view;
    }

    public void loadDataDaily() {
            DailyItem = new ArrayList<DailyItem>();
            DailyItem.add(new DailyItem("Sarapan", "07:00", R.drawable.img_breakfast));
            DailyItem.add(new DailyItem("Ngampus", "07:30", R.drawable.img_unikom));
            DailyItem.add(new DailyItem("Main Game", "16:00", R.drawable.img_dota));
            DailyItem.add(new DailyItem("Nugas", "18:30", R.drawable.img_ngoding));
            DailyItem.add(new DailyItem("Tidur", "21:30", R.drawable.img_sleep));
    }
}
