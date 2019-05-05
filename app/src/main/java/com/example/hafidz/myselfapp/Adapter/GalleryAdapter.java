package com.example.hafidz.myselfapp.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.hafidz.myselfapp.Item.GalleryItem;
import com.example.hafidz.myselfapp.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GalleryAdapter extends RecyclerView.Adapter<GalleryAdapter.ViewHolder> {


    private Context context;
    private List<GalleryItem> galleryItems;

    public GalleryAdapter(Context context, List<GalleryItem> galleryItems) {
        this.context = context;
        this.galleryItems = galleryItems;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.gallery_grid, parent, false);
        ViewHolder holder = new ViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        GalleryItem galleryItem = galleryItems.get(position);
        holder.txtNamaFoto.setText(galleryItem.getNamaFoto());
        holder.txtInfoFoto.setText(galleryItem.getInfoFoto());
        Glide.with(context).load(galleryItem.getFoto()).into(holder.imgFoto);

    }

    @Override
    public int getItemCount() {
        int ret = 0;
        if(galleryItems !=null)
        {
            ret = galleryItems.size();
        }
        return ret;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        @BindView(R.id.txtNamaFoto) TextView txtNamaFoto;
        @BindView(R.id.txtInfoFoto) TextView txtInfoFoto;
        @BindView(R.id.imgFoto) ImageView imgFoto;

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
