package com.example.hafidz.myselfapp.Adapter;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.hafidz.myselfapp.R;
import com.example.hafidz.myselfapp.Item.DailyItem;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DailyAdapter extends RecyclerView.Adapter<DailyAdapter.ViewHolder> {


    private Context context;
    private List<DailyItem> dailyItems;

    public DailyAdapter(Context context, List<DailyItem> dailyItems) {
        this.context = context;
        this.dailyItems = dailyItems;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.daily_recycler, parent, false);
        ViewHolder holder = new ViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        DailyItem dailyItem = dailyItems.get(position);
        holder.txtNamaKegiatan.setText(dailyItem.getNamaKegiatan());
        holder.txtJamKegiatan.setText(dailyItem.getJamKegiatan());
        Glide.with(context).load(dailyItem.getImgFotoKegiatan()).into(holder.imgFotoKegiatan);
    }

    @Override
    public int getItemCount() {
        int ret = 0;
        if(dailyItems !=null)
        {
            ret = dailyItems.size();
        }
        return ret;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        @BindView(R.id.txtNamaKegiatan) TextView txtNamaKegiatan;
        @BindView(R.id.txtJamKegiatan) TextView txtJamKegiatan;
        @BindView(R.id.imgFotoKegiatan) ImageView imgFotoKegiatan;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
        }
    }

}
