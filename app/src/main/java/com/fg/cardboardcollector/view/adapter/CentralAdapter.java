package com.fg.cardboardcollector.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.fg.cardboardcollector.R;
import com.fg.cardboardcollector.model.Card;

import java.util.List;

public class CentralAdapter extends RecyclerView.Adapter<CentralAdapter.MyViewHolder> {

    private Context mContext;
    private List<Card> mData;

    public CentralAdapter(Context mContext, List<Card> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        LayoutInflater inflater = LayoutInflater.from(mContext);
        v = inflater.inflate(R.layout.card_item,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.id.setText(mData.get(position).getCardId());
        holder.name.setText(mData.get(position).getCardName());

        //Glide for image display
        Glide.with(mContext)
                .load(mData.get(position).getImage_url())
                .into(holder.img);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView id;
        TextView name;
        ImageView img;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            id = itemView.findViewById(R.id.textView_cardid);
            name = itemView.findViewById(R.id.textView_cardname);
            img = itemView.findViewById(R.id.imageView_cardimage);
        }
    }

}
