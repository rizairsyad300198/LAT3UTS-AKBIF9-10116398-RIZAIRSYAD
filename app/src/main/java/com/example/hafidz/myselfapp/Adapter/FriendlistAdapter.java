package com.example.hafidz.myselfapp.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.hafidz.myselfapp.Item.FriendlistItem;
import com.example.hafidz.myselfapp.R;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FriendlistAdapter extends RecyclerView.Adapter<FriendlistAdapter.ViewHolder> {


    private Context context;
    private List<FriendlistItem> friendlistItems;

    public FriendlistAdapter(Context context, List<FriendlistItem> friendlistItems) {
        this.context = context;
        this.friendlistItems = friendlistItems;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.friendlist_recycler, parent, false);
        ViewHolder holder = new ViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        FriendlistItem friendlistItem = friendlistItems.get(position);
        holder.txtNamaTeman.setText(friendlistItem.getNamaTeman());
        holder.txtInfoTeman.setText(friendlistItem.getInfoTeman());
        Glide.with(context).load(friendlistItem.getFotoTeman()).into(holder.imgFotoTeman);
    }

    @Override
    public int getItemCount() {
        int ret = 0;
        if(friendlistItems !=null)
        {
            ret = friendlistItems.size();
        }
        return ret;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        @BindView(R.id.txtNamaTeman) TextView txtNamaTeman;
        @BindView(R.id.txtInfoTeman) TextView txtInfoTeman;
        @BindView(R.id.imgFotoTeman) ImageView imgFotoTeman;

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
