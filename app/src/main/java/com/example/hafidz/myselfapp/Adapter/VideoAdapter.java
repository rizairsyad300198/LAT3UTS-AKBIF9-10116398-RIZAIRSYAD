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
import com.example.hafidz.myselfapp.Item.VideoItem;
import com.example.hafidz.myselfapp.MusicVideo.MusicFragment;
import com.example.hafidz.myselfapp.MusicVideo.VideoFragment;
import com.example.hafidz.myselfapp.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.ViewHolder> {


    private Context context;
    private List<VideoItem> videoItems;

    public VideoAdapter(Context context, List<VideoItem> videoItems) {
        this.context = context;
        this.videoItems = videoItems;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.video_recycler, parent, false);
        ViewHolder holder = new ViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        VideoItem videoItem = videoItems.get(position);
        holder.txtTitle.setText(videoItem.getTitle());
        holder.txtInfo.setText(videoItem.getInfo());
        holder.txtAssetsTitle.setText(videoItem.getAssets_title());
        Glide.with(context).load(videoItem.getFotoVideo()).into(holder.imgVideo);
    }

    @Override
    public int getItemCount() {
        int ret = 0;
        if (videoItems != null) {
            ret = videoItems.size();
        }
        return ret;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        @BindView(R.id.txtTitle)
        TextView txtTitle;
        @BindView(R.id.txtInfo)
        TextView txtInfo;
        @BindView(R.id.imgVideo)
        ImageView imgVideo;
        @BindView(R.id.assets_title) TextView txtAssetsTitle;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            String title = txtTitle.getText().toString();
            String artist = txtInfo.getText().toString();
            String assets_title = txtAssetsTitle.getText().toString();
            String clicked = "clicked";

            VideoFragment fragment = new VideoFragment();
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

