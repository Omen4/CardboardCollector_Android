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

public class CentralAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Card> mData;
    private Context mContext;
    private ClickListener clickListener;

    public  interface ClickListener{
        void onClickListener(Card card);
    }

    public CentralAdapter( Context mContext, List<Card> mData, ClickListener clickListener) {
        this.mContext = mContext;
        this.mData = mData;
        this.clickListener = clickListener;
    }

    public static class CardViewHolder extends RecyclerView.ViewHolder{

        TextView id;
        TextView name;
        ImageView img;

         public CardViewHolder(@NonNull View itemView){
             super(itemView);
             id = itemView.findViewById(R.id.textView_cardid);
             name = itemView.findViewById(R.id.textView_cardname);
             img = itemView.findViewById(R.id.imageView_cardimage);

         }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view = LayoutInflater
                .from(parent.getContext() )
                .inflate(R.layout.card_item, parent, false);
        return new CardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        CardViewHolder cardViewHolder = (CardViewHolder) holder;
        cardViewHolder.id.setText(mData.get(position).getCardId());
        cardViewHolder.name.setText(mData.get(position).getCardName());

        //Glide for image display
        Glide.with(mContext)
                .load(mData.get(position).getImage_url())
                .into(cardViewHolder.img);
    }


    @Override
    public int getItemCount() {
        return mData.size();
    }

}
