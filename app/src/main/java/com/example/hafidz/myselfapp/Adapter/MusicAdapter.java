package com.example.hafidz.myselfapp.Adapter;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.hafidz.myselfapp.Item.MusicItem;
import com.example.hafidz.myselfapp.MusicVideo.MusicFragment;
import com.example.hafidz.myselfapp.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MusicAdapter extends RecyclerView.Adapter<MusicAdapter.ViewHolder> {


    private Context context;
    private List<MusicItem> musicItems;

    public MusicAdapter(Context context, List<MusicItem> musicItems) {
        this.context = context;
        this.musicItems = musicItems;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.music_recycler, parent, false);
        ViewHolder holder = new ViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        MusicItem musicItem = musicItems.get(position);
        holder.txtTitle.setText(musicItem.getTitle());
        holder.txtArtist.setText(musicItem.getArtist());
        holder.txtAssetsTitle.setText(musicItem.getAssets_title());
        Glide.with(context).load(musicItem.getFotoMusic()).into(holder.imgMusic);
    }

    @Override
    public int getItemCount() {
        int ret = 0;
        if (musicItems != null) {
            ret = musicItems.size();
        }
        return ret;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        @BindView(R.id.txtTitle)
        TextView txtTitle;
        @BindView(R.id.txtArtist)
        TextView txtArtist;
        @BindView(R.id.imgMusic)
        ImageView imgMusic;
        @BindView(R.id.assets_title) TextView txtAssetsTitle;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            String title = txtTitle.getText().toString();
            String artist = txtArtist.getText().toString();
            String assets_title = txtAssetsTitle.getText().toString();
            String clicked = "clicked";

            MusicFragment fragment = new MusicFragment();
            Bundle bundle = new Bundle();
            bundle.putString("title", title);
            bundle.putString("artist", artist);
            bundle.putString("assets_title", assets_title);
            bundle.putString("clicked", clicked);
            fragment.setArguments(bundle);
            replace_fragment(fragment);
        }
    }

    public void replace_fragment(Fragment fragment) {
        FragmentTransaction transaction = ((AppCompatActivity)context).getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.framelayout, fragment);
        transaction.commit();
    }
}
